package designPatterns.builder;

public class AlternativeCar {
    private Engine engine;
    private int seats;
    private int maxSpeed;
    private boolean gps;

    private AlternativeCar(Engine engine, int seats, int maxSpeed, boolean gps) {
        this.engine = engine;
        this.seats = seats;
        this.maxSpeed = maxSpeed;
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "AlternativeCar{" +
                "engine=" + engine +
                ", seats=" + seats +
                ", maxSpeed=" + maxSpeed +
                ", gps=" + gps +
                '}';
    }

    public static class Builder {
        private Engine engine;
        private int seats;
        private int maxSpeed;
        private boolean gps;

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setGps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public AlternativeCar build(){
            return new AlternativeCar(this.engine, this.seats, this.maxSpeed, this.gps);
        }
    }
}
