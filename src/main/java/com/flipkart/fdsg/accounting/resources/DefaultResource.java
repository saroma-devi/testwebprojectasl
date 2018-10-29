package com.flipkart.fdsg.accounting.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by saroma.devi on 25/10/18.
 */
@Path("/")
public class DefaultResource {

    @Path("/")
    @GET
    public String defaultMethod() {
        return "HELLO WORLD";
    }
}
