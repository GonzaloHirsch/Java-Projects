package designPatterns.abstractFactory;

public class Client {
    // The page is https://en.wikipedia.org/wiki/Abstract_factory_pattern#UML_diagram
    public static void main(String[] args){
        // Get instance of the factory
        AbstractFactory factory = new ConcreteFactory();

        // Get instances directly from the factory, not the objects
        ProductA pa = factory.createProductA();
        ProductB pb = factory.createProductB();

        System.out.println("With a Normal Factory got " + pa.toString() + " and " + pb.toString());

        // Get another factory
        factory = new ConcreteFactoryFancy();

        // For the client it's the same which factory it has, the interface is the same
        pa = factory.createProductA();
        pb = factory.createProductB();

        System.out.println("With a Fancy Factory got " + pa.toString() + " and " + pb.toString());
    }
}
