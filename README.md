# DropwizardTest

Introduction
------------
This sample project is to ensure dropwizard and testng can play well together. The intention is to use testng to 
test other applications end to end. 

Prerequisites
-------------
Ensure that the latest version of Chrome driver is installed on your machine

How to start the DropwizardTest application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/automation-experiment-1.0-SNAPSHOT.jar server automationexperiment.yml`
1. To check that your application is running enter url `http://localhost:8080`

Access the application
----------------------

To see your application work against www.hightail.com do a POST against http://localhost:8080/testsuite?suiteName=acceptance.
If you would like to hit any other URL then change the URL in automation.yml and the test criteria in 
com.hightail.automation.test.MarketingPageTest
