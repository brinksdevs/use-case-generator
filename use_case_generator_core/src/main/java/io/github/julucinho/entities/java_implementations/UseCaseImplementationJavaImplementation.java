package io.github.julucinho.entities.java_implementations;

import io.github.julucinho.entities.UseCaseImplementation;
import io.github.julucinho.entities.contracts.implementations.PascalCaseStyle;
import io.github.julucinho.entities.java_implementations.contracts.LineGenerator;
import io.github.julucinho.entities.java_implementations.contracts.implementations.ImplementationClassDeclarationLineGenerator;
import io.github.julucinho.entities.java_implementations.contracts.implementations.ImportLineGenerator;
import io.github.julucinho.entities.java_implementations.contracts.implementations.PackageLineGenerator;
import io.github.julucinho.entities.java_implementations.exceptions.PrimaryPortJavaGenerationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.github.julucinho.entities.constants.Constants.NEW_LINE;

public class UseCaseImplementationJavaImplementation extends UseCaseImplementation {

    private final LineGenerator packageLineGenerator = new PackageLineGenerator();
    private final LineGenerator importLineGenerator = new ImportLineGenerator();
    private final LineGenerator classDeclarationLineGenerator = new ImplementationClassDeclarationLineGenerator();

    protected UseCaseImplementationJavaImplementation() {
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
            writer.write(NEW_LINE.repeat(2));
            writer.write(this.importLineGenerator.generateLineUsing(this.buildImportAddressValue()));
            writer.write(NEW_LINE.repeat(2));
            writer.write(this.classDeclarationLineGenerator.generateLineUsing(this.formattedName));
        } catch (IOException e) {
            throw new PrimaryPortJavaGenerationException(e.getMessage());
        }
    }

    private String buildImportAddressValue() {
        return this.fatherPackageName.replace("implementations", "").concat(this.formattedName.replace("Implementation", ""));
    }
}
