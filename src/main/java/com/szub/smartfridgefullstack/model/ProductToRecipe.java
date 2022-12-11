package com.szub.smartfridgefullstack.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_to_recipe")
@IdClass(RecipeProductId.class)
public class ProductToRecipe {

    private int recipes_id;
    private int product_id;
    private int measure_id;
    private int quantity;

    private String recipe_name;
    private String product_name;
    private String measure_name;

    public ProductToRecipe() {
    }

    public ProductToRecipe(int recipes_id, int product_id,  String product_name, String measure_name, int quantity) {
        this.recipes_id = recipes_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.measure_name = measure_name;
        this.quantity = quantity;

    }


    public ProductToRecipe(int product_id,String product_name, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;

    }


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Measure measures;



    @Id
    @Column(name = "recipes_id")
    public int getRecipes_id() {
        return recipes_id;
    }

    public void setRecipes_id(int recipes_id) {
        this.recipes_id = recipes_id;
    }

    @Id
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

    @Column(name = "measure_id")
    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }

    @Transient
    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }
    @Transient
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "ProductToRecipe{" +
                "recipes_id=" + recipes_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", recipe_name='" + recipe_name + '\'' +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
