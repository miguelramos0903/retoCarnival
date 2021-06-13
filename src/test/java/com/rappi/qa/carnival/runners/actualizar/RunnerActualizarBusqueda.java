package com.rappi.qa.carnival.runners.actualizar;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/actualizar/actualizar_busqueda_guardada.feature",
        snippets = SnippetType.CAMELCASE,
        glue = {"com.rappi.qa.carnival.stepdefinitions.actualizar"}
)
public class RunnerActualizarBusqueda {
}
