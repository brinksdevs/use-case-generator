package io.github.julucinho.entities.contracts.implementations;

import io.github.julucinho.entities.contracts.NameFormattingStyle;

public class PascalCaseStyle implements NameFormattingStyle {
    @Override
    public String format(String name) {
        return name.substring(0, 1).toUpperCase().concat(name.substring(1)).replace(" ", "");
    }
}
