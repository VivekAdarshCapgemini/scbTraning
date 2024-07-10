import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class Util {

    public static boolean checkEven(Integer number) {
        return number % 2 == 0;
    }

    public static void printMapEntry(Map.Entry<Integer, String> entry) {
        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    public static void printKeyValue(Integer key, String value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    public static Integer calculateSquare(Integer number) {
        return number * number;
    }

    public static Integer calculateSum(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public static Integer calculateBase64Hash() {
        return Base64.getEncoder().encode("Hello".getBytes(StandardCharsets.UTF_8)).hashCode();
    }


    public static boolean checkGreater(Integer num1, Integer num2) {
        return num1 > num2;
    }
}
