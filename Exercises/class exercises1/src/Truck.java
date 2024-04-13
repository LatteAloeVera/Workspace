public class Truck extends Vehicle {
    protected double cargoCapasity;
    protected boolean is4WD;

    Truck(String make, String model, int year, int speed, double cargoCapasity, boolean is4WD){
        super(make, model, year, speed);
        setCargoCapasity(cargoCapasity);
        setIs4WD(is4WD);
    }

    public void setCargoCapasity(double cargoCapasity){
        this.cargoCapasity = cargoCapasity;
    }
    public double getCargoCapasity(){
        return this.cargoCapasity;
    }

    public void setIs4WD(boolean is4WD){
        this.is4WD = is4WD;
    }
    public boolean getIs4WD(){
        return this.is4WD;
    }

    public void accelerate(){
        this.speed += 5;
    }
    
}
