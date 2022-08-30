package com.foodapp.food_app_mgmt.config;


import com.foodapp.food_app_mgmt.repository.CartItemRepository;
import com.foodapp.food_app_mgmt.repository.ItemRepository;
import com.foodapp.food_app_mgmt.repository.UserRepository;
import com.foodapp.food_app_mgmt.service.DataService;
import com.foodapp.food_app_mgmt.service.DatabaseDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


@EnableJpaRepositories(basePackages = "com.foodapp.food_app_mgmt.repository")
@EntityScan(basePackages = "com.foodapp.food_app_mgmt.model")
@Import({MySqlCofig.class})
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.foodapp.food_app_mgmt")
@Configuration
public class FoodappConfig {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    DataSource dataSource;


    @Bean
    public DataService dataService(){
        DataService service =new DatabaseDataServiceImpl(userRepository,itemRepository,cartItemRepository);
        return service;
    }



}
