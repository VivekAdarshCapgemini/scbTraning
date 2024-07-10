package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Task2 {

    @Disabled("This test is disabled for now")
    @Test
    public void disabledTest() {
        System.out.println("This test should not run");
    }

    @RepeatedTest(3)
    public void repeatedTest() {
        assertTrue(1 + 1 == 2);
        System.out.println("Repeated test run");
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "cherry"})
    public void testWithValueSource(String fruit) {
        assertTrue(fruit.length() > 0);
        System.out.println("Fruit: " + fruit);
    }

    enum AccountType {
        Savings, Current, SalaryAccount
    }

    @ParameterizedTest
    @EnumSource(AccountType.class)
    public void testAccountTypes(AccountType accountType) {
        assertNotNull(accountType);
        System.out.println("Testing account type: " + accountType);
    }
}
