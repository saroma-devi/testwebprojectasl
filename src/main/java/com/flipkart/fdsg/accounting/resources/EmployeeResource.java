package com.flipkart.fdsg.accounting.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.fdsg.accounting.dto.EmployeeResponse;
import com.flipkart.fdsg.accounting.model.Employee;
import com.flipkart.fdsg.accounting.service.EmployeeService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by saroma.devi on 25/10/18.
 */
@Path("/employees")
@Produces("application/json")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Path("/{employee_id}")
    @UnitOfWork
    public EmployeeResponse getEmployeeDetails(@PathParam("employee_id") Integer employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return new EmployeeResponse(employee.getId(), employee.getName());
    }
}
