package io.github.julucinho.entities.java_implementations.contracts.implementations;

import io.github.julucinho.entities.java_implementations.contracts.LineGenerator;

import static io.github.julucinho.entities.constants.Constants.END_OF_STATEMENT;

public class PackageLineGenerator implements LineGenerator {
    @Override
    public String generateLineUsing(String formattedName) {
        return "package ".concat(formattedName).concat(END_OF_STATEMENT);
    }
}
