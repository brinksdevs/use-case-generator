package io.github.julucinho.entities;

import io.github.julucinho.entities.contracts.NameFormattingStyle;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractComponent {

    protected final NameFormattingStyle nameFormattingStyle;
    protected String name;
    protected String formattedName;
    protected String fatherPackageName;
    protected String path;
    public String getFullPath(){
        return this.path.concat(File.separator).concat(this.formattedName);
    }
    public abstract void generatePhysicalArtifact();

    public void setName(String name){
        this.name = name;
        this.formattedName = this.nameFormattingStyle.format(name);
    }

    public void setFatherPackageName(String fatherPackageName){
        this.fatherPackageName = fatherPackageName;
    }

}
