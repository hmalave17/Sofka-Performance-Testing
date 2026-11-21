package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUserInterface extends PageObject {

    private CartUserInterface(){}

    public static final Target BUTTON_CHECKOUT = Target.the("button checkout").located(By.id("checkout"));

}
