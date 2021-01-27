package designPatterns.builder;

public class Client {
    /*
     * There are different concepts to the Builder pattern.
     * some make reference to a Director class that takes a Builder object and builds it according to the builder
     * but there are others that implement a chainable builder pattern.
     *
     * I will provide both alternatives.
     * */
    public static void main(String[] args) {
        // ALTERNATIVE 1 --> Requires more code
        // https://en.wikipedia.org/wiki/Builder_pattern

        System.out.println("ALTERNATIVE 1");
        // Generate the sports builder
        AbstractBuilder sportsBuilder = new SportsCarBuilder();
        // Generate the director
        Director d = new Director(sportsBuilder);
        // Build the car
        d.buildCar();
        // Get the car
        System.out.println("A Sports Car is " + d.getCar());

        // Generate the sports builder
        AbstractBuilder familyBuilder = new FamilyCarBuilder();
        // Generate the director
        d = new Director(familyBuilder);
        // Build the car
        d.buildCar();
        // Get the car
        System.out.println("A Family Car is " + d.getCar());

        // ALTERNATIVE 2 --> Less code and files, more intuitive
        // https://dzone.com/articles/design-patterns-the-builder-pattern

        AlternativeCar sportsCar = new AlternativeCar.Builder()
                .setEngine(new FastEngine())
                .setGps(true)
                .setMaxSpeed(300)
                .setSeats(2)
                .build();

        AlternativeCar familyCar = new AlternativeCar.Builder()
                .setEngine(new SlowEngine())
                .setGps(false)
                .setMaxSpeed(150)
                .setSeats(4)
                .build();

        System.out.println("ALTERNATIVE 2");
        System.out.println("A Sports Car is " + sportsCar);
        System.out.println("A Family Car is " + familyCar);
    }
}
