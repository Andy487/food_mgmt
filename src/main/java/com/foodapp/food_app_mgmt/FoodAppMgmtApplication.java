package com.foodapp.food_app_mgmt;

import com.foodapp.food_app_mgmt.config.FoodappConfig;
import com.foodapp.food_app_mgmt.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.foodapp.food_app_mgmt.controller")
public class FoodAppMgmtApplication {

    private static final Logger log = LoggerFactory.getLogger(FoodAppMgmtApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(FoodAppMgmtApplication.class, args);
//        System.out.println("ello");

        System.setProperty("spring.profiles.active", "mysql");
        ApplicationContext context = SpringApplication.run(FoodappConfig.class,args);
        DataService dataService = context.getBean(DataService.class);


    }

}
