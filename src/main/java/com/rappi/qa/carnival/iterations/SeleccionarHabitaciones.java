package com.rappi.qa.carnival.iterations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static com.rappi.qa.carnival.userinterface.actualizar.ActualizarBusquedaGuardadaPage.BOTON_CUARTOS;
import static com.rappi.qa.carnival.userinterface.actualizar.ActualizarBusquedaGuardadaPage.LABEL_CUARTOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarHabitaciones implements Interaction {
    private final String totalHabitaciones;

    public SeleccionarHabitaciones(String totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public static SeleccionarHabitaciones enLaWeb(String totalHabitaciones) {
        return instrumented(SeleccionarHabitaciones.class, totalHabitaciones);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        while (!Text.of(LABEL_CUARTOS).viewedBy(actor).asString().trim().equals(totalHabitaciones)) {
            int esperado = Integer.parseInt(totalHabitaciones);
            int obtenido = Integer.parseInt(Text.of(LABEL_CUARTOS).viewedBy(actor).asString().trim());
            if (esperado > obtenido) {
                actor.attemptsTo(Click.on(BOTON_CUARTOS.of("2")));
            } else {
                actor.attemptsTo(Click.on(BOTON_CUARTOS.of("1")));
            }
        }
    }
}
