package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.Clic;
import co.com.sofka.certification.interactions.Type;
import co.com.sofka.certification.models.DataExcel;
import co.com.sofka.certification.models.User;
import co.com.sofka.certification.userinterfaces.LoginPageUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

import static co.com.sofka.certification.utils.Constants.DATA_TEST;
import static co.com.sofka.certification.utils.Constants.DATA_USER;

public class Login implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        DataExcel dataExcel = actor.recall(DATA_TEST);
        List<Map<String, String>> data = dataExcel.getSetDeDatos();
        User client = new User(data.get(0));
        actor.attemptsTo(Type.on(LoginPageUserInterface.INPUT_NAME, client.getUserTest()));
        actor.attemptsTo(Type.on(LoginPageUserInterface.INPUT_PASSWORD, client.getPassword()));
        actor.attemptsTo(Clic.on(LoginPageUserInterface.BUTTON_LOGIN));
        actor.remember(DATA_USER, client);
    }

    public static Login user(){
        return Tasks.instrumented(Login.class);
    }
}
