package io.github.julucinho.entities.java_implementations;

import io.github.julucinho.entities.AbstractComponent;
import io.github.julucinho.entities.Package;
import io.github.julucinho.entities.contracts.implementations.SnakeCaseStyle;
import io.github.julucinho.entities.java_implementations.exceptions.PhysicalPackageGenerationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class PackageJavaImplementation extends Package {


    public PackageJavaImplementation(List<AbstractComponent> innerComponents) {
        super(new SnakeCaseStyle(), innerComponents);
    }

    @Override
    public void generatePhysicalArtifact() {
        try {
            Files.createDirectories(Paths.get(this.getFullPath()));
        } catch (IOException e) {
            throw new PhysicalPackageGenerationException(e.getMessage());
        }
        this.innerComponents
                .forEach(innerComponent -> {
                    innerComponent.setFatherPackageName(this.getFatherPackageName().concat(this.getFormattedName()));
                    innerComponent.setPath(this.getFullPath());
                    innerComponent.generatePhysicalArtifact();
                });
    }

    @Override
    public String getFatherPackageName(){
        return Optional.ofNullable(this.fatherPackageName)
                .map(fatherPackageName -> fatherPackageName.concat("."))
                .orElse("");
    }

}
