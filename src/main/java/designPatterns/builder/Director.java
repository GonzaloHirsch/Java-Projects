package designPatterns.builder;

public class Director {
    private final AbstractBuilder builder;

    public Director(AbstractBuilder builder){
        this.builder = builder;
    }

    public void buildCar(){
        this.builder.setEngine();
        this.builder.setGps();
        this.builder.setMaxSpeed();
        this.builder.setSeats();
    }

    public Car getCar(){
        return this.builder.getCar();
    }
}
