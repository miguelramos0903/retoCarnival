package com.rappi.qa.carnival.userinterface.actualizar;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ActualizarBusquedaGuardadaPage {

    private ActualizarBusquedaGuardadaPage() {
    }

    public static final Target BOTON_SAVED = Target
            .the("boton destino")
            .located(By.cssSelector(".cgh-ribbon__content"));

    public static final Target BOTON_BOOK_NOW = Target
            .the("boton del Book Now")
            .located(By.cssSelector(".page-saved .component .content booking-button .cta"));

    public static final Target LABEL_TITULO = Target
            .the("label del titulo")
            .located(By.cssSelector(".page-saved .component h2"));

    public static final Target HOME = Target
            .the("home inicio")
            .located(By.id("sm-logo"));

    public static final Target BOTON_CUARTOS = Target
            .the("BOTON CUARTOS")
            .locatedBy("//*[@class='be-cabins-panel__guest-section']/button[{0}]");

    public static final Target LABEL_CUARTOS = Target
            .the("label cuartos")
            .located(By.xpath("//*[@class='be-cabins-panel__guest-section']/div"));

    public static final Target BOTON_CONTINUAR = Target
            .the("boton continuar ")
            .located(By.cssSelector(".be-cabins-panel-btn"));

    public static final Target ENLACE_LOG_IN = Target
            .the("seleccionar para autenticar")
            .located(By.xpath("//div[@class='lsu-footer']/div/a"));

    public static final Target SALIR = Target
            .the("boton salir")
            .located(By.id("country-of-residency.0"));

    public static final Target CIUDAD_RESIDENCIA = Target
            .the("ciudad residencia")
            .located(By.xpath("//*[@id='country-of-residency.0']"));

    public static final Target SELECT_CIUDAD_RESIDENCIA = Target
            .the("select ciudad")
            .located(By.xpath("//*[@id='country-of-residency.0']//option[contains(text(), 'Mexico')]"));

    public static final Target CHECK_VIFP = Target
            .the("check del vifp")
            .located(By.xpath("//*[@id='be-qualifiers-cabin__pastGuest-checkbox.0']"));

    public static final Target TEXT_VIFP = Target
            .the("text check vifp")
            .located(By.xpath("//*[@id='be_vifp_look_up_panel.0']/input"));

    public static final Target CONTINUAR_ROOMS = Target
            .the("btn continuar rooms")
            .located(By.cssSelector(".be-qualifiers-pnl__continue .be-qualifiers-pnl-btn"));

    public static final Target BOTON_SELECT_SPECIALS = Target
            .the("boton slect")
            .located(By.xpath("//div[@class='be-metas-p__room-type'][1]/button"));

    public static final Target SELECT_ROOM_TYPE = Target
            .the("SELECT ROOM_TYPE")
            .located(By.xpath("//div[@data-index='0']//button[@class= 'be-btn be-btn--primary be-meta-upgrade-room-type__price-button']"));

    public static final Target MAS_OPCIONES = Target
            .the("MAS OPCIONES")
            .located(By.cssSelector(".be-rate-p__container-more-options-button"));

    public static final Target SELECT_PB4 = Target
            .the("SELECT PB4")
            .located(By.xpath("//button[contains(@aria-label, '(PB4) rate')]"));

    public static final Target CONTINUE_PRICIN = Target
            .the("CONTINUE PRICIN")
            .located(By.cssSelector(".be-loc-p__btn"));

    public static final Target CONTINUE_LOCAITIONS = Target
            .the("CONTINUE LOCAITIONS")
            .located(By.id("continueRoomsButton"));

    public static final Target TEXTO_PIE_DEPAGINA = Target
            .the("For assistance with your Carnival Cruise, please call")
            .located(By.xpath("//div[@class='be-footer__phone-info']/span[1]"));

    public static final Target CONTINUE = Target
            .the("CONTINUE PRICIN")
            .located(By.cssSelector(".be-hdr-d__col-continue"));

    public static final Target CONTINUE_INFORMATION = Target
            .the("CONTINUE INFORMATION")
            .located(By.id("ges-submit-btn0"));

    public static final Target CONFIRMACION_INFORMATION = Target
            .the("Confirm Information")
            .located(By.cssSelector(".giv-heading"));
}
