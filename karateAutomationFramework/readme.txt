TECHNICAL CHALLENGE – API TEST AUTOMATION
SOFKA TECHNOLOGIES

==================================================
1. PREREQUISITES
==================================================

Make sure the following tools are installed:

- Java Development Kit (JDK) 11 or higher.
- Apache Maven 3.6 or higher.
- Git.

Verify the Java installation:

    java -version

Verify the Maven installation:

    mvn -version

==================================================
2. GET THE PROJECT
==================================================

Clone the repository:

    git clone https://github.com/hmalave17/Sofka-Performance-Testing.git

Navigate to the project directory:

    cd karateAutomationFramework

==================================================
3. EXECUTE THE AUTOMATED TESTS
==================================================

To execute all automated scenarios:

    mvn clean test

This command cleans the previous build artifacts, compiles the project, and executes the automated test suite.

==================================================
4. EXECUTE TESTS BY FUNCTIONALITY
==================================================

To execute only login scenarios:

    mvn test -Dkarate.options="--tags @login"

To execute only signup scenarios:

    mvn test -Dkarate.options="--tags @signup"

To execute the regression suite:

    mvn test -Dkarate.options="--tags @regression"

Note: These commands assume that the corresponding tags are defined in the feature files.

==================================================
5. TEST REPORTS
==================================================

After execution, Karate generates HTML reports automatically.

Report location:

    target/karate-reports/

Main execution report:

    target/karate-reports/karate-summary.html

Open the HTML report in a web browser to review the execution results, scenario details, request and response information, and potential failures.

==================================================
6. ADDITIONAL INFORMATION
==================================================

- The API base URL is configured in karate-config.js.
- Test credentials are maintained in external JSON files.
- New usernames are generated dynamically using UUID to avoid duplicate registration conflicts.
- No additional environment configuration is required for the default QA execution.

For further information about the framework architecture, technologies, and automation scope, refer to README.md.

For test findings and evaluation conclusions, refer to conclusiones.txt.