package io.github.julucinho.entities.java_implementations;

import io.github.julucinho.entities.SecondaryPort;
import io.github.julucinho.entities.contracts.implementations.PascalCaseStyle;
import io.github.julucinho.entities.java_implementations.contracts.LineGenerator;
import io.github.julucinho.entities.java_implementations.contracts.implementations.InterfaceDeclarationLineGenerator;
import io.github.julucinho.entities.java_implementations.contracts.implementations.PackageLineGenerator;
import io.github.julucinho.entities.java_implementations.exceptions.PrimaryPortJavaGenerationException;
import io.github.julucinho.entities.java_implementations.exceptions.SecondaryPortJavaGenerationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.github.julucinho.entities.constants.Constants.NEW_LINE;

public class SecondaryPortJavaImplementation extends SecondaryPort {

    private final LineGenerator packageLineGenerator = new PackageLineGenerator();
    private final LineGenerator interfaceDeclarationLineGenerator = new InterfaceDeclarationLineGenerator();

    protected SecondaryPortJavaImplementation() {
        super(new PascalCaseStyle());
    }

    @Override
    public String getFullPath(){
        return this.path.concat(this.formattedName).concat(".java");
    }

    @Override
    public void generatePhysicalArtifact() {
        var file = new File(this.getFullPath());
        try (var writer = new FileWriter(file)){
            writer.write(this.packageLineGenerator.generateLineUsing(this.fatherPackageName));
            writer.write(NEW_LINE);
            writer.write(this.interfaceDeclarationLineGenerator.generateLineUsing(this.formattedName));
        } catch (IOException e) {
            throw new SecondaryPortJavaGenerationException(e.getMessage());
        }
    }

}
