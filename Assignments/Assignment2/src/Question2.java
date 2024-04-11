import java.util.Scanner;

public class Question2 {

    /*
     * Write a function that finds the first non-repeating character in a string and returns its index. 
     * If it doesn't exist, return -1.
     */


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input a string:");
        String input = scan.nextLine();
        
        System.out.println();
        System.out.println("\" " + input + " \"");
        System.out.println("first non-repeating char index => " + firstUniqueChar(input));

        
    }

    public static int firstUniqueChar(String str){
        boolean isRepeated = false;
        

        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j) && j != i){
                    isRepeated = true;
                }
            }

            if(!isRepeated){
                return i;
            }
            isRepeated = false;
        }

        return -1;
    }

}
