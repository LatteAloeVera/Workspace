public class App {
    public static void main(String[] args) throws Exception {
        
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                System.out.println("          <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3");
            }
            if ((i / 10) % 2 == 0) {
                for (int j = 9; j > i % 10; j--) {
                    System.out.print(" ");
                }
            }
            else {
                for (int j = 0; j < i % 10; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println("I love you so much my cutie <3");

        }
        System.out.println("          <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3");
        
    }
}
