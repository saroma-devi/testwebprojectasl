package com.flipkart.fdsg.accounting.service;

import com.flipkart.fdsg.accounting.dao.EmployeeDao;
import com.flipkart.fdsg.accounting.model.Employee;

/**
 * Created by saroma.devi on 25/10/18.
 */
public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee getEmployee(Integer id) {
        Employee employee =  employeeDao.get(id);
        return employee;
    }
}
