package designPatterns.singleton;

public class Client {
    // https://en.wikipedia.org/wiki/Singleton_pattern
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1.toString() + " " + s2.toString() + " are equal same instance? --> " + (s1 == s2));
    }
}
