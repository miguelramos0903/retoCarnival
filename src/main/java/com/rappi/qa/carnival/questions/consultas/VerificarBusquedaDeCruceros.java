package com.rappi.qa.carnival.questions.consultas;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarBusquedaDeCruceros implements Question<String> {

    public static Question<String> verificarBusquedaDeCruceros() {
        return new VerificarBusquedaDeCruceros();
    }

    @Override
    public String answeredBy(Actor actor) {
        String resultadoObtenido = null;
        resultadoObtenido = Serenity.sessionVariableCalled("textoImagen").toString();
        //resultadoObtenido = Text.of(TEXTO_BUSQUEDA.of("1")).viewedBy(actor).asString().trim();
        System.out.println(resultadoObtenido);
        return resultadoObtenido;
    }
}
