package com.rappi.qa.carnival.tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.rappi.qa.carnival.userinterface.registro.RegistroUsuarioPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class RegistrarUsuario implements Task {
    private final List<String> data;

    public RegistrarUsuario(List<String> data) {
        this.data = data;
    }

    public static RegistrarUsuario enLaWeb(List<String> data) {
        return instrumented(RegistrarUsuario.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Actions action = new Actions(getDriver());

        actor.attemptsTo(
                Click.on(VINCULO_CREAR_CUENTA),
                Enter.theValue(data.get(1)).into(CAMPO_USUARIO),
                Enter.theValue(data.get(2)).into(CAMPO_PASSWORD),
                Click.on(BOTON_REGISTRAR)
        );

        actor.attemptsTo(
                Scroll.to(PRIMER_NOMBRE),
                Enter.theValue(data.get(3)).into(PRIMER_NOMBRE),
                Enter.theValue(data.get(4)).into(PRIMER_APELLIDO),
                Scroll.to(CAMPO_GENERO),
                Click.on(COMBO_MES),
                Click.on(SELECCIONAR_MES.of(data.get(7))),
                Enter.theValue(data.get(5)).into(CAMPO_DIA),
                Enter.theValue(data.get(6)).into(CAMPO_ANO)
        );

        actor.attemptsTo(
                Click.on(CAMPO_GENERO),
                Click.on(SELECCIONAR_GENERO.of(data.get(9))),
                Click.on(COMBO_PAIS),
                Click.on(SELECCIONAR_PAIS.of(data.get(8))),
                Enter.theValue(data.get(10)).into(CAMPO_AREA),
                Enter.theValue(data.get(11)).into(CAMPO_TELEFONO)
        );

        actor.attemptsTo(
                Click.on(TRABAJANDO_CON_TRABEL.of("1")),
                Click.on(TRABAJANDO_CON_TRABEL.of("2")),
                Click.on(TRABAJANDO_CON_TRABEL.of("2")),
                JavaScriptClick.on(TERMINOS_CONDICIONES_D),
                Scroll.to(BOTON_ENVIAR)
        );
        actor.attemptsTo(
                Click.on(BOTON_ENVIAR),
                WaitUntil.the(MENSAJE_EXITOSO, isVisible())
                        .forNoMoreThan(5).seconds(),
                Scroll.to(MENSAJE_EXITOSO)
        );
    }

}
