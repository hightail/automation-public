package com.hightail.automation.resources;

import com.google.inject.Inject;
import com.hightail.automation.AutomationConfiguration;
import com.hightail.automation.core.AutomationObjectFactory;
import com.hightail.automation.core.AutomationSuiteRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * Created by shiva.paranandi on 3/23/17.
 */
@Path("/testsuite")
@Produces(MediaType.APPLICATION_JSON)
public class AutomationResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutomationResource.class);

    private AutomationConfiguration configuration;
    private AutomationObjectFactory automationObjectFactory;

    @Inject
    AutomationResource(AutomationConfiguration configuration, AutomationObjectFactory automationObjectFactory) {
        this.configuration = configuration;
        this.automationObjectFactory = automationObjectFactory;
        LOGGER.info("Base URL: " + configuration.getBaseURL());
    }

    @POST
    /**
     * Runs a test. Look here to enhance functionality of calling tests programmatically
     * http://testng.org/doc/documentation-main.html#running-testng-programmatically.
     */
    public void runSuite(@QueryParam("suiteName") String suiteName) {
        configuration.setSuiteName(suiteName);

        AutomationSuiteRunner automationSuiteRunner = new AutomationSuiteRunner(configuration);
        automationSuiteRunner.run(automationObjectFactory);

        //TODO:Return a unique id for every request. Using this id a getter can be implemented to query for
        //TODO:the results of the run.

    }

}
