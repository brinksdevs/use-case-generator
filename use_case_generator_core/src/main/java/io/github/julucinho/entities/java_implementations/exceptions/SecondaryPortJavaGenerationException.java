package io.github.julucinho.entities.java_implementations.exceptions;

public class SecondaryPortJavaGenerationException extends RuntimeException {
    public SecondaryPortJavaGenerationException(String message) {
        super("Something went wrong while trying to create a secondary port file for java implementation. More details: ".concat(message));
    }
}
