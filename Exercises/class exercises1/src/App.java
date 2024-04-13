public class App {
    public static void main(String[] args) {
        // Creating instances of each type of vehicle
        Car car = new Car("Toyota", "Camry", 2022, 0, 4, false);
        Truck truck = new Truck("Ford", "F-150", 2021, 0, 2.5, true);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR600RR", 2020, 0, true, 600);

        // Testing acceleration for each vehicle
        System.out.println("Car:");
        System.out.println("Initial Speed: " + car.getSpeed());
        car.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + car.getSpeed());
        car.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + car.getSpeed());

        System.out.println("\nTruck:");
        System.out.println("Initial Speed: " + truck.getSpeed());
        truck.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + truck.getSpeed());
        truck.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + truck.getSpeed());

        System.out.println("\nMotorcycle:");
        System.out.println("Initial Speed: " + motorcycle.getSpeed());
        motorcycle.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + motorcycle.getSpeed());
        motorcycle.accelerate();
        System.out.println("Accelerating...");
        System.out.println("Speed after acceleration: " + motorcycle.getSpeed());
    }
}
