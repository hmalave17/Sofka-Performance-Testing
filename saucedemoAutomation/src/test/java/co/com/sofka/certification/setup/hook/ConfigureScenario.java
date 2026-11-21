package co.com.sofka.certification.setup.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static co.com.sofka.certification.utils.Constants.USER;
import static co.com.sofka.certification.utils.Constants.URL_PAGE;
import static co.com.sofka.certification.utils.MessageSystem.INVALID_URL;
import static net.serenitybdd.screenplay.actions.Open.url;
public class ConfigureScenario {

    private WebDriver herBrowser;

    @Before
    public void start() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments(
                "--start-maximized",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-notifications",
                "--disable-save-password-bubble",
                "--disable-features=PasswordCheck",
                "--no-default-browser-check",
                "--no-first-run",
                "--incognito"
        );

        options.setExperimentalOption(
                "excludeSwitches",
                Arrays.asList("enable-automation", "load-extension")
        );

        herBrowser = new ChromeDriver(options);
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled(USER);
        user.can(BrowseTheWeb.with(herBrowser));
        String urlHomePage = SystemEnvironmentVariables
                .createEnvironmentVariables()
                .getProperty(URL_PAGE);

        if (urlHomePage == null || urlHomePage.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_URL);
        }

        user.attemptsTo(url(urlHomePage));
    }

    @After
    public void finalizeScenario() {
        try {
            if (herBrowser != null) {
                herBrowser.quit();
            }
        } finally {
            OnStage.drawTheCurtain();
            herBrowser = null;
        }
    }
}