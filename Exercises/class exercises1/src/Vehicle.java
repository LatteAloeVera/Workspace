public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected int speed;

    Vehicle(String make, String model, int year, int speed){
        setMake(make);
        setModel(model);
        setYear(year);
        setSpeed(speed);
    }

    public void setMake(String make){
        this.make = make;
    }
    public String getMake(){
        return this.make;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }

    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return this.speed;
    }

    public abstract void accelerate();
    
}
