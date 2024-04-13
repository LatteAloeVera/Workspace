public class Motorcycle extends Vehicle {
    protected boolean isSportBike;
    protected int engineDisplacement;

    Motorcycle(String make, String model, int year, int speed, boolean isSportBike, int engineDisplacement){
        super(make, model, year, speed);
        setIsSportBike(isSportBike);
        setEngineDisplacement(engineDisplacement);
    }

    public void setIsSportBike(boolean isSportBike){
        this.isSportBike = isSportBike;
    }
    public boolean getIsSportBike(){
        return this.isSportBike;
    }

    public void setEngineDisplacement(int engineDisplacement){
        this.engineDisplacement = engineDisplacement;
    }
    public int getEngineDisplacement(){
        return this.engineDisplacement;
    }

    public void accelerate(){
        this.speed += 15;
    }
}
