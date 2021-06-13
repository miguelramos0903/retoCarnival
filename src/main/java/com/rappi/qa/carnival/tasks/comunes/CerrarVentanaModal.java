package com.rappi.qa.carnival.tasks.comunes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rappi.qa.carnival.userinterface.consultas.BuscarCrucerosPage.BOTON_NAVEGAR_A;
import static com.rappi.qa.carnival.userinterface.registro.RegistroUsuarioPage.CERRAR_MENSAJE_VENTANA_MODAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarVentanaModal implements Task {

    public static CerrarVentanaModal enLaWeb() {
        return instrumented(CerrarVentanaModal.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(CERRAR_MENSAJE_VENTANA_MODAL, isVisible()).forNoMoreThan(5).seconds();
        if (CERRAR_MENSAJE_VENTANA_MODAL.resolveFor(actor).isCurrentlyVisible())
            actor.attemptsTo(Click.on(CERRAR_MENSAJE_VENTANA_MODAL),
                    WaitUntil.the(BOTON_NAVEGAR_A, isVisible()).forNoMoreThan(5).seconds());
    }
}
