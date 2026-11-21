package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUserInterface extends PageObject {

    private LoginPageUserInterface(){}

    public static final Target INPUT_NAME = Target.the("input name").located(By.id("user-name"));
    public static final Target INPUT_PASSWORD = Target.the("input password").located(By.id("password"));
    public static final Target BUTTON_LOGIN = Target.the("button login").located(By.id("login-button"));
}
