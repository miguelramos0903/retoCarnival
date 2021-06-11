package com.rappi.qa.carnival.userinterface.consultas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarCrucerosPage {

    public static final Target BOTON_DESTINO = Target
            .the("boton destino")
            .locatedBy("//*[contains(@aria-label, '{0}') and @type='button']");

    public static final Target BOTON_NAVEGAR_A = Target
            .the("boton navegar a")
            .located(By.id("cdc-destinations"));

    public static final Target BOTON_DURACION = Target
            .the("boton duracion")
            .located(By.id("cdc-durations"));

    public static final Target BOTON_DIAS = Target
            .the("boton de dias")
            .located(By.xpath("//*[@data-tealium='cdc-filter-button' and contains(text(), '6 - 9 Days')]"));

    public static final Target BOTON_BUSCAR = Target
            .the("boton buscar")
            .located(By.xpath("//*[@class='cdc-filters-tab cdc-filters-tab--searchcta ng-scope']"));

    public static final Target SELECCIONAR_IMAGEN = Target
            .the("seleccionar imagenes")
            .locatedBy("//*[@class='vrl-result-item vrl-list-view-tile ng-scope'][{0}]//*[@class='vrl-list-item']/div/a");

    public static final Target TEXTO_BUSQUEDA = Target
            .the("texto busqueda")
            .locatedBy("//*[@class='vrl-result-item vrl-list-view-tile ng-scope'][{0}]//*[@class='vrl-list-item']/div/a//following::span[4]");

    public static final Target BOTON_GUARDAR_BUSQUEDA = Target
            .the("boton guardar busqueda")
            .located(By.cssSelector(".component-itinerary-hero .footer .component-save-button"));

    public static final Target TEXTO_BOTON_GUARDAR = Target
            .the("texto del boton guardar")
            .located(By.cssSelector(".component-itinerary-hero .footer .ng-binding"));

    //public static final Target CITY_CRUISE = Target.the("City cruise").locatedBy("//*[@class='cgc-cruise-glance__title']");
}
