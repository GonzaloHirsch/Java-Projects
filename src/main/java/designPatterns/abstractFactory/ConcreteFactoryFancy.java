package designPatterns.abstractFactory;

public class ConcreteFactoryFancy implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new FancyProductA();
    }

    @Override
    public ProductB createProductB() {
        return new FancyProductB();
    }
}
