package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.Clic;
import co.com.sofka.certification.userinterfaces.HomePageUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class IntoCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Clic.on(HomePageUserInterface.BUTTON_CARD));
    }
    public static IntoCart item(){
        return Tasks.instrumented(IntoCart.class);
    }
}
