package nl.cjib.eventsourcing.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ArchitectureTests {

    JavaClasses javaClasses;
    Architectures.LayeredArchitecture architectures;

    @BeforeEach
    void setup() {
        javaClasses = new ClassFileImporter()
                .importPackages("nl.cjib.eventsourcing");

        architectures = layeredArchitecture()
                .consideringAllDependencies()
                .layer("api").definedBy("..api..")
                .layer("core").definedBy("..core..")
                .layer("infra").definedBy("..infra..");
    }

    @Test
    void core() {
        var arch = architectures
                .whereLayer("core").mayOnlyBeAccessedByLayers("api", "infra");

        arch.check(javaClasses);
    }

    @Test
    void api() {
        var arch = architectures
                .whereLayer("api")
                .mayNotBeAccessedByAnyLayer();

        arch.check(javaClasses);
    }

    @Test
    void infra() {
        var arch = architectures
                .whereLayer("infra")
                .mayOnlyBeAccessedByLayers("core");

        arch.check(javaClasses);
    }
}
