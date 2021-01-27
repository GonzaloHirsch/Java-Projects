package designPatterns.builder;

public class FamilyCarBuilder implements AbstractBuilder{
    private final Car car;

    public FamilyCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void setSeats() {
        this.car.setSeats(2);
    }

    @Override
    public void setGps() {
        this.car.setGps(true);
    }

    @Override
    public void setMaxSpeed() {
        this.car.setMaxSpeed(300);
    }

    @Override
    public void setEngine() {
        this.car.setEngine(new FastEngine());
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
