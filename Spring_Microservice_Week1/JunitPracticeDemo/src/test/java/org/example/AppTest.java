package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
    }

    @Test
    public void testAddition() {
        System.out.println("Test: addition");
        assertEquals(4, MyMath.add(2, 2));
    }

    @Test
    public void testMultiplication() {
        System.out.println("Test: multiplication");
        assertEquals(6, MyMath.multiply(2, 3));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }
}
