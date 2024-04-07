import java.time.temporal.Temporal;

public class Q4 {
    public static void main(String[] args) {
        System.out.println(countVowels("Hello World!"));
    }


    /*
        
        Count Vowels and Consonants:
        Create a method that counts the number of vowels in a given string and returns the count.
    
    */

    public static int countVowels(String str){
        int vowelCount = 0;
       
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if("aeiouAEIOU".contains(String.valueOf(temp))){
                vowelCount++;
            }
        }

        return vowelCount;
    }

}
