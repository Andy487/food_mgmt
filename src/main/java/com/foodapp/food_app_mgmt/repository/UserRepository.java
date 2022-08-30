package com.foodapp.food_app_mgmt.repository;

import com.foodapp.food_app_mgmt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {

    List<User> findByIdIs(Long id);

    Lazy<Object> findById(User id);


//    User findByUserId(Long Id);
}
