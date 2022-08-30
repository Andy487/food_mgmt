package com.foodapp.food_app_mgmt.model;


import javax.persistence.*;

@Entity(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long cart_id;
    @ManyToOne
    private Items item_id;
    private double quantity;
@OneToOne
private User user_id;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                ", user_id=" + user_id +
                '}';
    }

    public CartItem(){}

    public CartItem(Items items,double quantity ,User user_id){
        this.item_id = items;
        this.user_id = user_id;
        this.quantity = quantity;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Items getItem_id() {
        return item_id;
    }

    public void setItem_id(Items item_id) {
        this.item_id = item_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
