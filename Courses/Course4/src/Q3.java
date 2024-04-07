/**
 * Q3
 */
public class Q3 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // Expected: true amanaplanacanalpanama
        System.out.println(isPalindrome("race a car")); // Expected: false
    }
    /*
        Palindrome Checker:
        Implement a method that checks whether a given string is a palindrome (reads the same backward as forward, ignoring case and whitespace).
    */

    public static boolean isPalindrome(String str){
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");
        cleaned = cleaned.toLowerCase();

        for(int i = 0; i < cleaned.length() / 2; i++){
            if (cleaned.charAt(i) != cleaned.charAt(cleaned.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

}
