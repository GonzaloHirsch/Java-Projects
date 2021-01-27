package designPatterns.builder;

public interface AbstractBuilder {
    void setSeats();
    void setGps();
    void setMaxSpeed();
    void setEngine();
    Car getCar();
}
