package com.rappi.qa.carnival.tasks.actualizar;

import com.rappi.qa.carnival.iterations.SeleccionarHabitaciones;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.rappi.qa.carnival.userinterface.actualizar.ActualizarBusquedaGuardadaPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ActualzarBusquedaGuardada implements Task {
    private final List<String> data;

    public ActualzarBusquedaGuardada(List<String> data) {
        this.data = data;
    }

    public static ActualzarBusquedaGuardada enLaWeb(List<String> data) {
        return instrumented(ActualzarBusquedaGuardada.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HOME));
        WaitUntil.the(BOTON_SAVED, isVisible()).forNoMoreThan(5).seconds();
        actor.attemptsTo(Click.on(BOTON_SAVED));
        WaitUntil.the(LABEL_TITULO, isVisible()).forNoMoreThan(5).seconds();
        actor.attemptsTo(
                Scroll.to(BOTON_BOOK_NOW),
                Click.on(BOTON_BOOK_NOW)
        );

        WaitUntil.the(BOTON_BOOK_NOW, isVisible()).forNoMoreThan(5).seconds();
        actor.attemptsTo(SeleccionarHabitaciones.enLaWeb(data.get(5)));

        actor.attemptsTo(
                Scroll.to(BOTON_CONTINUAR),
                Click.on(BOTON_CONTINUAR)
        );
        WaitUntil.the(CIUDAD_RESIDENCIA, isVisible()).forNoMoreThan(5).seconds();
        actor.attemptsTo(Click.on(CIUDAD_RESIDENCIA));
        actor.attemptsTo(Click.on(SELECT_CIUDAD_RESIDENCIA),
                Click.on(CHECK_VIFP),
                Scroll.to(CONTINUAR_ROOMS),
                Enter.theValue(Serenity.sessionVariableCalled("vifp").toString())
                        .into(TEXT_VIFP)
                        .thenHit(Keys.ENTER)
        );
        actor.attemptsTo(
                WaitUntil.the(BOTON_SELECT_SPECIALS, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BOTON_SELECT_SPECIALS)
        );

        actor.attemptsTo(
                WaitUntil.the(SELECT_ROOM_TYPE, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(SELECT_ROOM_TYPE),
                Click.on(SELECT_ROOM_TYPE)
        );

        actor.attemptsTo(
                WaitUntil.the(MAS_OPCIONES, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(MAS_OPCIONES),
                Click.on(MAS_OPCIONES),
                Scroll.to(SELECT_PB4),
                Click.on(SELECT_PB4)
        );

        actor.attemptsTo(
                WaitUntil.the(CONTINUE_PRICIN, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(CONTINUE_PRICIN),
                Click.on(CONTINUE_PRICIN)
        );

        actor.attemptsTo(
                WaitUntil.the(CONTINUE_LOCAITIONS, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(CONTINUE_LOCAITIONS),
                Click.on(CONTINUE_LOCAITIONS)
        );

        actor.attemptsTo(
                WaitUntil.the(TEXTO_PIE_DEPAGINA, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(TEXTO_PIE_DEPAGINA)
        );
        Serenity.setSessionVariable("pieDePagina").to(Text.of(TEXTO_PIE_DEPAGINA).viewedBy(actor).asString().trim());
        actor.attemptsTo(
                Click.on(CONTINUE),
                WaitUntil.the(CONTINUE_INFORMATION, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(CONTINUE_INFORMATION),
                Click.on(CONTINUE_INFORMATION)
        );
        actor.attemptsTo(Scroll.to(CONFIRMACION_INFORMATION),
                WaitUntil.the(CONFIRMACION_INFORMATION, isVisible()).forNoMoreThan(5).seconds());
        Serenity.setSessionVariable("confirmacion").to(Text.of(CONFIRMACION_INFORMATION).viewedBy(actor).asString().trim());
    }
}
