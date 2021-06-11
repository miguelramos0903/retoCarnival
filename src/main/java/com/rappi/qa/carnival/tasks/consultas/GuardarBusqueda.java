package com.rappi.qa.carnival.tasks.consultas;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rappi.qa.carnival.userinterface.consultas.BuscarCrucerosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GuardarBusqueda implements Task {

    public static GuardarBusqueda realizadaEnLaWeb() {
        return instrumented(GuardarBusqueda.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(SELECCIONAR_IMAGEN.of("1"), isVisible()).forNoMoreThan(5).seconds();
        String textoLabelBusqueda = Text.of(TEXTO_BUSQUEDA.of("1")).viewedBy(actor).asString().trim();

        actor.attemptsTo(
                Click.on(SELECCIONAR_IMAGEN.of("1")),
                WaitUntil.the(BOTON_GUARDAR_BUSQUEDA,isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BOTON_GUARDAR_BUSQUEDA)
        );
        String textosLabelMasBoton = textoLabelBusqueda + " - " + Text.of(TEXTO_BOTON_GUARDAR).viewedBy(actor).asString().trim();

        Serenity.setSessionVariable("textoImagen").to(textosLabelMasBoton);
    }
}
