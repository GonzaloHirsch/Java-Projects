package designPatterns.builder;

public class SportsCarBuilder implements AbstractBuilder{
    private final Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void setSeats() {
        this.car.setSeats(4);
    }

    @Override
    public void setGps() {
        this.car.setGps(false);
    }

    @Override
    public void setMaxSpeed() {
        this.car.setMaxSpeed(150);
    }

    @Override
    public void setEngine() {
        this.car.setEngine(new SlowEngine());
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
