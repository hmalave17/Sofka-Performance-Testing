SOFKA TECHNOLOGIES – TECHNICAL ASSESSMENT
PERFORMANCE TESTING – FAKESTORE API

============================================================
1. PREREQUISITES
============================================================

The following software is required to work with this project:

- Java Development Kit (JDK) 11 (64-bit recommended).
- Apache JMeter 5.6.3.
- Windows PowerShell 5.1 or higher.
- Git, if cloning the repository from GitHub.
- Internet access to reach the FakeStore API.

Verify the Java installation:

    java -version

Verify the Apache JMeter installation using its executable path:

    & "C:\path\to\apache-jmeter-5.6.3\bin\jmeter.bat" -v

The JMeter executable must point to the actual installation directory on your computer.

============================================================
2. GET THE PROJECT
============================================================

Clone the public GitHub repository:

    git clone <GITHUB_REPOSITORY_URL>

Navigate to the project directory:

    cd performanceTesting

If the repository is already downloaded, open PowerShell in the project root directory.

The project root must contain the following directories and files:

    data/
    test-plans/
    results/
    reports/
    README.md
    readme.txt
    conclusiones.txt

============================================================
3. VERIFY PROJECT FILES
============================================================

Before executing the test, verify that the required files exist:

    data/users.csv

    test-plans/FakeStoreLogin_Performance_Calibrated_21TPS.jmx

    results/FakeStoreLogin_Calibration_21TPS.jtl

The CSV file contains five test user records and uses the following columns:

    username,password

The test plan reads the authentication data from this external CSV file.

IMPORTANT:

- Do not replace the CSV structure or column names.
- Do not expose real credentials, passwords, or authentication tokens.
- Only use test credentials that are authorized for publication and assessment purposes.
- The CSV is configured for shared consumption across the virtual users.

============================================================
4. EXECUTE THE PERFORMANCE TEST
============================================================

The definitive JMeter test plan can be executed in non-GUI mode.

Open PowerShell in the project root directory and configure the JMeter executable path:

    $project = (Get-Location).Path

    $jmeter = "C:\path\to\apache-jmeter-5.6.3\bin\jmeter.bat"

Verify that the executable exists:

    Test-Path $jmeter

Execute the test using a new JTL output file:

    & $jmeter -n `
        -t "$project\test-plans\FakeStoreLogin_Performance_Calibrated_21TPS.jmx" `
        -l "$project\results\FakeStoreLogin_NewExecution.jtl"

IMPORTANT:

The command above starts a new performance test execution.

Use a different output filename for every new execution. Do not overwrite the original assessment evidence:

    results/FakeStoreLogin_Calibration_21TPS.jtl

The definitive test plan is configured with 20 virtual users, a 10-second ramp-up period, a 60-second execution duration, and a target throughput of 21 requests per second.

============================================================
5. TEST CONFIGURATION
============================================================

The definitive test plan uses the following configuration:

- Virtual Users: 20
- Ramp-up Period: 10 seconds
- Loop Count: Infinite
- Scheduler: Enabled
- Test Duration: 60 seconds
- Startup Delay: 0 seconds
- Constant Throughput Timer: 1260 samples per minute
- Target Throughput: 21 requests per second
- Throughput Calculation Mode: All active threads in current thread group

The authentication scenario sends HTTP POST requests to:

    https://fakestoreapi.com/auth/login

The test validates:

- Expected HTTP response code: 201.
- JSON authentication token existence: $.token.

============================================================
6. GENERATE THE HTML PERFORMANCE REPORT
============================================================

Apache JMeter can generate an HTML dashboard from an existing JTL file without executing the performance test again.

To generate the dashboard using the original assessment evidence, configure the paths:

    $project = (Get-Location).Path

    $jmeter = "C:\path\to\apache-jmeter-5.6.3\bin\jmeter.bat"

    $jtl = "$project\results\FakeStoreLogin_Calibration_21TPS.jtl"

    $report = "$project\reports\html-report"

Verify that the JTL file exists:

    Test-Path $jtl

The report output directory must not already exist or must be empty.

Generate the HTML dashboard:

    & $jmeter -g $jtl -o $report

After successful generation, open:

    reports/html-report/index.html

The dashboard includes aggregated execution statistics, response time measurements, throughput information, and performance visualizations.

If the output directory already exists and contains files, use a different output directory, such as:

    reports/html-report-rebuilt

Do not delete or overwrite an existing report without first reviewing its contents.

============================================================
7. EXISTING ASSESSMENT EVIDENCE
============================================================

The repository includes the definitive performance execution evidence:

    results/FakeStoreLogin_Calibration_21TPS.jtl

The recorded execution produced the following results:

- Total Samples: 1,220
- Effective Duration: 60.100 seconds
- Throughput: 20.300 TPS
- Average Response Time: 295.69 ms
- Minimum Response Time: 276 ms
- Maximum Response Time: 1,229 ms
- P90: 302 ms
- P95: 312 ms
- P99: 444 ms
- Successful HTTP Responses: 1,220
- Failed Samples: 0
- Error Rate: 0.000%

Official assessment acceptance criteria:

1. Throughput: Minimum 20 TPS.
   Result: 20.300 TPS – PASS.

2. Maximum Response Time: Maximum 1,500 ms.
   Result: 1,229 ms – PASS.

3. Error Rate: Below 3%.
   Result: 0.000% – PASS.

Overall result: 3 out of 3 acceptance criteria successfully met.

============================================================
8. ADDITIONAL INFORMATION
============================================================

For the technical overview, test architecture, configuration, and detailed performance results, refer to:

    README.md

For performance findings, observations, and final conclusions, refer to:

    conclusiones.txt

The original JTL evidence represents the recorded assessment execution. New executions may produce different measurements depending on API availability, network conditions, and the execution environment.

The JTL evidence records execution measurements but does not independently establish which individual usernames were consumed by each request.

The project is intended to provide a reproducible performance testing scenario using Apache JMeter 5.6.3.