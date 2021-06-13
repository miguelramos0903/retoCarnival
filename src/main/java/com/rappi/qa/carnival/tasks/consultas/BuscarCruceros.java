package com.rappi.qa.carnival.tasks.consultas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.rappi.qa.carnival.userinterface.consultas.BuscarCrucerosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarCruceros implements Task {
    private final List<String> data;

    public BuscarCruceros(List<String> data) {
        this.data = data;
    }

    public static BuscarCruceros enLaWeb(List<String> data) {
        return instrumented(BuscarCruceros.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(BOTON_NAVEGAR_A),
                Click.on(BOTON_NAVEGAR_A),
                WaitUntil.the(BOTON_DESTINO.of(data.get(1)), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BOTON_DESTINO.of(data.get(1)))
        );
        actor.attemptsTo(Click.on(BOTON_DURACION));
        actor.attemptsTo(WaitUntil.the(BOTON_DIAS, isVisible()).forNoMoreThan(3).seconds());
        actor.attemptsTo(Click.on(BOTON_DIAS));
        actor.attemptsTo(Click.on(BOTON_BUSCAR));
    }
}
