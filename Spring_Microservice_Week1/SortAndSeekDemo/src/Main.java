import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        System.out.println("Example using sort():");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        System.out.println("Example using peek():");
        words.stream()
                .filter(word -> word.length() > 5)
                .peek(word -> System.out.println("Filtered word: " + word))
                .forEach(System.out::println);
    }
}
