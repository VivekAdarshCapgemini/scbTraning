package org.example;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.time.LocalDate;
import java.util.stream.Stream;

public class SCBAccountArgProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(new SCBAccount(1, "Vivek", LocalDate.of(1990, 5, 15), "Savings", 1000.0)),
                Arguments.of(new SCBAccount(2, "Adarsh", LocalDate.of(2000, 8, 20), "Checking", 500.0)),
                Arguments.of(new SCBAccount(3, "Ankit", LocalDate.of(2024, 3, 10), "Savings", 200.0))
        );
    }
}
