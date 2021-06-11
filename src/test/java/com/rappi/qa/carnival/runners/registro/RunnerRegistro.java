package com.rappi.qa.carnival.runners.registro;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/registro/registrar_usuario_nuevo.feature",
        snippets = SnippetType.CAMELCASE,
        glue= "com.rappi.qa.carnival.stepdefinitions.registro"
)
public class RunnerRegistro {
}
