/*  ----------  GLOBAL CONFIG  ---------- */
const API = 'http://localhost:8080/api';
const AUTH = `${API}/auth`;
const store = window.localStorage;

/*  ----------  DOM ELEMENTS  ---------- */
const loginForm   = document.getElementById('login-form');
const registerForm= document.getElementById('register-form');
const showLoginBtn   = document.getElementById('show-login');
const showRegisterBtn= document.getElementById('show-register');

const loginMsg = document.getElementById('login-msg');
const regMsg   = document.getElementById('reg-msg');

/*  ----------  TAB TOGGLE  ---------- */
showLoginBtn.addEventListener('click', () => toggle(true));
showRegisterBtn.addEventListener('click', () => toggle(false));

function toggle(showLogin) {
  loginForm.classList.toggle('hidden', !showLogin);
  registerForm.classList.toggle('hidden', showLogin);
  showLoginBtn.classList.toggle('active', showLogin);
  showRegisterBtn.classList.toggle('active', !showLogin);
  loginMsg.textContent = '';
  regMsg.textContent   = '';
}

/*  ----------  REGISTER  ---------- */
registerForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  regMsg.textContent = 'Creating account…';

  const payload = {
    username: document.getElementById('reg-username').value.trim(),
    email:    document.getElementById('reg-email').value.trim(),
    password: document.getElementById('reg-password').value
  };

  try {
    const res = await fetch(`${AUTH}/register`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    });

    if (!res.ok) throw new Error(await res.text());
    const data = await res.json();           // { id, username, email }

    // Automatically log the user in after successful registration
    await loginUser(payload.username, payload.password, data.id);

  } catch (err) {
    regMsg.textContent = err.message || 'Registration failed';
  }
});

/*  ----------  LOGIN  ---------- */
loginForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  loginMsg.textContent = 'Authenticating…';

  const user = document.getElementById('login-username').value.trim();
  const pass = document.getElementById('login-password').value;
  await loginUser(user, pass);        // userId will be looked up later if not provided
});

async function loginUser(username, password, userId = null) {
  try {
    const res = await fetch(`${AUTH}/login`, {
      method : 'POST',
      headers: { 'Content-Type': 'application/json' },
      body   : JSON.stringify({ username, password })
    });
    if (!res.ok) throw new Error('Invalid credentials');
    const { token } = await res.json();

    // Persist auth data
    store.setItem('jwt',  token);
    if (userId) store.setItem('uid', userId);

    // Go to dashboard
    window.location.href = 'dashboard.html';
  } catch (err) {
    loginMsg.textContent = err.message || 'Login failed';
  }
}

/*  ----------  INITIAL STATE  ---------- */
toggle(true);          // Show login form by default
