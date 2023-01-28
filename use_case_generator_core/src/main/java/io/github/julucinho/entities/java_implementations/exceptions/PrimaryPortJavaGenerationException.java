package io.github.julucinho.entities.java_implementations.exceptions;

public class PrimaryPortJavaGenerationException extends RuntimeException {
    public PrimaryPortJavaGenerationException(String message) {
        super("Something went wrong while trying to create a primary port file for java implementation. More details: ".concat(message));
    }
}
