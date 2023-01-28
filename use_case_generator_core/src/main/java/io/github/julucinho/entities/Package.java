package io.github.julucinho.entities;

import io.github.julucinho.entities.contracts.NameFormattingStyle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Package extends AbstractComponent{

    protected final List<AbstractComponent> innerComponents;

    protected Package(NameFormattingStyle nameFormattingStyle, List<AbstractComponent> innerComponents) {
        super(nameFormattingStyle);
        this.innerComponents = innerComponents;
    }
}
