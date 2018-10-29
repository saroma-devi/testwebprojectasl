package com.flipkart.fdsg.accounting;

import com.flipkart.fdsg.accounting.dao.EmployeeDao;
import com.flipkart.fdsg.accounting.model.Employee;
import com.flipkart.fdsg.accounting.resources.DefaultResource;
import com.flipkart.fdsg.accounting.resources.EmployeeResource;
import com.flipkart.fdsg.accounting.service.EmployeeService;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

public class TestApplication extends Application<TestConfiguration> {

    public static void main(String[] args) throws Exception {
        new TestApplication().run(args);
    }

    private final HibernateBundle<TestConfiguration> hibernateBundle =
            new HibernateBundle<TestConfiguration>(ImmutableList.of(Employee.class), new SessionFactoryFactory()) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(TestConfiguration configuration) {
            return configuration.getDatabase();
        }

    };

    @Override
    public void initialize(Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    public void run(TestConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new DefaultResource());
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        EmployeeService employeeService = new EmployeeService(new EmployeeDao(sessionFactory));
        environment.jersey().register(new EmployeeResource(employeeService));
    }
}

/*
javac compilation by maven [Compilation]
java -cp target/clasess com.flipkart.fdsg.accounting.TestApplication.class [RUN]
Classification of webservice inproc[dropwizard] and outproc [Tomcat,storm]


Session 2
1. Resource+DTO
2. Service + Helpers
3. DAO
4. Model(entities)

One Instance of Resource and service and Dao is Fine.
These should be stateLess and entity members should be Final
If provider is written and called to instantiate the object every time then, GC will be run every time

Business components --> Service
Work --> Function

Resources should always be noun

Service to Dao Many to Many relationships
Resource to Service is also Many to Many


*/
