package co.com.sofka.certification.tasks;

import co.com.sofka.certification.userinterfaces.OverviewUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Complete implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OverviewUserInterface.BUTTON_FINISH));
    }
    public static Complete purchase(){
        return Tasks.instrumented(Complete.class);
    }
}
