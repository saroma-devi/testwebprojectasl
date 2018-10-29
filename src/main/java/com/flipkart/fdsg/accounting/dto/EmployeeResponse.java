package com.flipkart.fdsg.accounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by saroma.devi on 25/10/18.
 */
public class EmployeeResponse {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String name;


    public EmployeeResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
