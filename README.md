 <h1>Sofka Technologies – Technical Assessment</h1>

<h2>1. Repository Overview</h2>

<p>
    This repository contains the technical assessment solutions developed as part of the selection process for
    <strong>Sofka Technologies</strong>.
</p>

<p>
    The repository consolidates three independent projects covering different areas of Software Quality Assurance,
    including performance testing, API test automation, and UI test automation.
</p>

<p>
    Each project was developed with a focus on maintainability, test reliability, reusable components,
    clear documentation, and structured test execution.
</p>

<h2>2. Assessment Projects</h2>

<h3>2.1 Performance Testing – FakeStore API</h3>

<p><strong>Project Directory:</strong> <code>performanceTesting/</code></p>

<p>
    Performance testing solution developed using Apache JMeter to evaluate the authentication endpoint
    of the FakeStore API under controlled load conditions.
</p>

<p><strong>Testing Scope:</strong></p>

<ul>
    <li>Load testing with 20 virtual users.</li>
    <li>10-second ramp-up period.</li>
    <li>60-second test execution duration.</li>
    <li>Target throughput of 21 requests per second.</li>
    <li>External CSV test data parameterization using five test accounts.</li>
    <li>HTTP response code and JSON token validation.</li>
    <li>JTL execution evidence and HTML Performance Dashboard.</li>
    <li>Analysis against the official performance acceptance criteria.</li>
</ul>

<p><strong>Technologies and Tools:</strong></p>

<ul>
    <li>Apache JMeter 5.6.3</li>
    <li>Java 11</li>
    <li>Windows PowerShell 5.1</li>
    <li>CSV test data</li>
    <li>HTML Performance Dashboard</li>
</ul>

<p><strong>Official Acceptance Results:</strong></p>

<table>
    <thead>
        <tr>
            <th>Criterion</th>
            <th>Requirement</th>
            <th>Result</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Throughput</td>
            <td>Minimum 20 TPS</td>
            <td>20.300 TPS</td>
            <td><strong>PASS</strong></td>
        </tr>
        <tr>
            <td>Maximum Response Time</td>
            <td>Maximum 1,500 ms</td>
            <td>1,229 ms</td>
            <td><strong>PASS</strong></td>
        </tr>
        <tr>
            <td>Error Rate</td>
            <td>Below 3%</td>
            <td>0.000%</td>
            <td><strong>PASS</strong></td>
        </tr>
    </tbody>
</table>

<p><strong>Overall Result:</strong> 3 out of 3 acceptance criteria successfully met.</p>

<p>
    For the test architecture, execution instructions, detailed metrics, and performance analysis,
    refer to the project documentation.
</p>

<p>
    <a href="./performanceTesting/README.md">Explore Performance Testing Documentation</a>
</p>

<hr/>

<h3>2.2 API Test Automation – Karate Framework</h3>

<p><strong>Project Directory:</strong> <code>karateAutomationFramework/</code></p>

<p>
    API test automation solution developed using Karate Framework to validate authentication
    and user registration functionalities of the DemoBlaze API.
</p>

<p><strong>Testing Scope:</strong></p>

<ul>
    <li>Successful user authentication.</li>
    <li>Authentication with invalid credentials.</li>
    <li>Successful user registration.</li>
    <li>Registration attempts using existing users.</li>
    <li>Positive and negative API scenario validation.</li>
    <li>Automated HTML test reporting.</li>
</ul>

<p><strong>Technologies and Tools:</strong></p>

<ul>
    <li>Java 11</li>
    <li>Apache Maven</li>
    <li>Karate Framework</li>
    <li>JUnit 5</li>
    <li>JSON</li>
    <li>Gherkin</li>
</ul>

<p><strong>Automation Scope:</strong> 4 automated scenarios.</p>

<p>
    The framework follows a modular structure separating test scenarios, configuration,
    test data, request templates, and reusable validation components.
</p>

<p>
    <a href="./karateAutomationFramework/README.md">Explore Karate Automation Documentation</a>
</p>

<hr/>

<h3>2.3 UI Test Automation – SauceDemo</h3>

<p><strong>Project Directory:</strong> <code>saucedemoAutomation/</code></p>

<p>
    UI test automation solution developed to validate web application functionality through
    automated browser-based testing.
</p>

<p><strong>Testing Scope:</strong></p>

<ul>
    <li>Automated web application testing.</li>
    <li>Browser-based test execution.</li>
    <li>Test environment configuration.</li>
    <li>Automated test execution reporting.</li>
</ul>

<p><strong>Technologies and Tools:</strong></p>

<ul>
    <li>Java 11</li>
    <li>Gradle</li>
    <li>Google Chrome</li>
    <li>Serenity BDD</li>
</ul>

<p>
    <a href="./saucedemoAutomation/README.md">Explore SauceDemo Automation Documentation</a>
</p>

<h2>3. Repository Structure</h2>

<p>
    The repository is organized into three independent project directories.
    Each directory maintains its own source code, configuration files, execution resources,
    and documentation.
</p>

<pre><code>.
├── performanceTesting/
│   ├── data/
│   ├── test-plans/
│   ├── results/
│   ├── reports/
│   ├── README.md
│   ├── readme.txt
│   └── conclusiones.txt
│
├── karateAutomationFramework/
│   ├── src/
│   ├── README.md
│   └── readme.txt
│
├── saucedemoAutomation/
│   ├── src/
│   ├── README.md
│   └── readme.txt
│
└── README.md</code></pre>

<h2>4. Technologies and Tools Summary</h2>

<table>
    <thead>
        <tr>
            <th>Technology</th>
            <th>Project</th>
            <th>Purpose</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Java 11</td>
            <td>Karate / SauceDemo</td>
            <td>Programming language</td>
        </tr>
        <tr>
            <td>Apache JMeter 5.6.3</td>
            <td>Performance Testing</td>
            <td>Load generation and performance analysis</td>
        </tr>
        <tr>
            <td>Karate Framework</td>
            <td>API Automation</td>
            <td>API test automation</td>
        </tr>
        <tr>
            <td>JUnit 5</td>
            <td>API Automation</td>
            <td>Test execution and integration</td>
        </tr>
        <tr>
            <td>Apache Maven</td>
            <td>API Automation</td>
            <td>Build and dependency management</td>
        </tr>
        <tr>
            <td>Gradle</td>
            <td>UI Automation</td>
            <td>Build and test execution</td>
        </tr>
        <tr>
            <td>Serenity BDD</td>
            <td>UI Automation</td>
            <td>Test automation and reporting</td>
        </tr>
        <tr>
            <td>CSV / JSON</td>
            <td>Multiple Projects</td>
            <td>External test data management</td>
        </tr>
        <tr>
            <td>Git / GitHub</td>
            <td>All Projects</td>
            <td>Version control and source code management</td>
        </tr>
    </tbody>
</table>

<h2>5. Documentation and Execution</h2>

<p>
    Each project contains dedicated documentation describing its architecture,
    prerequisites, configuration, execution procedures, and test results.
</p>

<table>
    <thead>
        <tr>
            <th>Project</th>
            <th>Technical Documentation</th>
            <th>Execution Guide</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Performance Testing</td>
            <td><code>performanceTesting/README.md</code></td>
            <td><code>performanceTesting/readme.txt</code></td>
        </tr>
        <tr>
            <td>Karate API Automation</td>
            <td><code>karateAutomationFramework/README.md</code></td>
            <td><code>karateAutomationFramework/readme.txt</code></td>
        </tr>
        <tr>
            <td>SauceDemo UI Automation</td>
            <td><code>saucedemoAutomation/README.md</code></td>
            <td><code>saucedemoAutomation/readme.txt</code></td>
        </tr>
    </tbody>
</table>

<h2>6. General Considerations</h2>

<ul>
    <li>Each assessment project is independent and has its own execution requirements.</li>
    <li>Project-specific dependencies and configurations are documented separately.</li>
    <li>Test data and execution evidence are maintained within their corresponding project directories.</li>
    <li>Performance metrics and automation results should be interpreted according to each project's documented scope.</li>
    <li>Refer to the individual project documentation before executing its test suites.</li>
</ul>

<h2>7. Final Notes</h2>

<p>
    This repository consolidates the solutions developed for the
    <strong>Sofka Technologies Technical Assessment</strong>, demonstrating practical
    experience in Performance Engineering, API Test Automation, and UI Test Automation.
</p>

<p>
    The projects demonstrate the application of software testing practices,
    automation frameworks, structured test execution, and technical documentation.
</p>

<p>
    Each solution is maintained independently to facilitate navigation,
    understanding, execution, and future maintenance.
</p>

<h2>8. Author</h2>

<p>
    <strong>Hernán José Malavé</strong><br/>
    Software Quality Assurance | Test Automation | Performance Testing
</p>

<p>
    <em>Developed as part of the Sofka Technologies Technical Assessment.</em>
</p>
