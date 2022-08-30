package com.foodapp.food_app_mgmt.model;


import javax.persistence.*;

@Entity(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Items item;
    private double quantity;
    @OneToOne
    private User user;



    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", item_id=" + item +
                ", quantity=" + quantity +
                ", user_id=" + user +
                '}';
    }

    public CartItem(){}

    public CartItem(Items items,double quantity ,User user_id){
        this.item = items;
        this.user = user_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Items getItem() {
        return item;
    }
    public void setItem(Items item_id) {
        this.item = item_id;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user_id) {
        this.user = user_id;
    }
}
