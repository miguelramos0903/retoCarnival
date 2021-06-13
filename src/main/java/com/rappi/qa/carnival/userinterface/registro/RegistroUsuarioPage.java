package com.rappi.qa.carnival.userinterface.registro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroUsuarioPage {

    private RegistroUsuarioPage() {
    }

    public static final Target CERRAR_MENSAJE_VENTANA_MODAL = Target
            .the("Mensaje pop up")
            .located(By.xpath("//*[@id='MainBody']/div[2]/div/span"));

    public static final Target VINCULO_CREAR_CUENTA = Target
            .the("vinculo para crear una cuenta")
            .located(By.xpath("//*[@class='cgh-header__profile-menu--desktop']//*[contains(text(), 'Create Account')]"));

    public static final Target CAMPO_USUARIO = Target
            .the("campo usuario")
            .located(By.id("username"));

    public static final Target CAMPO_PASSWORD = Target
            .the("campo de password")
            .located(By.id("password"));

    public static final Target BOTON_REGISTRAR = Target
            .the("boton registrar")
            .located(By.xpath("//*[@class='lrc-submit-button cclr-button-secondary cclr-button-small']"));

    public static final Target PRIMER_NOMBRE = Target
            .the("campo password")
            .located(By.id("firstName-pm"));

    public static final Target PRIMER_APELLIDO = Target
            .the("campo password")
            .located(By.id("lastName-pm"));

    public static final Target COMBO_MES = Target
            .the("campo Mes")
            .located(By.id("dobMonth-pm"));

    public static final Target SELECCIONAR_MES = Target
            .the("campo Mes")
            .locatedBy("//*[@id='dobMonth-pm']//*[contains(text(), '{0}')]");

    public static final Target SELECCIONAR_PAIS = Target
            .the("campo Pais")
            .locatedBy("//*[@id='countryCode-pm']//*[contains(text(), '{0}')]");

    public static final Target COMBO_PAIS = Target
            .the("combo pais")
            .located(By.id("countryCode-pm"));

    public static final Target CAMPO_DIA = Target
            .the("campo dia")
            .located(By.id("dobDay-pm"));

    public static final Target CAMPO_ANO = Target
            .the("campo ano")
            .located(By.id("dobYear-pm"));

    public static final Target CAMPO_GENERO = Target
            .the("campo genero")
            .located(By.id("gender-pm"));

    public static final Target SELECCIONAR_GENERO = Target
            .the("campo genero")
            .locatedBy("//*[@id='gender-pm']//*[contains(text(),'{0}')]");

    public static final Target TERMINOS_CONDICIONES_D = Target
            .the("terminos y condiciones")
            .located(By.xpath("//div[10]/label"));

    public static final Target BOTON_ENVIAR = Target
            .the("boton enviar")
            .located(By.id("submit-guest-pm"));

    public static final Target CAMPO_AREA = Target
            .the("Campo area")
            .located(By.id("phoneAreaCode-pm"));

    public static final Target CAMPO_TELEFONO = Target
            .the("Campo telefono")
            .located(By.id("phoneNumber-pm"));

    public static final Target TRABAJANDO_CON_TRABEL = Target
            .the("Campo telefono")
            .locatedBy("//*[@id='workingWithTravelAgent-pm']//following::label[{0}]");

    public static final Target MENSAJE_EXITOSO = Target
            .the("mensaje exitoso del registro")
            .located(By.xpath("//*[@id='lrh-heading']"));

    public static final Target COD_VIP = Target
            .the(" codigo VIP")
            .located(By.cssSelector(".pm-profile-card__vifp"));

    public static final Target CONSULTA_PERFIL = Target
            .the("consulta perfil")
            .located(By.xpath("//ul[@class='cgh-header__main-menu-options cgh-header__main-menu-options--right']//div/p/a"));

    public static final Target VOLVER_HOME = Target
            .the(" codigo VIP")
            .located(By.cssSelector(".cgh-header__logo"));


}
