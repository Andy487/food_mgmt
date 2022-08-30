package com.foodapp.food_app_mgmt.repository;

import com.foodapp.food_app_mgmt.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Items, Long>, JpaRepository<Items,Long> {
//    List<Items> findByItem_id(Long item_id);
long count();

   List<Items> findByName(String name);

}
