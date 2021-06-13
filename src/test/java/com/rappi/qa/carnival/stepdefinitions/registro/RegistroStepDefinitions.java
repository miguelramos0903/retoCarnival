package com.rappi.qa.carnival.stepdefinitions.registro;

import com.rappi.qa.carnival.tasks.comunes.CerrarVentanaModal;
import com.rappi.qa.carnival.tasks.registro.RegistrarUsuario;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.rappi.qa.carnival.questions.registro.VerificarRegistroQuestions.verificarRegistroQuestions;

public class RegistroStepDefinitions {

    @Managed(driver="chrome")
    private WebDriver hisBrowser;
    private Actor miguel = Actor.named("Miguel");

    @Before
    public void initialConfiguration() {
        miguel.can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("^que (.*) cargo la url de pruebas$")
    public void queCargoLaUrlDePruebas(Actor actor) {
        miguel.attemptsTo(Open.url("https://www.carnival.com/"));
    }

    @Cuando("^intento registrar un nuevo usuario$")
    public void intentoRegistrarUnNuevoUsuario(List<String> data) {
        miguel.attemptsTo(CerrarVentanaModal.enLaWeb());
        miguel.attemptsTo(RegistrarUsuario.enLaWeb(data));
    }

    @Entonces("^Verifico el (.*) del registro de usuario$")
    public void verificoElResultadoEsperadoDelRegistroDeUsuario(String resultadoEsperado) {
        miguel.should(GivenWhenThen
                .seeThat(verificarRegistroQuestions(), Matchers.equalToIgnoringCase(resultadoEsperado)));
    }

}
