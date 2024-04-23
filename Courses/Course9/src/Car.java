/**
 * Car
 */
public class Car {

    String carName;
    String carType;

    public Car(String carName, String carType) {
        this.carName = carName;
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    // inner class
    class Engine{
        String engineType;

        void setEngine() {
            if(Car.this.carType.equals("4WD")) {
                if(Car.this.carName.equals("Crysler")) {
                    this.engineType = "Smaller";
                } else {
                    this.engineType = "Bigger";
                }
            } else {
                this.engineType = "Bigger";
            }
        }

        String getEngineType() {
            return this.engineType;
        }
    }
}