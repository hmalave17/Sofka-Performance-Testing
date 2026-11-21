
package co.com.sofka.certification.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementText implements Question<Boolean> {

    private final Target element;
    private final String expectedMessage;
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementText.class);

    public ElementText(Target element, String expectedMessage) {
        this.element = element;
        this.expectedMessage = expectedMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String currentMessage = element.resolveFor(actor).getText();

        boolean isExpected = currentMessage != null
                && currentMessage.equalsIgnoreCase(expectedMessage);

        if (!isExpected) {
            LOGGER.error(
                    "TEXT VALIDATION FAILED | Expected message: {} | Current message: {}",
                    expectedMessage,
                    currentMessage
            );

            Serenity.recordReportData()
                    .withTitle("Text validation failure")
                    .andContents(String.format(
                            "Expected message: %s%nCurrent message: %s",
                            expectedMessage,
                            currentMessage
                    ));
        }

        return isExpected;
    }

    public static ElementText contain(Target element, String text) {
        return new ElementText(element, text);
    }
}
