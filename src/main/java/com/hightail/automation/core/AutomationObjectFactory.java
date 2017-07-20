package com.hightail.automation.core;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.testng.internal.ObjectFactoryImpl;

import java.lang.reflect.Constructor;

/**
 * Created by shiva.paranandi on 4/6/17.
 */
public class AutomationObjectFactory extends ObjectFactoryImpl {

    // This is one of the simplest ways to inject the test classes with runtime configuration in TestNG.
    // TestNG.classImpl has a Guice.createInjector that is impossible to over ride.
    @Inject
    private Injector injector;

    @Override
    public Object newInstance(Constructor constructor, Object... params) {
        Object testClass = super.newInstance(constructor, params);
        injector.injectMembers(testClass);
        return testClass;
    }
}
