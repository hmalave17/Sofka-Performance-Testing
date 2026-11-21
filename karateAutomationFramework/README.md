<h1>Technical Challenge – API Test Automation | Sofka Technologies</h1>

<h2>1. Project Overview</h2>

<p>
    This repository contains the API test automation solution developed as part of the technical assessment process for
    <strong>Sofka Technologies</strong>.
</p>

<p>
    The objective is to demonstrate the implementation of an API test automation framework using Java,
    Karate Framework, Maven, and JUnit 5.
</p>

<p>
    The solution focuses on validating the user authentication and registration functionalities of the DemoBlaze API,
    covering positive and negative test scenarios.
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
        <tr><td>Apache Maven</td><td>Build and dependency management</td></tr>
        <tr><td>Karate Framework 1.3.1</td><td>API test automation framework</td></tr>
        <tr><td>JUnit 5</td><td>Test execution and integration</td></tr>
        <tr><td>JSON</td><td>Request payloads and response validation</td></tr>
        <tr><td>Gherkin</td><td>Behavior-driven test scenario definition</td></tr>
    </tbody>
</table>

<h2>3. Automation Scope</h2>

<p>The automated solution covers the following API functionalities:</p>

<h3>3.1 User Authentication</h3>

<p><strong>Endpoint:</strong> <code>POST /login</code></p>

<ol>
    <li><strong>Successful Login:</strong> Authenticate an existing user using valid credentials and verify the authentication token.</li>
    <li><strong>Invalid Login:</strong> Attempt authentication using invalid credentials and validate the expected error response.</li>
</ol>

<h3>3.2 User Registration</h3>

<p><strong>Endpoint:</strong> <code>POST /signup</code></p>

<ol>
    <li><strong>Successful Registration:</strong> Register a new user using dynamically generated credentials.</li>
    <li><strong>Existing User Registration:</strong> Attempt to register an existing user and validate the expected error response.</li>
</ol>

<p><strong>Total automated scenarios: 4</strong></p>

<h2>4. Framework Architecture</h2>

<p>
    The project follows a modular architecture using Karate Framework capabilities to separate test scenarios,
    test data, request templates, and configuration.
</p>

<p>The main architectural components are:</p>

<ul>
    <li><strong>Features:</strong> Define API test scenarios using Gherkin syntax.</li>
    <li><strong>Runners:</strong> Integrate Karate with JUnit 5 and manage test execution.</li>
    <li><strong>Configuration:</strong> Centralizes environment settings, API base URL, and reusable functions.</li>
    <li><strong>Test Data:</strong> Stores user credentials and input data required by test scenarios.</li>
    <li><strong>Request Templates:</strong> Define reusable JSON payload structures with dynamic values.</li>
    <li><strong>Schemas:</strong> Define reusable response validation structures.</li>
</ul>

<h2>5. Project Structure</h2>

<pre><code>.
├── src/
│   ├── main/
│   │   └── java/
│   │
│   └── test/
│       ├── java/
│       │   └── co/com/sofka/automation/
│       │       └── runners/
│       │           └── ApiTest.java
│       │
│       └── resources/
│           ├── karate-config.js
│           │
│           ├── data/
│           │   ├── users.json
│           │   └── requests/
│           │       └── signup-request.json
│           │
│           ├── features/
│           │   ├── login.feature
│           │   └── signup.feature
│           │
│           └── schemas/
│               └── error-response.json
│
├── .gitignore
├── pom.xml
├── README.md
├── readme.txt
└── conclusiones.txt</code></pre>

<h3>Package and Directory Responsibilities</h3>

<table>
    <thead>
        <tr>
            <th>Directory / File</th>
            <th>Responsibility</th>
        </tr>
    </thead>
    <tbody>
        <tr><td><code>runners</code></td><td>JUnit 5 test execution entry point.</td></tr>
        <tr><td><code>features</code></td><td>API test scenarios written in Gherkin.</td></tr>
        <tr><td><code>data</code></td><td>External test data management.</td></tr>
        <tr><td><code>data/requests</code></td><td>External JSON request templates.</td></tr>
        <tr><td><code>schemas</code></td><td>Reusable response validation structures.</td></tr>
        <tr><td><code>karate-config.js</code></td><td>Environment configuration and reusable JavaScript functions.</td></tr>
        <tr><td><code>pom.xml</code></td><td>Project dependencies, build configuration, and Maven plugins.</td></tr>
    </tbody>
</table>

<h2>6. Test Data Management</h2>

<p>
    Test data is maintained in external JSON files located under:
</p>

<p><code>src/test/resources/data/</code></p>

<p>
    The <code>users.json</code> file contains the credentials required for the authentication and registration scenarios.
</p>

<p>
    The project also uses external request templates stored under:
</p>

<p><code>src/test/resources/data/requests/</code></p>

<p>
    The <code>signup-request.json</code> template defines the registration payload and uses Karate embedded expressions
    to populate dynamic values during execution.
</p>

<p>
    This approach separates test data and request structures from the test implementation,
    improving maintainability and reusability.
</p>

<h3>Dynamic Test Data Generation</h3>

<p>
    The framework implements a reusable <code>generateUsername()</code> function in
    <code>karate-config.js</code>, using Java's UUID utility to generate unique usernames.
</p>

<p>
    This prevents duplicate username conflicts when executing the registration scenario multiple times.
</p>

<h2>7. Configuration</h2>

<p>The main configuration file is:</p>

<p><code>src/test/resources/karate-config.js</code></p>

<p>
    This file centralizes the API configuration and reusable functions required by the test scenarios.
</p>

<p>The current configuration includes:</p>

<ul>
    <li><strong>Environment:</strong> QA (default environment).</li>
    <li><strong>Base URL:</strong> <code>https://api.demoblaze.com/</code></li>
    <li><strong>Username Generator:</strong> Dynamically generates unique usernames using UUID.</li>
</ul>

<h2>8. Response Validation</h2>

<p>
    Karate assertions are used to validate HTTP responses and ensure that the API behaves according to the expected results.
</p>

<p>The validation strategy includes:</p>

<ul>
    <li><strong>HTTP Status Codes:</strong> Validate the expected response status.</li>
    <li><strong>Authentication Token:</strong> Verify the presence of the authentication token in successful login responses.</li>
    <li><strong>Response Schema:</strong> Validate error response structures using reusable JSON schemas.</li>
    <li><strong>Error Messages:</strong> Verify application-level error messages for negative scenarios.</li>
    <li><strong>Empty Responses:</strong> Validate successful registration responses after normalizing whitespace.</li>
</ul>

<p>
    Negative scenarios validate application-level errors returned with HTTP 200 responses,
    according to the current API contract.
</p>

<h2>9. Test Reports and Execution Results</h2>

<p>
    After test execution, Karate automatically generates HTML reports containing detailed information about the test results.
</p>

<p><strong>Report directory:</strong></p>

<pre><code>target/karate-reports/</code></pre>

<p><strong>Main execution report:</strong></p>

<pre><code>target/karate-reports/karate-summary.html</code></pre>

<p>
    The reports provide scenario execution results, request and response details, execution logs,
    and failure information.
</p>

<h2>10. Design Considerations</h2>

<p>The implementation follows these engineering practices:</p>

<ul>
    <li><strong>Separation of Concerns:</strong> Test scenarios, configuration, test data, and request templates are maintained independently.</li>
    <li><strong>Reusability:</strong> Shared configuration, JSON schemas, and utility functions reduce duplication.</li>
    <li><strong>Maintainability:</strong> External JSON files simplify test data and request management.</li>
    <li><strong>Dynamic Test Data:</strong> Unique usernames prevent conflicts during repeated executions.</li>
    <li><strong>Readable Scenarios:</strong> Gherkin syntax provides clear and understandable test descriptions.</li>
    <li><strong>Positive and Negative Coverage:</strong> Both successful and unsuccessful API operations are validated.</li>
</ul>

<h2>11. Final Notes</h2>

<p>
    This solution was developed specifically for the <strong>Sofka Technologies QA Automation Technical Assessment</strong>.
</p>

<p>
    The repository demonstrates the implementation of API automation practices using Karate Framework,
    Java, Maven, and JUnit 5, with a focus on maintainability, readability, and reliable test execution.
</p>

<p>
    For project setup, configuration, and execution instructions, refer to <code>readme.txt</code>.
</p>

<p>
    For execution results, observations, limitations, and conclusions, refer to <code>conclusiones.txt</code>.
</p>