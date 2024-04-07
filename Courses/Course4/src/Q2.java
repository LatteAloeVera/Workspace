/**
 * Q2
 */
public class Q2 {

    public static void main(String[] args) {
        String testStr = "Hello, world!";
        System.out.println(reverseSubstring(testStr, 7, 12));
    }

    /*
     * 
     * Substring Reversal:
     * Implement a method reverseSubstring that reverses a substring within a
     * string. The method should take a string and two indices:
     * start and end, and it should reverse the portion of the string between these
     * indices.
     * 
     * ödevler 0 3    7
     * 
     * vedöler
     * 
     */

    public static String reverseSubstring(String str, int start, int end) {
        // Validate input
        if (str == null || start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid start or end indices.");
        }

        // Extract the parts of the string
        String before = str.substring(0, start);
        String toReverse = str.substring(start, end);
        String after = str.substring(end);

        // Reverse the 'toReverse' part
        String reversed = new StringBuilder(toReverse).reverse().toString();

        // Concatenate the parts and return the result
        return before + reversed + after;
    }
    
    public static String reverseSubstring2(String str, int start, int end) {
        if(str.length() <= end){
            return "END INDEX OUT OF BOUND";
        }
        if(start < 0){
            return "START INDEX OUT OF BOUND";
        }
        if(start >= end){
            return "START INDEX CANT BE BIGGER THAN END INDEX";
        }

        int strLength =(end + 1) - start;
        char[] reverseSubstr = new char[strLength];
        char[] afterReverseSubstr;
        char[] beforeReverseSubstr;
        String afterPart = "";
        String beforePart = "";
        
        if(str.length() - strLength - start > 0){
            afterReverseSubstr = new char[str.length() - strLength - start];
            
            for(int i = 0; i < str.length()-strLength; i++ ){
                afterReverseSubstr[i] = str.charAt(end + i);
            }
            
            afterPart = new String(afterReverseSubstr);
        }

        if(start > 0){
            beforeReverseSubstr = new char[start];
            for(int i = 0; i < start; i++){
                beforeReverseSubstr[i] = str.charAt(i);
            }

            beforePart = new String(beforeReverseSubstr);
        }
        char temp;  


        for (int i = 0; i < strLength; i++){
            reverseSubstr[i] = str.charAt(start + i);      
        }


        for (int i = 0; i < strLength / 2; i++) {
            temp = reverseSubstr[strLength - i - 1];
            reverseSubstr[strLength - i - 1] = reverseSubstr[i];
            reverseSubstr[i] = temp;
        }
        
        String reversedPart = new String(reverseSubstr); 
       
        String answer = beforePart + reversedPart + afterPart;

        return answer;
    

    }

}