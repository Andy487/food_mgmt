package com.foodapp.food_app_mgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Float price;
    public Items(){}

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public Items(String name, String image, Float price){
        this.name =  name;
        this.image = image;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long item_id) {
        this.id = item_id;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}



