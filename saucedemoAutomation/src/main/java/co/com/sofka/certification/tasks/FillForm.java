package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.Clic;
import co.com.sofka.certification.interactions.Type;
import co.com.sofka.certification.models.User;
import co.com.sofka.certification.userinterfaces.YouInformationUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.sofka.certification.utils.Constants.DATA_USER;

public class FillForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        User client = actor.recall(DATA_USER);
        actor.attemptsTo(Type.on(YouInformationUserInterface.INPUT_NAME, client.getName()));
        actor.attemptsTo(Type.on(YouInformationUserInterface.INPUT_LAST_NAME, client.getLastName()));
        actor.attemptsTo(Type.on(YouInformationUserInterface.INPUT_POSTAL_CODE, client.getPostalCode()));
        actor.attemptsTo(Clic.on(YouInformationUserInterface.BUTTON_CONTINUE));
    }
    public static FillForm user(){
        return Tasks.instrumented(FillForm.class);
    }
}
