public class Car extends Vehicle {
    protected int numDoors;
    protected boolean isConvertible;

    Car(String make, String model, int year, int speed, int numDoors, boolean isConvertible)
    {
        super(make, model, year, speed);
        setNumDoors(numDoors);
        setIsConvertible(isConvertible);
    }


    public void setNumDoors(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors(){
        return this.numDoors;
    }

    public void setIsConvertible(boolean isConvertible){
        this.isConvertible = isConvertible;
    }
    public boolean getIsConvertible(){
        return this.isConvertible;
    }

    public void accelerate(){
        this.speed += 10;
    }
    
}
