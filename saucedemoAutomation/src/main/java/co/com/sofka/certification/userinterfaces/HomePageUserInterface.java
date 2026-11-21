package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUserInterface extends PageObject {

    private HomePageUserInterface(){}

    public static final Target CARDS_ITEMS = Target.the("cards items").located(By.className("inventory_item_description"));
    public static final Target BUTTON_ADD_CART = Target.the("label home page").located(By.className("btn_inventory"));
    public static final Target BUTTON_CARD = Target.the("Button add card").located(By.className("shopping_cart_badge"));

}
