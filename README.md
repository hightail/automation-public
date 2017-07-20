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

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
