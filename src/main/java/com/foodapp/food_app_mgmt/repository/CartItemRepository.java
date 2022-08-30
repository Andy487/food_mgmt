package com.foodapp.food_app_mgmt.repository;


import com.foodapp.food_app_mgmt.model.CartItem;
import com.foodapp.food_app_mgmt.model.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem ,Long> {
//    CartItem findByItem_id(Long item_id);

//    CartItem findByUser_idAndItem_id(CartItem user_id, CartItem item_id);

//    List<CartItem> findByItem_id(CartItem  item_id);
//    CartItem findByItem_id(Long item_id);
}
