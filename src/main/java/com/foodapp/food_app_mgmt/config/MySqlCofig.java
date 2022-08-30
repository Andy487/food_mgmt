package com.foodapp.food_app_mgmt.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Profile("mysql")
@Configuration
public class MySqlCofig {

    private static final Logger log = LoggerFactory.getLogger(MySqlCofig.class);

    @Bean
    public DataSource mySqlDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/food_mgmt");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager txtManager = new JpaTransactionManager();
        txtManager.setEntityManagerFactory(txtManager.getEntityManagerFactory());
        return txtManager;
    }
}
