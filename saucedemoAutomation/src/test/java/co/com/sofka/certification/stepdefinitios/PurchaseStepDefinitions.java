package co.com.sofka.certification.stepdefinitios;

import co.com.sofka.certification.exceptions.MessageUnexpected;
import co.com.sofka.certification.questions.ElementText;
import co.com.sofka.certification.tasks.SetDataTest;
import co.com.sofka.certification.tasks.Login;
import co.com.sofka.certification.tasks.AddTo;
import co.com.sofka.certification.tasks.IntoCart;
import co.com.sofka.certification.tasks.PressButtonCheckout;
import co.com.sofka.certification.tasks.FillForm;
import co.com.sofka.certification.tasks.Complete;
import co.com.sofka.certification.userinterfaces.CompleteUserInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.certification.utils.Constants.SHEET;
import static co.com.sofka.certification.utils.Constants.SUCCESS_TEST;
import static co.com.sofka.certification.utils.Constants.ITEM_BACKPACK;
import static co.com.sofka.certification.utils.Constants.ITEM_BIKE_LIGHT;
import static co.com.sofka.certification.utils.MessageExpected.ORDER_SUCCESSFUL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PurchaseStepDefinitions {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theActorInTheSpotlight().attemptsTo(SetDataTest.user(SHEET, SUCCESS_TEST));
        theActorInTheSpotlight().attemptsTo(Login.user());
    }

    @Given("the user adds an item to the cart")
    public void theUserAddsAnItemToTheCart() {
        theActorInTheSpotlight().attemptsTo(AddTo.cart(ITEM_BACKPACK));
        theActorInTheSpotlight().attemptsTo(AddTo.cart(ITEM_BIKE_LIGHT));
        theActorInTheSpotlight().attemptsTo(IntoCart.item());
    }

    @When("completes the checkout process")
    public void completesTheCheckoutProcess() {
        theActorInTheSpotlight().attemptsTo(PressButtonCheckout.button());
        theActorInTheSpotlight().attemptsTo(FillForm.user());
        theActorInTheSpotlight().attemptsTo(Complete.purchase());
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        theActorInTheSpotlight().should(seeThat(
                ElementText.contain(CompleteUserInterface.LABEL_SUCCESSFUL_ORDER, ORDER_SUCCESSFUL),
                equalTo(true)).orComplainWith(Error.class, MessageUnexpected.UNEXPECTED_MESSAGE)
        );
    }
}
