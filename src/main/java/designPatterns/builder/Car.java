package designPatterns.builder;

public class Car {
    private Engine engine;
    private int seats;
    private int maxSpeed;
    private boolean gps;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", seats=" + seats +
                ", maxSpeed=" + maxSpeed +
                ", gps=" + gps +
                '}';
    }
}
