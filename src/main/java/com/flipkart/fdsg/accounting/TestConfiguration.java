package com.flipkart.fdsg.accounting;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
public class TestConfiguration extends Configuration {
    @JsonProperty("message")
    private String webMessage;
    private Integer count;

    @Valid
    @NotNull
    private DataSourceFactory database;sss

}