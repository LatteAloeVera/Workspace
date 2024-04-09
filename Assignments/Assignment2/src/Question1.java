import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the lenght of the array: ");
        
        int lenght = scan.nextInt();
        scan.nextLine();
        int[] array = new int[lenght];
        
        //filling inside of the array from the user.
        for(int i = 0; i < array.length; i++){
            System.out.println();
            System.out.print("Enter a number: ");
            array[i] = scan.nextInt();
            scan.nextLine();
        }

        findDuplicates(array);
        
    }

    //Finds the duplicates on an array and writes it on console.
    public static void findDuplicates(int[] arr){
        int dupCounter = 0; 
        int dupAmount = 0;

        System.out.println();
        System.out.println("********************************************************************************");
        System.out.print("*     In this array, ");

        //looks for any duplicates..
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    dupCounter++;
                }
            } 
            //if there is any duplicates, it writes it.
            if(dupCounter == 2){
                dupAmount++;
                System.out.print(arr[i] + " ");
            }
            dupCounter = 0;
        }

        if(dupAmount > 0){
            System.out.println("are the numbers that are duplicated in this array.    *");
        }
        else{
            System.out.println("there is no numbers that are duplicated in this array.    *");
        }
        
        System.out.println("********************************************************************************");
        System.out.println();
    }

}
