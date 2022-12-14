package com.foodapp.food_app_mgmt.service;

import com.foodapp.food_app_mgmt.model.Items;
import com.foodapp.food_app_mgmt.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DataService {
    void registerUser(User user);
    void addToCart(Items item_id, User user_id, Long qty_id);
    void getItems(Items items);

    List<User> getUser();

    User getUserById(Long id);

  void saveItem(Items items);

}
