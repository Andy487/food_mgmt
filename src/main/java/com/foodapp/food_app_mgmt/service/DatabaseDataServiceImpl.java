package com.foodapp.food_app_mgmt.service;

import com.foodapp.food_app_mgmt.model.CartItem;
import com.foodapp.food_app_mgmt.model.Items;
import com.foodapp.food_app_mgmt.model.User;
import com.foodapp.food_app_mgmt.repository.CartItemRepository;
import com.foodapp.food_app_mgmt.repository.ItemRepository;
import com.foodapp.food_app_mgmt.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class DatabaseDataServiceImpl implements DataService{
    private UserRepository userRepository ;


    private ItemRepository itemRepository;



    private CartItemRepository cartItemRepository;
    public DatabaseDataServiceImpl(UserRepository userRepository, ItemRepository itemRepository, CartItemRepository cartItemRepository){

     this.userRepository = userRepository;

     this.itemRepository = itemRepository;
     this.cartItemRepository = cartItemRepository;
    }



    @Override
    public void registerUser(User user) {
        System.out.println("dbmsIMP");
        userRepository.save(user);
    }
    @Override
    public void saveItem(Items items) {
        System.out.println("dbmsIMP");
        itemRepository.save(items);
    }
    @Override
    public void addToCart(Items item_id, User user_id, Long qty_id) {
        System.out.println("dataimp  item id : "+item_id+", user deetails :  "+user_id+" , qty_id :"+qty_id);
//        Long items = cartItemRepository.findByItem_id(item_id).getId();
//        System.out.println("items :"+items);
//      Items items = cartItemRepository.findById(item_id).get().getItem_id();
//        System.out.println("items"+items);
//      CartItem cartItem = cartItemRepository.findByUser_idAndItem_id(user_id,item_id);`
        CartItem cartItem = new CartItem();
        cartItem.setItem(item_id);
        cartItem.setQuantity(qty_id);
        cartItem.setUser(user_id);
        System.out.println("Cart  :"+cartItem);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void getItems(Items items){
        userRepository.findAll();
    }
@Override
    public List<User> getUser(){
        System.out.println("dataimp");
         return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        System.out.println("get user ");
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            System.out.println("user present");
            return user.get();
        }
        else {
            System.out.println("user null");
            return null;
        }
    }
    

    


}
