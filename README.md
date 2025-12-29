# Project: Automated Testing of Online Store [Lamoda](https://www.lamoda.by/)

## :open_book: Table of Contents:

- [Technologies and Tools](#gear-technologies-and-tools)
- [Test Cases](#heavy_check_mark-test-cases)
- [Running Tests](#computer-running-tests-from-terminal)
- [Running Tests in Jenkins](#running-tests-in-jenkins)
- [Allure Report](#allure-report)
- [Telegram Notifications](#telegram-notifications)
- [Test Execution Video](#movie_camera-test-execution-video)

## :gear: Technologies and Tools

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50" alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media\logo\Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
</p>

This project contains automated tests written in **Java** using the **Selenide** testing framework.  
**Gradle** is used for project build management in **IntelliJ IDEA**.  
**JUnit5** is used as the unit testing framework.  
Tests are executed via **Jenkins**.  
**Selenoid** is used to run browsers inside **Docker** containers.

**Allure Report** and **Telegram Bot** are used for visualization and reporting of test results.

## :heavy_check_mark: Test Cases

- Verify adding a product to the cart
- Verify presence of main page headers
- Verify presence of sections on the main page
- Verify presence of the social networks block in the footer
- Verify product search functionality

## :computer: Running Tests from Terminal

### :house_with_garden: Local Test Execution

```bash
gradle clean test
```

### :earth_asia: Remote Test Execution

```bash
gradle clean test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DremoteDriverUrl={REMOTE_DRIVER_URL}
```

## Running Tests in Jenkins

* browser (default: chrome)
* browserVersion (default: 100.0)
* browserSize (default: 1920x1080)
* remoteDriverUrl (Selenoid URL)
* videoStorage (URL for test execution videos)

## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Running Tests in [Jenkins](https://jenkins.autotests.cloud/job/030_rudovich_jenkins_tests_modsen/)

To start a build, go to <code><strong>Build with Parameters</strong></code> and click <code><strong>Build</strong></code>.

<p align="center">
  <img src="media/screen/start_jenkins.png" alt="Jenkins" width="800">
</p>

## :allure: Report
## <img width="4%" title="Allure Report" src="media/logo/Allure_Report.svg"> Result of Testing in   [Allure Report](https://jenkins.autotests.cloud/job/015_aziyatdinov_final_ui/1/allure/)

<p align="center">
  <img src="media/screen/jenkins_overview.png" alt="allure-report" width="900">
</p>

<p align="center">
  <img src="media/screen/jenkins_behaviors.png" alt="allure-report_1" width="900">
</p>

## :telegram: Notifications
## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Telegram Notifications

After the build is complete, a dedicated bot in <code>Telegram</code> automatically processes and sends a message with
the test run report.

<p align="center">
<img title="Telegram Notifications" src="media/screen/notifications.png">

## :movie_camera: Test Execution Video

In Allure reports, each test includes not only screenshots but also a video recording of the test execution.

<p align="center">
  <img title="Video" src="media/video/Lamoda_tests.gif">
</p>