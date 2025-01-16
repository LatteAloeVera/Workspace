import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * RealCalculator
 */
public class RealCalculator extends JFrame implements ActionListener{

    private JTextField display;
    private JPanel buttonPanel;
    private double result;
    private String lastCommand;
    private boolean startOfNumber = true;

    public RealCalculator() {
        super("Real Calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        display = new JTextField("0");
        display.setEnabled(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4,5,5));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            addButton(buttonPanel, label);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,350);
        setVisible(true);
    }

    public void addButton(Container container, String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        container.add(button);
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        if (command.equals("C")){
            startOfNumber = true;
            display.setText("0");
            result = 0;
        }
        else if(command.equals("=")){
            lastCommand = "=";
            calculate(Double.parseDouble(display.getText()));
        }
        else if("0123456789".contains(command)){
            if (startOfNumber){
                display.setText(command);    
            }
            else{
                display.setText(display.getText() + command);
            }
            startOfNumber = false;
        }
        else{
            if (!startOfNumber){
                lastCommand = command;
                calculate(Double.parseDouble(display.getText()));
                startOfNumber = true;
            }
        }  
    }

    private void calculate(double x){
        if (lastCommand.equals("+")){
            result += x;
        }
        else if (lastCommand.equals("-")){
            result -= x;
        }
        else if (lastCommand.equals("*")){
            result *= x;
        }
        else if (lastCommand.equals("/")){
            result /= x;
        }
        else if (lastCommand.equals("=")){
            result = x;
        }
        display.setText("" + result);
    }

    public static void main(String[] args) {
        new RealCalculator();
    }

    /*
        School management system

        1. Login screen olacak (kullanici bilgileri dosyada tutulacak)
        2. Register screen olacak (kullanici bilgileri dosyada tutulacak)
        3. Admin ve ogrenci olacak
        4. Admin ekraninda ogrenci ekleme, silme, guncelleme, ders ekleme, silme, guncelleme olacak
        5. Ogrenci ekraninda ders ekleme, silme, guncelleme olacak
        6. Derslerin notlarini goruntuleme olacak
        7. Sifre degistirme olacak
    */
}