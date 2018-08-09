package com.dhall.goban;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GobanApplication extends Application<GobanConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GobanApplication().run(args);
    }

    @Override
    public String getName() {
        return "Goban";
    }

    @Override
    public void initialize(final Bootstrap<GobanConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
            .enableAutoConfig(getClass().getPackage().getName())
            .build());
    }

    @Override
    public void run(final GobanConfiguration configuration,
                    final Environment environment) {
        DateFormat exampleDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(exampleDateFormat);
    }

}
