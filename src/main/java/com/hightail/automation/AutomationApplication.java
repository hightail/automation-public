package com.hightail.automation;

import com.google.inject.Injector;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AutomationApplication extends Application<AutomationConfiguration> {

    private Injector injector;

    public static void main(final String[] args) throws Exception {
        new AutomationApplication().run(args);
    }

    @Override
    public String getName() {
        return "automation";
    }

    /**
     * Uses GuiceBundle to automatically scan the package and create the dependency graph.
     * Using the GuiceBundle with autoConfig = true makes adding new resources super simple.
     * @param bootstrap
     */
    @Override
    public void initialize(final Bootstrap<AutomationConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        GuiceBundle<AutomationConfiguration> guiceBundle = GuiceBundle.<AutomationConfiguration>newBuilder()
                .addModule(new AutomationModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(AutomationConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final AutomationConfiguration configuration, final Environment environment) {
    }

}
