/**
 * Computer
 */
public class Computer {

    double price;

    // nested Class
    class Processor{
        double cores;
        String manufacturer;

        double getCache(){
            return 4.3;
        }
    }

    // nested Protected Class
    protected class RAM{
        double memory;
        String manufacturer;

        double getClockSpeed(){
            return 5.5;
        }
    }
}