package com.dhall.goban;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.EnumSet;

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
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        DateFormat exampleDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(exampleDateFormat);
    }

}
