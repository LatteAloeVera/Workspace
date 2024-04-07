/**
 * Q1
 */
public class Q1 {

    public static void main(String[] args) {
        // Convert 100 degrees Fahrenheit to Celsius
        System.out.println("100 F to C: " + convertTemperature(100, "FAHRENHEIT", "CELSIUS"));
        
        // Convert 0 degrees Kelvin to Fahrenheit
        System.out.println("0 K to F: " + convertTemperature(0, "KELVIN", "FAHRENHEIT"));
        
        // Convert 25 degrees Celsius to Kelvin
        System.out.println("25 C to K: " + convertTemperature(25, "CELSIUS", "KELVIN"));
    }

    /*
        Temperature Conversion with Scale:
        Implement a method convertTemperature that converts temperatures between Fahrenheit, Celsius, and Kelvin. 
        The method should take the temperature to convert, the scale from which the temperature is converted ("F", "C", or "K"), 
        and the scale to which to convert.
    */
    public static double convertTemperature(double temperature, String fromScale, String toScale){
        double convTemperature = -1;

        fromScale = fromScale.toUpperCase();
        toScale = toScale.toUpperCase();
        switch (fromScale){
            case "FAHRENHEIT" ->{
                if (toScale == "CELSIUS"){
                    convTemperature = ((temperature - 32) * 5) / 9;
                }
                else if (toScale == "KELVIN"){
                    convTemperature = (((temperature - 32) * 5) / 9) + 273.15;
                }
                else if (toScale == "FAHRENHEIT"){
                    convTemperature = temperature;
                }
                else{
                    System.out.println("CONVERTING TEMPERATURE TYPE IS WRONG!");
                }
            }
            case "CELSIUS"    ->{
                switch (toScale){
                    case "KELVIN"       ->{
                        convTemperature = temperature + 273.15;
                    }
                    case "FAHRENHEIT"   ->{
                        convTemperature = ((temperature * 9) / 5) + 32;
                    }
                    case "CELSIUS"      ->{
                        convTemperature = temperature;
                    }
                    default -> {
                        System.out.println("CONVERTING TEMPERATURE TYPE IS WRONG!");
                    }
                }

            }
            case "KELVIN"     ->{
                switch (toScale){
                    case "FAHRENHEIT"   ->{
                        convTemperature = ((temperature - 273.15) * 9 / 5) + 32;
                    }
                    case "CELSIUS"      ->{
                        convTemperature = temperature - 273.15;
                    }
                    case "KELVIN"       ->{
                        convTemperature = temperature;
                    }
                    default ->{
                        System.out.println("CONVERTING TEMPERATURE TYPE IS WRONG!");
                    }
                }
            }
            default -> {
                System.out.println("INPUT TEMPERATURE TYPE IS WRONG!");
            }
        }

        return convTemperature;
        
    }

}