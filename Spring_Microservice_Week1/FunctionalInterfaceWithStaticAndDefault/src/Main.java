@FunctionalInterface
interface MyFunctionalInterface {
    void abstractMethod();
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }

    default void defaultMethod() {
        System.out.println("This is a default method in the interface.");
    }
}

public class Main {
    public static void main(String[] args) {

        MyFunctionalInterface.staticMethod();


        MyFunctionalInterface myInterface = () -> System.out.println("Executing abstract method.");
        myInterface.abstractMethod();

        myInterface.defaultMethod();
    }
}
