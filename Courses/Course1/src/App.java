import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // // name, surname, age
        // String name = "Ayberk";
        // String surname = "Sevgi";
        // int age = 20;

        // // Name: Ayberk

        // System.out.println("Name: " + name); //you can use "sout"
        // System.out.println("Surname: " + surname);
        // System.out.println("Age: " + age);

        // How to create an object
        // Classname objName = new ClassName();

        // name, surname, age, gender, weight, height

        // Scanner scan = new Scanner(System.in);
        // System.out.print("Name:");
        // String name = scan.nextLine();

        // System.out.print("Surname:");
        // String surname = scan.nextLine();

        // System.out.print("Age:");
        // int age = scan.nextInt(); // '\n' stays in there so we need to clear it
        // scan.nextLine();

        // System.out.print("Gender (m/f):"); // "M".charAt(0) ==> 'M'
        // char gender = scan.nextLine().charAt(0);

        // System.out.print("Weight:");
        // float weight = scan.nextFloat();

        // System.out.print("Height:");
        // double height = scan.nextDouble();

        // System.out.println(" ---------------------------------------------------- ");

        // System.out.println("Your name is: " + name);
        // System.out.println("Your age is: " + surname);
        // System.out.println("Your gender is: " + gender);
        // System.out.println("Your weight is: " + weight);
        // System.out.println("Your height is: " + height);


        /*
                            OPERATORS
        
            1. Arithmetic Operators
            2. Assignment Operators
            3. Relational Operators
            4. Logical Operators  
        
        */
       
       /*
                1. Arithmetic Operators
                
                Operator                Operation
                    +                   Addition
                    -                   Subtraction
                    *                   Multiplication
                    /                   Division
                    %                   Modulo Operation (Remainder after division)
       */

    //    // declare variables
    //    int a = 12, b = 5;

    //    // addition operator
    //    System.out.println("a + b = " + (a + b));    //17

    //    // subtraction operator
    //    System.out.println("a - b = " + (a - b));    //7

    //    // multiplication operator
    //    System.out.println("a * b = " + (a * b));    //60

    //    // division operator
    //    System.out.println("a / b = " + ((double)a / (double)b));    //2

    //    // modulo operator
    //    System.out.println("a % b = " + (a % b));    //2

        /*
            2. Assignment Operators
            
            Operator                    Example                     Equivalent To
                =                       a = b;                      a = b;
                +=                      a += b;                     a = a + b;
                -=                      a -= b;                     a = a - b;
                *=                      a *= b;                     a = a * b;
                /=                      a /= b;                     a = a / b;
                %=                      a %= b;                     a = a % b;
        */
       
        // int a = 4;
        // int var;

        // var = a;
        // System.out.println("var using =: " + var);  //4

        // var += a;
        // System.out.println("var using +=: " + var); //8

        // var *= a;
        // System.out.println("var using *=: " + var); //32

        /*
        
            3. Relational Operators
            
            Operator                    Description                 Example
                ==                      Is equal to                 3 == 5 return false
                !=                      Not equal to                3 != 5 return true
                >                       Greater than                3 > 5  return false
                <                       Less than                   3 < 5  return true
                >=                      Greater than or equal to    3 >= 5 return false
                <=                      Less than or equal to       3 <= 5 return true
        */

        // // create variables
        // int a = 7, b = 11;

        // // value of a and b
        // System.out.println("a is " + a + " and b is " + b); //7 11

        // // == operator
        // System.out.println(a == b); //false

        // // != operator
        // System.out.println(a != b); //true

        // // > operator
        // System.out.println(a > b);  //false

        // // < operator
        // System.out.println(a < b);  //true

        // // >= operator
        // System.out.println(a >= b); //false

        // // <= operator
        // System.out.println(a <= b); //true

        /*
            4. Logical Operators
            
            Operator                Example                                 Meaning
               &&                exp1 && exp2               true only if both expressions are true
               ||                exp1 || exp2               true if any expression is true
               !                     !exp                   true if exp is false, and vice versa
        */

        // // && operator
        // System.out.println((5 > 3) && (8 > 5)); //true
        // System.out.println((5 > 3) && (8 < 5)); //false

        // // || operator
        // System.out.println((5 < 3) || (8 > 5)); //true
        // System.out.println((5 > 3) || (8 < 5)); //true
        // System.out.println((5 < 3) || (8 < 5)); //false

        // // ! operator
        // System.out.println(!(5 == 3));  //true
        // System.out.println(!(5 > 3));   //false

        /*
            5. Increment & Decrement Operators
            
            Operator                    Meaning
               ++                       Increment operator: increments value by 1
               --                       Decrement operator: decrements value by 1
        */

        // int a = 5, b = 5, c = 5, d = 5;

        // System.out.println("A++: " + a++);  //5
        // System.out.println("++B: " + ++b);  //6
        // System.out.println("C--: " + c--);  //5
        // System.out.println("--D: " + --d);  //4

        /*
            6. Other Operators
            
            A. instanceOf operator
        */

        // String str = "Ayberk";
        // System.out.println(str instanceof String);

        /*
            B. Ternary Operator
        
            variable = Expression ? expression1:expression2;
        */

        // int februaryDays = 28;
        // String result;

        // result = (februaryDays == 29) ? "Not a leap year" : "Leap Year";
        // System.out.println(result);
    }
}
