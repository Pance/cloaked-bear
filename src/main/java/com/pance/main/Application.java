package com.pance.main;

import com.pance.controller.DataController;
import com.pance.controller.Home;
import com.pance.dao.CategoryDAOImpl;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("com.pance")
public class Application {
    @Autowired
    JdbcDataSource dataSource;
    public static void main(String[] args) {
        Object[] classes = new Object[]{ Home.class, DataController.class, CategoryDAOImpl.class};

        //JdbcDataSource dataSource = new JdbcDataSource();
        //dataSource.setURL("jdbc:h2:mem:");
        ApplicationContext ctx = SpringApplication.run(classes, args);
    }
}