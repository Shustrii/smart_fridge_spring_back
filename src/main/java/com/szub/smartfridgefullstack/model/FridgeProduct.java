package com.szub.smartfridgefullstack.model;


import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

@Entity
@Table(name = "fridge_products")
@SQLInsert(sql = "INSERT INTO fridge_products(fridge_id, product_id, quantity) VALUES (?,?,?)", check= ResultCheckStyle.COUNT)
public class FridgeProduct {

    private int fridge_id;
    private int product_id;
    private int quantity;

    private String product_name;


    public FridgeProduct() {
    }

    public FridgeProduct(int fridge_id, int product_id, int quantity) {
        this.fridge_id = fridge_id;
        this.product_id = product_id;
        this.quantity = quantity;
        System.out.println("+++constructor new");
    }

    public FridgeProduct(int fridge_id, int product_id, String product_name,int quantity) {
        this.fridge_id = fridge_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;

        System.out.println("+++constructor");
    }



    public FridgeProduct(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        System.out.println("+++constructor++++++");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fridge_id")
    public int getFridge_id() {
        return fridge_id;
    }

    public void setFridge_id(int fridge_id) {
        this.fridge_id = fridge_id;
    }

    @Column(name = "product_id")
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //@Column(name = "product_name", insertable = false)
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "FridgeProduct{" +
                "fridge_id=" + fridge_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
