package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YouInformationUserInterface extends PageObject {

    private YouInformationUserInterface(){}

    public static final Target INPUT_NAME = Target.the("input name").located(By.name("firstName"));
    public static final Target INPUT_LAST_NAME = Target.the("input last name").located(By.name("lastName"));
    public static final Target INPUT_POSTAL_CODE = Target.the("input postal code").located(By.name("postalCode"));
    public static final Target BUTTON_CONTINUE = Target.the("button continue").located(By.id("continue"));

}
