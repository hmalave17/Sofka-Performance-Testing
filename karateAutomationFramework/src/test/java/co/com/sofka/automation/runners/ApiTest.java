package co.com.sofka.automation.runners;

import com.intuit.karate.junit5.Karate;

public class ApiTest {

    @Karate.Test
    Karate runApiTests() {
        return Karate.run("classpath:features");
    }
}