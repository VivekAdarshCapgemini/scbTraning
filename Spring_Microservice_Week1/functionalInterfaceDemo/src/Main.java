import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("************ Functional Interface Demo ************");

        System.out.println("*** Predicate ***");

        // Predicate is a functional interface that takes a single input and returns a boolean value.

        Predicate<Integer> isEven =Util::checkEven;

        System.out.println("Is 10 even? "+isEven.test(10));

        System.out.println("*** Bi Predicate ***");

        // BiPredicate is a functional interface that takes two arguments and returns a boolean value.

        BiPredicate<Integer,Integer> isGreater =Util::checkGreater;

        System.out.println("Is 10 greater than 5? "+isGreater.test(10,5));

        System.out.println("*** Consumer ***");

        // Consumer is a functional interface that takes a single input and returns no output.

        Map<Integer,String> map = new HashMap<>();

        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");

        Consumer<Map.Entry<Integer,String>> printEntry = Util::printMapEntry;

        map.entrySet().forEach(printEntry);

        System.out.println("*** Bi Consumer ***");

        // BiConsumer is a functional interface that takes two arguments and returns no output.

       // BiConsumer<Integer,String> printKeyValue = (key,value)-> System.out.println("Key: " + key + ", Value: " + value);
        BiConsumer<Integer,String> printKeyValue = (key,value)-> System.out.println("Key: " + key + ", Value: " + value);

        map.forEach(printKeyValue);

        System.out.println("*** Function ***");

        // Function is a functional interface that takes a single input and returns a single output.

        Function<Integer,Integer> square = Util::calculateSquare;

        System.out.println("Square of 5 is "+square.apply(10));

        System.out.println("*** Bi Function ***");

        // BiFunction is a functional interface that takes two arguments and returns a single output.

        BiFunction<Integer,Integer,Integer> add = Util::calculateSum;

        System.out.println("Sum of 10 and 20 is "+add.apply(10,20));

        System.out.println("*** Supplier ***");

        // Supplier is a functional interface that takes no input and returns a value.

        Supplier<Integer> base64Data = Util::calculateBase64Hash;

        System.out.println("Base64 encoded hashcode of Hello is "+base64Data.get());

        Consumer<String> consumer = (s) -> System.out.println(s);


        // Uniary Operator
        // UnaryOperator is a functional interface that takes a single input and returns the same type of output.

        UnaryOperator<Integer> increment = (num) -> num + 1;
        int result= increment.apply(10);
        System.out.println(result);


        // Binary Operator
        // BinaryOperator is a functional interface that takes two arguments and returns the same type of output.

        BinaryOperator<Integer> sum = (x, y) -> x + y;
        int binaryOperatorOutput = sum.apply(5, 3);
        System.out.println("Sum of 5 and 3: " + binaryOperatorOutput);

        // BooleanSupplier
        // BooleanSupplier is a functional interface that takes no input and returns a boolean value.

        BooleanSupplier isJavaFun = () -> true;
        boolean isJavaFunResult = isJavaFun.getAsBoolean();
        System.out.println("Is Java fun? " + isJavaFunResult);

        //IntPredicate
        // IntPredicate is a functional interface that takes a single integer input and returns a boolean value.

        IntPredicate isEvenIntPredicate = x -> x % 2 == 0;
        int number = 6;
        System.out.println(number + " is even? " + isEvenIntPredicate.test(number));
    }
}