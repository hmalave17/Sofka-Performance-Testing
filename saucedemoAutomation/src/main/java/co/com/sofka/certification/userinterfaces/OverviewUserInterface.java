package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OverviewUserInterface extends PageObject {

    private OverviewUserInterface(){}

    public static final Target BUTTON_FINISH = Target.the("button finish").located(By.id("finish"));

}
