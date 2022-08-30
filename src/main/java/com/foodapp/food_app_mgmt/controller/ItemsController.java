package com.foodapp.food_app_mgmt.controller;

import com.foodapp.food_app_mgmt.model.Items;
import com.foodapp.food_app_mgmt.repository.ItemRepository;
import com.foodapp.food_app_mgmt.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private final DataService dataService;

    @Autowired
    private ItemRepository itemRepository;

    public ItemsController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/getItems")
    public String getItems(@RequestBody Items items){
        dataService.getItems(items);
return "get all items";
    }


    @GetMapping("/item/name")
    public ResponseEntity<List<Items>> getItemByName(@RequestParam String name) {
        return new ResponseEntity<List<Items>>((List<Items>) itemRepository.findByName(name), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "/registerUser", headers = "Accept=application/json", method = RequestMethod.POST)
    @PostMapping(value = "/saveItem")
    public Items saveItem(@RequestBody Items items) {
        System.out.println("save item");
        System.out.println("Saving items " + items);
        dataService.saveItem(items);
        return items;
    }
}
