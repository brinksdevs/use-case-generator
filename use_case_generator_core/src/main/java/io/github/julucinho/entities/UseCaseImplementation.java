package io.github.julucinho.entities;

import io.github.julucinho.entities.contracts.NameFormattingStyle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UseCaseImplementation extends AbstractComponent{

    protected UseCaseImplementation(NameFormattingStyle nameFormattingStyle) {
        super(nameFormattingStyle);
    }
}
