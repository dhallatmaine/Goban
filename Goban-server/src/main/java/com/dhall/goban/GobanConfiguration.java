package com.dhall.goban;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.*;

public class GobanConfiguration extends Configuration {
    @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }
}
