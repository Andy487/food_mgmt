package com.foodapp.food_app_mgmt.service;

import com.foodapp.food_app_mgmt.model.CartItem;
import com.foodapp.food_app_mgmt.model.Items;
import com.foodapp.food_app_mgmt.model.User;
import com.foodapp.food_app_mgmt.repository.CartItemRepository;
import com.foodapp.food_app_mgmt.repository.ItemRepository;
import com.foodapp.food_app_mgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DatabaseDataServiceImpl implements DataService{
    private UserRepository userRepository ;

    private ItemRepository itemRepository;


    @Autowired
    private CartItemRepository cartItemRepository;
    public DatabaseDataServiceImpl(UserRepository userRepository, ItemRepository itemRepository, CartItemRepository cartItemRepository){

     this.userRepository = userRepository;

     this.itemRepository = itemRepository;
    }



    @Override
    public void registerUser(User user) {
        System.out.println("dbmsIMP");
        userRepository.save(user);
        System.out.println("register user");

    }

//    @Override
//    public void addToCart(Long item_id, Long user_id) {
//
//    }

    @Override
    public void saveItem(Items items) {
        System.out.println("dbmsIMP");
        itemRepository.save(items);
        System.out.println("save item");

    }

    @Override
    public void addToCart(Long item_id, Long id, Long qty_id) {
        System.out.println("dataimp  item id : "+item_id+" "+id+" "+qty_id);
//        Long items = cartItemRepository.findByItem_id(item_id).getId();
//        System.out.println("items :"+items);
//      Items items = cartItemRepository.findById(item_id).get().getItem_id();
//        System.out.println("items"+items);

//      CartItem cartItem = cartItemRepository.findByUser_idAndItem_id(user_id,item_id);`

        CartItem cartItem = new CartItem();
        System.out.println("items  :"+cartItem);
//        cartItem.setItem_id(itemRepository.findById(item_id));
//        cartItem.setQuantity(items.getPrice());
//        cartItem.setUser(userRepository.findById(id.getId()).get().getId());
//        cartItem.setUserName((User) userRepository.findById(id).get());
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
//        return petrepository.findAll();


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
