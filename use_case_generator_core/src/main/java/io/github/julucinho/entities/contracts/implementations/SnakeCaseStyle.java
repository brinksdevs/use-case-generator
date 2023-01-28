package io.github.julucinho.entities.contracts.implementations;

import io.github.julucinho.entities.contracts.NameFormattingStyle;

public class SnakeCaseStyle implements NameFormattingStyle {

    @Override
    public String format(String name) {
        return name.toLowerCase().replace(" ", "_");
    }
}
