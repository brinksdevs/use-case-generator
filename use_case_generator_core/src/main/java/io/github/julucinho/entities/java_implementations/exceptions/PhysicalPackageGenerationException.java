package io.github.julucinho.entities.java_implementations.exceptions;

public class PhysicalPackageGenerationException extends RuntimeException {
    public PhysicalPackageGenerationException(String message) {
        super("Something went wrong while trying to generate physical file for java package implementation. More details: ".concat(message));
    }
}
