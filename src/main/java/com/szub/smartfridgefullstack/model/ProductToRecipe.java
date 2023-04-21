package com.szub.smartfridgefullstack.model;

import javax.persistence.*;

@Entity
@Table(name = "product_to_recipe")
public class ProductToRecipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "recipes_id")
    private int recipes_id;

    @Column(name = "product_id")
    private int product_id;
    @Column(name = "measure_id")
    private int measure_id;
    @Column(name = "quantity")
    private int quantity;

    @Transient
    private int product_id_id;
    @Transient
    private String recipe_name;
    @Transient
    private String product_name;
    @Transient
    private String measure_name;
    @Transient
    private int measure_id_id;
    @Transient
    private int measure_measure_id;
    @Transient
    private int value;
    @Transient
    private int f_quantity;

    public ProductToRecipe() {
    }

    public ProductToRecipe(int id, int recipes_id, int product_id,  String product_name, int quantity) {
        this.id = id;
        this.recipes_id = recipes_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;

    }

    public ProductToRecipe(int id, int product_id, int recipes_id, int measure_id, int quantity, String product_name, String measure_name) {
        this.id = id;
        this.product_id = product_id;
        this.recipes_id = recipes_id;
        this.measure_id = measure_id;
        this.quantity = quantity;
        this.product_name = product_name;
        this.measure_name = measure_name;
    }


    public ProductToRecipe(int product_id, String product_name, int measure_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.measure_id = measure_id;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipes_id() {
        return recipes_id;
    }

    public void setRecipes_id(int recipes_id) {
        this.recipes_id = recipes_id;
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


    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
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

    public void setMeasure_id_id(int m_id) {
        this.measure_id_id = m_id;
    }

    public int getMeasure_measure_id() {
        return measure_measure_id;
    }

    public void setMeasure_measure_id(int measure_measure_id) {
        this.measure_measure_id = measure_measure_id;
    }

    public int getProduct_id_id() {
        return product_id_id;
    }

    public void setProduct_id_id(int product_id_id) {
        this.product_id_id = product_id_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getF_quantity() {
        return f_quantity;
    }

    public void setF_quantity(int f_quantity) {
        this.f_quantity = f_quantity;
    }

    @Override
    public String toString() {
        return "ProductToRecipe{" +
                "id=" + id +
                ", recipes_id=" + recipes_id +
                ", product_id=" + product_id +
                ", measure_id=" + measure_id +
                ", quantity=" + quantity +
                ", product_id_id=" + product_id_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", product_name='" + product_name + '\'' +
                ", measure_name='" + measure_name + '\'' +
                ", measure_id_id=" + measure_id_id +
                ", measure_measure_id=" + measure_measure_id +
                ", value=" + value +
                ", f_quantity=" + f_quantity +
                '}';
    }
}
