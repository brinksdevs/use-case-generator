package io.github.julucinho.entities.java_implementations.contracts.implementations;

import io.github.julucinho.entities.java_implementations.contracts.LineGenerator;

public class InterfaceDeclarationLineGenerator implements LineGenerator {

    @Override
    public String generateLineUsing(String formattedName) {
            return "public interface ".concat(formattedName).concat(" {}");
    }
}
