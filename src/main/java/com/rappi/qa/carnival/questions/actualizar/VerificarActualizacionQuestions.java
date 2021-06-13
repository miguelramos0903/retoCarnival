package com.rappi.qa.carnival.questions.actualizar;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarActualizacionQuestions implements Question<String> {

    private final String data;

    public VerificarActualizacionQuestions(String data) {
        this.data = data;
    }


    public static Question<String> verificarConfirmacionQuestion(String data) {
        return new VerificarActualizacionQuestions(data);
    }

    public static Question<String> verificarPieDePaginaQuestion(String data) {
        return new VerificarActualizacionQuestions(data);
    }

    @Override
    public String answeredBy(Actor actor) {
        String resultadoObtenido = null;
        if ("confirmacion".equalsIgnoreCase(data)) {
            resultadoObtenido = Serenity.sessionVariableCalled("confirmacion").toString().trim();
        }
        if ("pieDePagina".equalsIgnoreCase(data)) {
            resultadoObtenido = Serenity.sessionVariableCalled("pieDePagina").toString().trim();
        }

        return resultadoObtenido;
    }
}
