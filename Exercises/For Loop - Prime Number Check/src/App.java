import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scan.nextInt();
        int divideCount = 1;
        scan.nextLine();
        scan.close();

        //for (int i = 1; i <= number; i++) {
        //    if (number % i == 0) {
        //        divideCount++;
        //    }
        //}

        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0)
                divideCount++;
        }


        if (divideCount == 2) 
            System.out.println("This is a prime number!");
        else 
            System.out.println("This is NOT a prime number!");
        

        // How to optimise this program?

        //this code runs "n" times. And we can make it more optimal. Since the lowest multiplier is 2,
        //we dont need to check if there is anything that can  divide the number, since it will be a failiure. 
        //So we can use number/2, making it so there's half less to check, which is making the code more optimal.

        //Also we will be starting divide count from 1 instead of 0 if we use the optimal method. 
        //Since we would not be checking if number can be divided by number with this new code.

        //Also closing the scan makes the code a little more lightweight.




        // Multidimensional Arrays

        /*
         * Multidimensional Arrays are like normal arrays, but we can think it is like an array of arrays.
         * We can create 2 dimentional arrays like this:
         * 
         * int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };         //This creates something like this:          
         *                                                                  [1] [2] [3] [4]
         *                                                                  [5] [6] [7] 

         * int[][] myNumbers = new int [2][4];                      //This creates something like this:
         *                                                                  [0] [0] [0] [0]
         *                                                                  [0] [0] [0] [0] 
         * 
         * 
         * The "[]" before a thing makes so its an array of that thing.
         * like, if we write int[][], this is now an array, of arrays.
         * 
         * if we take one more step, we can make int[][][],
         * this would be an array, of arrays of arrays. And it goes on. 
         */



         
        /*
         * We can output/search multidimentional arrays in a for loop, inside a for loop.
         * if its 2D, we only use 2 for loops, if its 3D, we use 3 loops etc.
         * 
         * int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
         * System.out.println();
         * System.out.println("This array is:");
         * for (int i = 0; i < myNumbers.length; ++i) {
         *    for(int j = 0; j < myNumbers[i].length; ++j) {
         *      System.out.println(myNumbers[i][j]);
         *    }
         * }
         */

        /*
         * if we create an array by giving some value, it not create like a matris (if we dont give exact array lengths)
         * 
         * int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
         * 
         * System.out.println("This will explode!");
         * System.out.println(myNumbers[1][3]);                 //index out of bound, since second array only goes up to 3 .
         */
    }
}
