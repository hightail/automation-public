package com.hightail.automation.test.base;

import com.google.inject.Inject;
import com.hightail.automation.AutomationConfiguration;

/**
 * Created by shiva.paranandi on 3/27/17.
 * Base class to inject the configuration object into all the tests.
 */
public class BaseTest {

    @Inject
    protected AutomationConfiguration configuration;

}
