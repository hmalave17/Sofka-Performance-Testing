package co.com.sofka.certification.tasks;

import co.com.sofka.certification.userinterfaces.HomePageUserInterface;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AddTo implements Task {

    private int position;

    public AddTo(int position) {
        this.position = position;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade element = HomePageUserInterface.BUTTON_ADD_CART.resolveAllFor(actor).get(this.position);
        element.click();
    }

    public static AddTo cart(int position) {
        return Tasks.instrumented(AddTo.class, position);
    }

}
