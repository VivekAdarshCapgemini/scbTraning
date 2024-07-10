import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> input = Optional.of("vivek");
        Optional<String> emptyInput = Optional.empty();

        String upperCaseName = input.map(String::toUpperCase)
                .orElse("Name not available");
        System.out.println("Mapped value: " + upperCaseName);


        input.filter(name -> name.startsWith("v"))
                .ifPresent(name -> System.out.println("Filtered value: " + name));

        emptyInput.ifPresent(name -> System.out.println("Value is present: " + name));

        String defaultValue = emptyInput.orElseGet(() -> {
            System.out.println("Providing default value");
            return "Default Name";
        });
       System.out.println("Default value: " + defaultValue);

        try {
            String value = emptyInput.orElseThrow(() -> new RuntimeException("Value not present"));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
