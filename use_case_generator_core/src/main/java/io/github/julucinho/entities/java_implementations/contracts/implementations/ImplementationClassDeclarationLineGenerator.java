package io.github.julucinho.entities.java_implementations.contracts.implementations;

import io.github.julucinho.entities.java_implementations.contracts.LineGenerator;

public class ImplementationClassDeclarationLineGenerator implements LineGenerator {
    @Override
    public String generateLineUsing(String formattedName) {
        return "public class ".concat(formattedName).concat(" implements ").concat(formattedName.replace("Implementation", "")).concat(" {}");
    }
}
