package co.com.sofka.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Clic implements Interaction {

    private Target element;

    public Clic(Target element){
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElement.visible(this.element));
        actor.attemptsTo(Click.on(element));
    }

    public static Clic on(Target element){
        return new Clic(element);
    }
}
