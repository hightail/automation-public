package com.hightail.automation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutomationConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String baseURL;

    @JsonProperty
    private String suitePath;

    @JsonProperty
    private String suiteName;

    public String getSuitePath() {
        return suitePath;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getBaseURL() {
        return baseURL;
    }
}
