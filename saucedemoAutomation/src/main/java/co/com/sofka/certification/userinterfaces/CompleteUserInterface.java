package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompleteUserInterface extends PageObject {

    private CompleteUserInterface(){}

    public static final Target LABEL_SUCCESSFUL_ORDER = Target.the("label successful order").located(By.className("complete-header"));
}
