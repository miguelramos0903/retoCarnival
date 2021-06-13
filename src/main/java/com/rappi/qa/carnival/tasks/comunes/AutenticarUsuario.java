package com.rappi.qa.carnival.tasks.comunes;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.rappi.qa.carnival.userinterface.actualizar.ActualizarBusquedaGuardadaPage.ENLACE_LOG_IN;
import static com.rappi.qa.carnival.userinterface.consultas.BuscarCrucerosPage.BOTON_NAVEGAR_A;
import static com.rappi.qa.carnival.userinterface.registro.RegistroUsuarioPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AutenticarUsuario implements Task {
    private final List<String> data;

    public AutenticarUsuario(List<String> data) {
        this.data = data;
    }

    public static AutenticarUsuario enLaWeb(List<String> data) {
        return instrumented(AutenticarUsuario.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(VINCULO_CREAR_CUENTA)

        );
        actor.attemptsTo(
                WaitUntil.the(ENLACE_LOG_IN, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ENLACE_LOG_IN),
                WaitUntil.the(BOTON_REGISTRAR, isVisible()).forNoMoreThan(5).seconds()
        );
        actor.attemptsTo(
                Enter.theValue(data.get(3)).into(CAMPO_USUARIO),
                Enter.theValue(data.get(4)).into(CAMPO_PASSWORD),
                Click.on(BOTON_REGISTRAR),
                WaitUntil.the(BOTON_NAVEGAR_A, isVisible()).forNoMoreThan(5).seconds()
        );
        actor.attemptsTo(
                Click.on(CONSULTA_PERFIL),
                WaitUntil.the(COD_VIP, isVisible()).forNoMoreThan(5).seconds()
        );
        String[] vifpObtenido = Text.of(COD_VIP).viewedBy(actor).asString().trim().split(":");
        Serenity.setSessionVariable("vifp").to(vifpObtenido[1].trim());
        actor.attemptsTo(Click.on(VOLVER_HOME));
        WaitUntil.the(BOTON_NAVEGAR_A, isVisible()).forNoMoreThan(5).seconds();
    }
}
