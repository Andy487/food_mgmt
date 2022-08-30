package com.foodapp.food_app_mgmt.controller;


import com.foodapp.food_app_mgmt.model.CartItem;
import com.foodapp.food_app_mgmt.model.Items;
import com.foodapp.food_app_mgmt.model.User;
import com.foodapp.food_app_mgmt.repository.CartItemRepository;
import com.foodapp.food_app_mgmt.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("cart_items")
public class CartController {

    @Autowired
    private final DataService dataService;
    @Autowired
    private CartItemRepository cartItemRepository;
    public CartController(DataService dataService) {
        this.dataService = dataService;
    }

//    @PostMapping("/addToCart/{item_id}/{qty_id}/{user_id}")
//    public String addToCart(@PathVariable Long item_id, @PathVariable Long qty_id,@PathVariable Long user_id){
//        System.out.println("add to cart");
////        User user = new User();
//        //to save to cartItem table.
//        dataService.addToCart(item_id,user_id,qty_id);
//        return "products";
//    }

    @PostMapping("/addToCart/{item_id}/{user_id}/{qty_id}")
    public String addToCart(@PathVariable Items item_id, @PathVariable Long qty_id,@PathVariable User user_id){
        System.out.println("add to cart");
        //to save to cartItem table.
        dataService.addToCart(item_id,user_id,qty_id);
        return "products";
    }
    @GetMapping("/cart/{id}/{user_id}")
    public ResponseEntity<List<CartItem>> getCartById(@PathVariable Long id,@PathVariable Long user_id) {
        System.out.println("get cart");
        return new ResponseEntity<List<CartItem>>((List<CartItem>) cartItemRepository.findAllById(Collections.singleton(id)), HttpStatus.OK);
    }


}
