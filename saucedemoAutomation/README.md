 <h1>Technical Challenge – QA Automation | Sofka Technologies</h1>

<h2>1. Project Overview</h2>

<p>
    This repository contains the automated testing solution developed as part of the technical assessment process for
    <strong>Sofka Technologies</strong>.
</p>

<p>
    The objective is to demonstrate the implementation of an end-to-end (E2E) test automation framework using Java,
    Serenity BDD, Screenplay Pattern, and Cucumber.
</p>

<p>
    The solution focuses on validating the main purchase flow of the SauceDemo web application, covering the user
    journey from authentication to purchase completion.
</p>

<p>
    The framework was designed with an emphasis on maintainability, readability, reusability, and separation of responsibilities.
</p>

<h2>2. Technologies and Tools</h2>

<table>
    <thead>
        <tr>
            <th>Technology</th>
            <th>Purpose</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Java 11</td><td>Programming language</td></tr>
        <tr><td>Gradle</td><td>Build and dependency management</td></tr>
        <tr><td>Serenity BDD 4.1.10</td><td>Test automation framework and reporting</td></tr>
        <tr><td>Serenity Screenplay</td><td>Test design pattern</td></tr>
        <tr><td>Cucumber 7.14.0</td><td>BDD and Gherkin scenarios</td></tr>
        <tr><td>Selenium WebDriver</td><td>Browser automation</td></tr>
        <tr><td>JUnit 5</td><td>Test execution</td></tr>
        <tr><td>Apache POI / Fillo</td><td>Excel test data management</td></tr>
        <tr><td>SLF4J</td><td>Logging</td></tr>
        <tr><td>Google Chrome</td><td>Browser used for E2E execution</td></tr>
    </tbody>
</table>

<h2>3. Automation Scope</h2>

<p>The automated solution covers the following purchase workflow:</p>

<ol>
    <li><strong>User Authentication:</strong> Log in to SauceDemo using test credentials.</li>
    <li><strong>Product Selection:</strong> Select products from the inventory.</li>
    <li><strong>Shopping Cart:</strong> Add products and verify the cart contents.</li>
    <li><strong>Checkout:</strong> Start the checkout process.</li>
    <li><strong>Customer Information:</strong> Complete the required customer information.</li>
    <li><strong>Order Overview:</strong> Review the purchase information.</li>
    <li><strong>Purchase Completion:</strong> Finish the transaction and validate the confirmation message.</li>
</ol>

<h2>4. Framework Architecture</h2>

<p>
    The project follows the <strong>Screenplay Pattern</strong>, which promotes separation of concerns and reusable test components.
</p>

<p>The main architectural components are:</p>

<ul>
    <li><strong>Tasks:</strong> Represent business activities performed by an actor.</li>
    <li><strong>Interactions:</strong> Represent low-level actions performed on the user interface.</li>
    <li><strong>Questions:</strong> Retrieve information from the application to validate expected behavior.</li>
    <li><strong>User Interfaces:</strong> Centralize web element locators using Serenity <code>Target</code>.</li>
    <li><strong>Models:</strong> Represent and manage test data.</li>
    <li><strong>Utilities:</strong> Provide reusable helper methods and shared functionality.</li>
    <li><strong>Step Definitions:</strong> Connect Gherkin steps with the automation implementation.</li>
    <li><strong>Hooks:</strong> Manage scenario setup and teardown.</li>
</ul>

<h2>5. Project Structure</h2>

<pre><code>.
├── gradle/
│   └── wrapper/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── co/com/sofka/certification/
│   │           ├── exceptions/
│   │           │   ├── DoesNotFindData.java
│   │           │   └── MessageUnexpected.java
│   │           ├── interactions/
│   │           │   ├── Clic.java
│   │           │   ├── Type.java
│   │           │   └── WaitElement.java
│   │           ├── models/
│   │           │   ├── DataExcel.java
│   │           │   └── User.java
│   │           ├── questions/
│   │           │   └── ElementText.java
│   │           ├── tasks/
│   │           │   ├── AddTo.java
│   │           │   ├── Complete.java
│   │           │   ├── FillForm.java
│   │           │   ├── IntoCart.java
│   │           │   ├── Login.java
│   │           │   ├── PressButtonCheckout.java
│   │           │   └── SetDataTest.java
│   │           ├── userinterfaces/
│   │           │   ├── CartUserInterface.java
│   │           │   ├── CompleteUserInterface.java
│   │           │   ├── HomePageUserInterface.java
│   │           │   ├── LoginPageUserInterface.java
│   │           │   ├── OverviewUserInterface.java
│   │           │   └── YouInformationUserInterface.java
│   │           └── utils/
│   │               ├── Constants.java
│   │               ├── GetData.java
│   │               ├── MessageExpected.java
│   │               ├── MessageSystem.java
│   │               ├── SetData.java
│   │               └── Utils.java
│   └── test/
│       ├── java/
│       │   └── co/com/sofka/certification/
│       │       ├── runners/
│       │       │   └── Purchase.java
│       │       ├── setup/
│       │       │   └── hook/
│       │       │       └── ConfigureScenario.java
│       │       └── stepdefinitios/
│       │           └── PurchaseStepDefinitions.java
│       └── resources/
│           ├── datatables/
│           │   └── dataTest.xlsx
│           ├── features/
│           │   └── purchase.feature
│           └── serenity.properties
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle</code></pre>

<h3>Package Responsibilities</h3>

<table>
    <thead>
        <tr>
            <th>Package</th>
            <th>Responsibility</th>
        </tr>
    </thead>
    <tbody>
        <tr><td><code>exceptions</code></td><td>Custom exceptions used by the framework.</td></tr>
        <tr><td><code>interactions</code></td><td>Reusable low-level browser interactions.</td></tr>
        <tr><td><code>models</code></td><td>Data models used during test execution.</td></tr>
        <tr><td><code>questions</code></td><td>Application state and content validation.</td></tr>
        <tr><td><code>tasks</code></td><td>Business actions executed by the actor.</td></tr>
        <tr><td><code>userinterfaces</code></td><td>Web elements and locators.</td></tr>
        <tr><td><code>utils</code></td><td>Constants, data management, and reusable utilities.</td></tr>
        <tr><td><code>runners</code></td><td>Test execution entry point.</td></tr>
        <tr><td><code>setup.hook</code></td><td>Browser and scenario configuration.</td></tr>
        <tr><td><code>stepdefinitios</code></td><td>Cucumber step definitions.</td></tr>
    </tbody>
</table>

<h2>6. Test Data Management</h2>

<p>
    Test data is stored in an Excel file located at:
</p>

<p><code>src/test/resources/datatables/dataTest.xlsx</code></p>

<p>
    The framework uses this file to retrieve the information required by the test scenarios.
</p>

<p>
    The <code>SetDataTest</code> task loads the corresponding data set, while the
    <code>DataExcel</code> and <code>User</code> models help organize and access the information during execution.
</p>

<p>
    This approach separates test data from the automation implementation and makes it easier to maintain test scenarios.
</p>

<h2>7. Configuration</h2>

<p>The main configuration file is:</p>

<p><code>src/test/resources/serenity.properties</code></p>

<p>
    The project uses this file to define browser-related settings and Serenity execution properties.
</p>

<p>
    The application URL is configured through the <code>url_home_page</code> property.
</p>

<p>
    Verify that this property points to the intended SauceDemo environment before running the tests.
</p>

<h2>8. Test Reports and Execution Results</h2>

<p>The project configures the Cucumber JSON output at:</p>

<pre><code>build/reports/serenity/serenity.json</code></pre>

<p>Gradle test execution results are also available under:</p>

<pre><code>build/reports/tests/test/</code></pre>

<p>
    The Cucumber JSON output and the Gradle HTML test report are execution artifacts.
    They should not be confused with a generated Serenity aggregate HTML report.
</p>

<h2>9. Design Considerations</h2>

<p>The implementation follows these principles:</p>

<ul>
    <li><strong>Separation of concerns:</strong> Each framework component has a specific responsibility.</li>
    <li><strong>Reusability:</strong> Common interactions and tasks are designed to be reused across scenarios.</li>
    <li><strong>Maintainability:</strong> Locators, test data, and business actions are organized into dedicated packages.</li>
    <li><strong>Readability:</strong> Cucumber scenarios describe the business flow using Gherkin.</li>
    <li><strong>Scalability:</strong> The Screenplay Pattern provides a structure that can be extended with additional scenarios and reusable components.</li>
</ul>

<h2>10. Supporting Documentation</h2>

<p>The repository includes two additional documents:</p>

<ul>
    <li><strong>readme.txt:</strong> Prerequisites, configuration, and step-by-step instructions to execute the automated tests.</li>
    <li><strong>conclusiones.txt:</strong> Test execution results, findings, limitations, and conclusions from the assessment.</li>
</ul>

<h2>11. Final Notes</h2>

<p>
    This solution was developed specifically for the QA Automation technical assessment process at
    <strong>Sofka Technologies</strong>.
</p>

<p>
    The repository demonstrates the application of automation engineering practices through a structured
    Java-based E2E testing solution using Serenity BDD, Screenplay Pattern, Selenium WebDriver, and Cucumber.
</p>