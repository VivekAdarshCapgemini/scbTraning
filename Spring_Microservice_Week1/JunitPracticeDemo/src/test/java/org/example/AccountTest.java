package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    @ParameterizedTest
    @CsvSource({"12345, Vivek","67890, Adarsh"})
    public void testAccountBelongsToName(int accountNumber, String accountName) {
        assertEquals(true,checkAccountBelongsToName(accountNumber, accountName));
    }

    private boolean checkAccountBelongsToName(int accountNumber, String accountName) {
        if (accountName.equals("Vivek") && accountNumber == 12345) {
            return true;
        } else if (accountName.equals("Adarsh") && accountNumber == 67890) {
            return true;
        } else {
            return false;
        }
    }

    @ParameterizedTest
    @MethodSource("accountNumberProvider")
    void testAccountNumberIsNumber(String accountNumber) {
        assertTrue(isValidAccountNumber(accountNumber));
    }

    static Stream<String> accountNumberProvider() {
        return Stream.of("12345", "67890", "A1234", "99999");
    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.matches("\\d+");
    }
}
