package com.rappi.qa.carnival.stepdefinitions.consulta;

import com.rappi.qa.carnival.tasks.comunes.CerrarVentanaModal;
import com.rappi.qa.carnival.tasks.consultas.BuscarCruceros;
import com.rappi.qa.carnival.tasks.consultas.GuardarBusqueda;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.rappi.qa.carnival.questions.consultas.VerificarBusquedaDeCruceros.verificarBusquedaDeCruceros;

public class BuscarCrucerosStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor miguel = Actor.named("Miguel");

    @Before
    public void initialConfiguration() {
        miguel.can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("^que (.*) cargo la url de pruebas para buscar cruceros$")
    public void queCargoLaUrlDePruebasParaBuscarCruceros(Actor actor) {
        miguel.attemptsTo(Open.url("https://www.carnival.com/"));
    }

    @Cuando("^intento buscar cruceros a bahamas$")
    public void intentoBuscarCrucerosABahamas(List<String> data) {
        miguel.attemptsTo(CerrarVentanaModal.enLaWeb());
        miguel.attemptsTo(BuscarCruceros.enLaWeb(data));
        miguel.attemptsTo(GuardarBusqueda.realizadaEnLaWeb());
    }

    @Entonces("^Verifico el resultado de la busqueda (.*)$")
    public void verificoElResultadoDeLaBusquedaResultadoEsperado(String resultadoEsperado) {
        miguel.should(GivenWhenThen
                .seeThat(verificarBusquedaDeCruceros(), Matchers.equalToIgnoringCase(resultadoEsperado)));
    }
}
