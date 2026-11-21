TECHNICAL CHALLENGE – QA AUTOMATION | SOFKA TECHNOLOGIES
EXECUTION GUIDE

1. PREREQUISITES

Before running the automated tests, make sure the following tools are installed:

- Java JDK 11.
- Gradle.
- Google Chrome.
- Git.

Verify the Java installation:

    java -version

Verify the Gradle installation:

    gradle -version

2. CLONE THE REPOSITORY

Clone the repository using the following command:

    git clone karateAutomationFramework

Navigate to the project directory:

    cd saucedemoAutomation

3. CONFIGURATION

Open the following configuration file:

    src/test/resources/serenity.properties

Verify that the application URL is correctly configured through the
url_home_page property.

Make sure Google Chrome is installed and available in the execution environment.

4. RUN THE AUTOMATED TESTS

From the project root directory, execute the following command on Windows:

    gradle w clean test

This command executes the Gradle tasks required to clean the previous
build output and run the automated test suite.

5. TEST EXECUTION REPORTS

After execution, the generated reports can be found in:

    build/reports/serenity/

    build/reports/tests/test/

The Gradle HTML report provides information about the test execution
results.

6. TROUBLESHOOTING

If the tests cannot be executed:

- Verify that Java JDK 11 is correctly installed.
- Verify that Gradle is available from the command line.
- Check the application URL in serenity.properties.
- Make sure Google Chrome is installed.
- Review the Gradle console output to identify execution errors.