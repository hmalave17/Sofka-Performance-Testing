package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.Clic;
import co.com.sofka.certification.userinterfaces.CartUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class PressButtonCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Clic.on(CartUserInterface.BUTTON_CHECKOUT));
    }
    public static PressButtonCheckout button(){
        return Tasks.instrumented(PressButtonCheckout.class);
    }
}
