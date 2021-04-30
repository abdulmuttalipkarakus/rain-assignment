Technologies Covered in This Project
====================================

# Selenium
[Selenium](https://www.seleniumhq.org/) is for automating web applications for testing purposes.


# TestNG
[TestNG](https://testng.org/doc/) is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use.

Building and Running the Project
================================

## Prerequisites
There are a few things needed before you run the tests. Make sure you have the latest versions of the following installed:
- [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/)

## Setup
1. Clone the repo
2. Install dependencies with `mvn install`

## Run tests

1. Run specific TestNG.xml file with `mvn clean test -Dbrowser=<browserName> -Dsurefire.suiteXmlFiles=<testNGFile>`
   
   Example:  `mvn clean test -DbrowserType=chrome -Dsurefire.suiteXmlFiles=RunAllTest.xml`
   
#### Note
- You can view html test results on the `/target/surefire-reports/emailable-report.html` path after running
