package com.rappi.qa.carnival.runners.consulta;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta/buscar_cruceros.feature",
        snippets = SnippetType.CAMELCASE,
        glue = {"com.rappi.qa.carnival.stepdefinitions.consulta"}
)
public class RunnerBuscarCrucero {
}
