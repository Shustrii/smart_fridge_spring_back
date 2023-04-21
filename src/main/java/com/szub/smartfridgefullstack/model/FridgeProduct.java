package com.szub.smartfridgefullstack.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fridge_products")
public class FridgeProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fridge_id")
    private int fridge_id;

    @Column(name = "product_id")
    private int product_id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "measure_id")
    private int measure_id;

    @Transient
    private String product_name;
    @Transient
    private String measure_name;
    @Transient
    private int measure_id_id;

    public FridgeProduct() {
    }

    public FridgeProduct(int id,int fridge_id, int product_id, String product_name,int quantity, int measure_id, int measure_id_id, String measure_name) {
        this.id = id;
        this.fridge_id = fridge_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.measure_id = measure_id;
        this.measure_id_id = measure_id_id;
        this.measure_name = measure_name;
    }

    public FridgeProduct(int fridge_id, int product_id, String product_name,int quantity, int measure_id) {
        this.fridge_id = fridge_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.measure_id = measure_id;
    }

    public FridgeProduct(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFridge_id() {
        return fridge_id;
    }

    public void setFridge_id(int fridge_id) {
        this.fridge_id = fridge_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getMeasure_name() {
        return measure_name;
    }

    public void setMeasure_name(String measure_name) {
        this.measure_name = measure_name;
    }


    public int getMeasure_id_id() {
        return measure_id_id;
    }

    public void setMeasure_id_id(int measure_id_id) {
        this.measure_id_id = measure_id_id;
    }

    @Override
    public String toString() {
        return "FridgeProduct{" +
                "id=" + id +
                ", fridge_id=" + fridge_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", measure_id=" + measure_id +
                ", product_name='" + product_name + '\'' +
                ", measure_name='" + measure_name + '\'' +
                ", measure_id_id=" + measure_id_id +
                '}';
    }
}
