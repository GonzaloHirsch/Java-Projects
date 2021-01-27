package designPatterns.abstractFactory;

public class ConcreteFactory implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new NormalProductA();
    }

    @Override
    public ProductB createProductB() {
        return new NormalProductB();
    }
}
