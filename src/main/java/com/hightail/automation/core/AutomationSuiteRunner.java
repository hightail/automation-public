package com.hightail.automation.core;

import com.google.inject.Inject;
import com.hightail.automation.AutomationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva.paranandi on 3/31/17.
 */
public class AutomationSuiteRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutomationSuiteRunner.class);
    public static final String ALL_METHODS = "all";

    private AutomationConfiguration configuration;

    @Inject
    public AutomationSuiteRunner(AutomationConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Runs either with the suiteName in the configuration file, or passed in through the curl command or with
     * the classes (optional included methods) in the curl command.
     *
     * @param automationObjectFactory
     */
    public void run(AutomationObjectFactory automationObjectFactory) {

        TestNG testNG = new TestNG();

        populateTestNGForSuite(testNG);

        testNG.setObjectFactory(automationObjectFactory);

        TestListenerAdapter tla = new TestListenerAdapter();
        testNG.addListener(tla);

        testNG.run();
    }

    private void populateTestNGForSuite(TestNG testNG) {
        List<String> suites = new ArrayList<String>();
        suites.add(configuration.getSuitePath() + configuration.getSuiteName() + ".xml");
        testNG.setTestSuites(suites);
    }
}
