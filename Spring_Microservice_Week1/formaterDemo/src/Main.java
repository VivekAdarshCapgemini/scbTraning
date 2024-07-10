import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Creating a LocalDateTime object representing the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Formatting LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        // Formatting numbers
        double number = 1234567.89;
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("en","IN")); // Using US locale for formatting
        String formattedNumber = numberFormat.format(number);
        System.out.println("Formatted Number: " + formattedNumber);

        // Formatting currencies
        double amount = 1234.56;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en","IN")); // Using US locale for currency formatting
        String formattedCurrency = currencyFormat.format(amount);
        System.out.println("Formatted Currency: " + formattedCurrency);

        // Formatting percentages
        double percentage = 0.75;
        NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("en","IN")); // Using US locale for percentage formatting
        String formattedPercentage = percentFormat.format(percentage);
        System.out.println("Formatted Percentage: " + formattedPercentage);
    }
}
