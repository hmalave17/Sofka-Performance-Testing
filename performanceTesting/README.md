<h1>Performance Testing – FakeStore API | Sofka Technologies</h1>

<h2>1. Project Overview</h2>

<p>
    This repository contains the performance testing solution developed as part of the
    <strong>Sofka Technologies Technical Assessment</strong>.
</p>

<p>
    The objective is to evaluate the performance, responsiveness, and reliability of the FakeStore API
    authentication endpoint using Apache JMeter.
</p>

<p>
    The solution implements a controlled load test simulating concurrent users authenticating against
    the API, using external CSV test data and configurable workload parameters.
</p>

<p>
    The test execution focuses on measuring throughput, response times, and error rates to determine
    whether the API meets the performance acceptance criteria defined in the assessment.
</p>

<h2>2. Technologies and Tools</h2>

<table>
    <thead>
        <tr>
            <th>Technology / Tool</th>
            <th>Version</th>
            <th>Purpose</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Apache JMeter</td><td>5.6.3</td><td>Performance and load testing execution.</td></tr>
        <tr><td>Java (JDK)</td><td>Microsoft OpenJDK 11.0.18 (64-bit)</td><td>Runtime environment used by Apache JMeter 5.6.3.</td></tr>
        <tr><td>CSV</td><td>Standard CSV format</td><td>External parameterized test data.</td></tr>
        <tr><td>JSON</td><td>Standard JSON format</td><td>HTTP request payload and API response validation.</td></tr>
        <tr><td>HTTP</td><td>HTTPS</td><td>Communication protocol used to access the API.</td></tr>
        <tr><td>PowerShell</td><td>Windows PowerShell 5.1</td><td>Test execution support, result analysis, and project validation.</td></tr>
    </tbody>
</table>

<h2>3. Performance Testing Scope</h2>

<p>The solution evaluates the following API endpoint:</p>

<p><strong>API:</strong> FakeStore API</p>
<p><strong>HTTP Method:</strong> POST</p>
<p><strong>Endpoint:</strong> <code>https://fakestoreapi.com/auth/login</code></p>

<h3>3.1 Authentication Scenario</h3>

<p>
    The test simulates concurrent users performing authentication requests using valid credentials
    provided through an external CSV file.
</p>

<p>The scenario includes:</p>

<ol>
    <li>Read username and password values from the CSV test data file.</li>
    <li>Build the authentication request using dynamically parameterized JSON variables.</li>
    <li>Send HTTP POST requests to the authentication endpoint.</li>
    <li>Validate the expected HTTP response status.</li>
    <li>Verify the presence of the authentication token in the JSON response.</li>
    <li>Collect performance measurements for each request.</li>
</ol>

<p><strong>Total concurrent virtual users:</strong> 20</p>

<h2>4. Test Plan Architecture</h2>

<p>
    The performance test plan was implemented using Apache JMeter and organized into reusable
    configuration and execution components.
</p>

<p>The main components are:</p>

<ul>
    <li><strong>Thread Group:</strong> Controls the number of concurrent virtual users and test duration.</li>
    <li><strong>CSV Data Set Config:</strong> Reads external authentication data and assigns values to JMeter variables.</li>
    <li><strong>HTTP Request:</strong> Sends POST requests to the FakeStore authentication endpoint.</li>
    <li><strong>HTTP Header Manager:</strong> Configures the request headers required for JSON communication.</li>
    <li><strong>Constant Throughput Timer:</strong> Controls the target request throughput.</li>
    <li><strong>Response Code Assertion:</strong> Validates the expected HTTP status code.</li>
    <li><strong>JSONPath Assertion:</strong> Verifies the existence of the authentication token.</li>
    <li><strong>Simple Data Writer:</strong> Records execution results in JTL format.</li>
</ul>

<h2>5. Project Structure</h2>

<pre><code>.
├── data/
│   └── users.csv
│
├── test-plans/
│   └── FakeStoreLogin_Performance_Calibrated_21TPS.jmx
│
├── results/
│   └── FakeStoreLogin_Calibration_21TPS.jtl
│
├── reports/
│   └── html-report/
│       ├── index.html
│       ├── statistics.json
│       └── [Dashboard resources and dependencies]
│
├── README.md
├── readme.txt
└── conclusiones.txt</code></pre>

<h2>6. Package and Directory Responsibilities</h2>

<table>
    <thead>
        <tr>
            <th>Directory / File</th>
            <th>Responsibility</th>
        </tr>
    </thead>
    <tbody>
        <tr><td><code>data/</code></td><td>Stores external performance testing data.</td></tr>
        <tr><td><code>data/users.csv</code></td><td>Contains the five test user records used for authentication.</td></tr>
        <tr><td><code>test-plans/</code></td><td>Contains the definitive JMeter test plan.</td></tr>
        <tr><td><code>results/</code></td><td>Stores the JTL execution evidence.</td></tr>
        <tr><td><code>reports/html-report/</code></td><td>Contains the generated JMeter HTML dashboard and its resources.</td></tr>
        <tr><td><code>README.md</code></td><td>Technical overview, architecture, configuration, and performance results.</td></tr>
        <tr><td><code>readme.txt</code></td><td>Step-by-step installation and execution instructions.</td></tr>
        <tr><td><code>conclusiones.txt</code></td><td>Performance findings, observations, and final conclusions.</td></tr>
    </tbody>
</table>

<h2>7. Performance Test Configuration</h2>

<p>
    The definitive execution uses a Thread Group configured to simulate 20 concurrent virtual users.
</p>

<h3>7.1 Thread Group Configuration</h3>

<table>
    <thead>
        <tr>
            <th>Parameter</th>
            <th>Configured Value</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Thread Group</td><td>FakeStore Login Users</td></tr>
        <tr><td>Number of Threads (Users)</td><td>20</td></tr>
        <tr><td>Ramp-up Period</td><td>10 seconds</td></tr>
        <tr><td>Loop Count</td><td>Infinite</td></tr>
        <tr><td>Scheduler</td><td>Enabled</td></tr>
        <tr><td>Duration</td><td>60 seconds</td></tr>
        <tr><td>Startup Delay</td><td>0 seconds</td></tr>
        <tr><td>Same user on next iteration</td><td>True</td></tr>
    </tbody>
</table>

<h3>7.2 Throughput Configuration</h3>

<p>
    A Constant Throughput Timer is used to control the target request rate during the test.
</p>

<table>
    <thead>
        <tr>
            <th>Parameter</th>
            <th>Configured Value</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Component</td><td>Constant Throughput Timer</td></tr>
        <tr><td>Target Throughput</td><td>1260 samples per minute</td></tr>
        <tr><td>Equivalent Target</td><td>21 requests per second (TPS)</td></tr>
        <tr><td>Calculation Mode</td><td>All active threads in current thread group</td></tr>
    </tbody>
</table>

<p>
    The throughput target was calibrated from an initial configuration of 1200 samples per minute
    to 1260 samples per minute to achieve the required minimum throughput.
</p>

<h2>8. Response Validation</h2>

<p>
    JMeter assertions are implemented to validate the functional correctness of the authentication
    requests during performance execution.
</p>

<p>The validation strategy includes:</p>

<ul>
    <li><strong>HTTP Response Code:</strong> Expected status code 201.</li>
    <li><strong>JSONPath Assertion:</strong> Validates the existence of <code>$.token</code> in the JSON response.</li>
    <li><strong>Execution Results:</strong> Records successful and failed samples in the JTL file.</li>
</ul>

<p>
    These assertions ensure that performance measurements are collected alongside basic
    authentication response validation.
</p>

<h2>9. Test Execution and Performance Results</h2>

<p>
    The definitive performance execution was completed using Apache JMeter 5.6.3 in non-GUI mode.
</p>

<p><strong>Test Plan:</strong></p>
<pre><code>test-plans/FakeStoreLogin_Performance_Calibrated_21TPS.jmx</code></pre>

<p><strong>Execution Evidence:</strong></p>
<pre><code>results/FakeStoreLogin_Calibration_21TPS.jtl</code></pre>

<p>The execution generated the following results:</p>

<table>
    <thead>
        <tr>
            <th>Metric</th>
            <th>Measured Result</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Total Samples</td><td>1,220</td></tr>
        <tr><td>Effective Duration</td><td>60.100 seconds</td></tr>
        <tr><td>Throughput</td><td>20.300 TPS</td></tr>
        <tr><td>Average Response Time</td><td>295.69 ms</td></tr>
        <tr><td>Minimum Response Time</td><td>276 ms</td></tr>
        <tr><td>Maximum Response Time</td><td>1,229 ms</td></tr>
        <tr><td>90th Percentile (P90)</td><td>302 ms</td></tr>
        <tr><td>95th Percentile (P95)</td><td>312 ms</td></tr>
        <tr><td>99th Percentile (P99)</td><td>444 ms</td></tr>
        <tr><td>Successful HTTP Responses</td><td>1,220 (HTTP 201)</td></tr>
        <tr><td>Failed Samples</td><td>0</td></tr>
        <tr><td>Error Rate</td><td>0.000%</td></tr>
    </tbody>
</table>

<h3>9.1 Official Acceptance Criteria</h3>

<p>The assessment defines the following performance acceptance criteria:</p>

<table>
    <thead>
        <tr>
            <th>Acceptance Criterion</th>
            <th>Requirement</th>
            <th>Actual Result</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Throughput</td>
            <td>Minimum 20 TPS</td>
            <td>20.300 TPS</td>
            <td>PASS</td>
        </tr>
        <tr>
            <td>Maximum Response Time</td>
            <td>Maximum 1,500 ms</td>
            <td>1,229 ms</td>
            <td>PASS</td>
        </tr>
        <tr>
            <td>Error Rate</td>
            <td>Below 3%</td>
            <td>0.000%</td>
            <td>PASS</td>
        </tr>
    </tbody>
</table>

<p><strong>Overall Acceptance Result: 3 out of 3 criteria successfully met.</strong></p>

<h3>9.2 HTML Performance Dashboard</h3>

<p>
    The Apache JMeter HTML performance dashboard was generated using the existing
    JTL execution evidence, without executing the performance test again.
</p>

<p><strong>Dashboard location:</strong></p>
<pre><code>reports/html-report/index.html</code></pre>

<p>
    The generated dashboard contains aggregated execution statistics, response time measurements,
    throughput information, and performance visualizations.
</p>

<p>
    The dashboard statistics were compared against the original JTL execution evidence
    to verify consistency between the generated report and the recorded execution data.
</p>

<p>
    The original JTL file remains the primary execution evidence.
</p>

<h2>10. Reproducibility and Execution</h2>

<p>
    The repository includes the definitive JMeter test plan, external CSV test data, and the
    execution evidence required to reproduce and inspect the performance scenario.
</p>

<p>
    For detailed installation requirements and step-by-step execution instructions, refer to:
    <code>readme.txt</code>.
</p>

<p>
    The test can be executed in non-GUI mode using Apache JMeter's command-line interface.
</p>

<p>
    The HTML dashboard can also be regenerated from the existing JTL evidence without repeating
    the performance execution.
</p>

<h2>11. Limitations and Observations</h2>

<ul>
    <li>The performance assessment evaluates the FakeStore API authentication endpoint only.</li>
    <li>The measured results correspond to the specific test environment and execution conditions.</li>
    <li>Network conditions, API availability, and external service limitations may influence the measured performance.</li>
    <li>The JTL evidence records execution measurements but does not independently establish which individual usernames were consumed by each request.</li>
    <li>The CSV contains five unique test records configured for shared consumption across virtual users.</li>
    <li>The throughput reported by JMeter represents the measured execution rate, not a guarantee of identical performance under different environments.</li>
</ul>

<h2>12. Final Notes</h2>

<p>
    This solution was developed specifically for the <strong>Sofka Technologies Technical Assessment</strong>
    to demonstrate practical performance testing capabilities using Apache JMeter.
</p>

<p>
    The definitive execution successfully achieved all three official performance acceptance criteria:
    minimum throughput, maximum response time, and error rate.
</p>

<p>
    The project provides a reproducible test plan, external test data, execution evidence,
    and a generated HTML dashboard to support the analysis and verification of the results.
</p>

<p>
    For detailed setup and execution instructions, refer to <code>readme.txt</code>.
</p>

<p>
    For performance findings, observations, and final conclusions, refer to <code>conclusiones.txt</code>.
</p>