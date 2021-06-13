package com.rappi.qa.carnival.stepdefinitions.actualizar;

import com.rappi.qa.carnival.tasks.actualizar.ActualzarBusquedaGuardada;
import com.rappi.qa.carnival.tasks.comunes.AutenticarUsuario;
import com.rappi.qa.carnival.tasks.comunes.CerrarVentanaModal;
import com.rappi.qa.carnival.tasks.consultas.BuscarCruceros;
import com.rappi.qa.carnival.tasks.consultas.GuardarBusqueda;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.rappi.qa.carnival.questions.actualizar.VerificarActualizacionQuestions.verificarConfirmacionQuestion;
import static com.rappi.qa.carnival.questions.actualizar.VerificarActualizacionQuestions.verificarPieDePaginaQuestion;

public class ActualizarBusquedaGuardadaStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor miguel = Actor.named("Miguel");

    @Before
    public void initialConfiguration() {
        miguel.can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("^que (.*) cargo la url de pruebas para actualizar cruceros$")
    public void queCargoLaUrlDePruebasParaActualizarCruceros(Actor actor) {
        miguel.attemptsTo(Open.url("https://www.carnival.com/"));
    }

    @Cuando("^intento actualizar la busqueda guardada$")
    public void intentoActualizarLaBusquedaGuardada(List<String> data) {
        miguel.attemptsTo(CerrarVentanaModal.enLaWeb());
        miguel.attemptsTo(AutenticarUsuario.enLaWeb(data));
        miguel.attemptsTo(BuscarCruceros.enLaWeb(data));
        miguel.attemptsTo(GuardarBusqueda.realizadaEnLaWeb());
        miguel.attemptsTo(ActualzarBusquedaGuardada.enLaWeb(data));
    }

    @Entonces("^Verifico el (.*) del registro de actualizado$")
    public void verificoElMensaje_Pie_De_PaginaDelRegistroDeActualizado(String mensajePieDePagina) {
        miguel.should(GivenWhenThen
                .seeThat(verificarPieDePaginaQuestion("pieDePagina"), Matchers.equalToIgnoringCase(mensajePieDePagina)));
    }

    @Y("^Verifico el (.*) del registro actualizado$")
    public void verificoElMensaje_ConfirmacionDelRegistroActualizado(String mensajeConfirmacion) {
        miguel.should(GivenWhenThen
                .seeThat(verificarConfirmacionQuestion("confirmacion"), Matchers.equalToIgnoringCase(mensajeConfirmacion)));
    }
}
