package com.flipkart.fdsg.accounting.dao;

import com.flipkart.fdsg.accounting.model.Employee;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by saroma.devi on 25/10/18.
 */
public class EmployeeDao extends AbstractDAO<Employee>{

    public EmployeeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Employee get(Integer id) {
        return super.get(id);
    }
}
