package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.time.LocalDate;
import java.time.Period;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SCBAccountTest {

    @ParameterizedTest
    @ArgumentsSource(SCBAccountArgProvider.class)
    void testIsEligibleToCreateAccount(SCBAccount account) {
        assertTrue(account.isEligibleToCreateAccount(),
                "Expected account to be eligible to create account: " + account.getAccno());
    }
}
