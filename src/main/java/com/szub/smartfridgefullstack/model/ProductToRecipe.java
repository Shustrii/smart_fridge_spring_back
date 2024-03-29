package com.szub.smartfridgefullstack.model;


import javax.persistence.*;

@Entity
@Table(name = "product_to_recipe")
@IdClass(RecipeProductId.class)
public class ProductToRecipe {

    @Id
    @Column(name = "recipes_id")
    private int recipes_id;
    @Id
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
    private int value2;
    @Transient
    private int f_quantity;

    public ProductToRecipe() {
    }

    public ProductToRecipe(int recipes_id, int product_id,  String product_name, int quantity) {
        this.recipes_id = recipes_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;

    }
///
    public ProductToRecipe( int product_id, int recipes_id, int measure_id, int quantity, String product_name, String measure_name) {
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

//    public ProductToRecipe(int product_id , String product_name , int quantity , String measure_name ,int recipes_id) {
//        this.recipes_id = recipes_id;
//        this.quantity = quantity;
//        this.product_id = product_id;
//        this.product_name = product_name;
//        this.measure_name = measure_name;
//    }

//    public ProductToRecipe(int product_id_id , String product_name , int quantity, String measure_name ,int recipes_id) {
//        this.recipes_id = recipes_id;
//        this.quantity = quantity;
//        this.product_id_id = product_id_id;
//        this.product_name = product_name;
//        this.measure_name = measure_name;
//    }

    //    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Measure measures;




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

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
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
                "recipes_id=" + recipes_id +
                ", product_id=" + product_id +
                ", measure_id=" + measure_id +
                ", quantity=" + quantity +
                ", product_name='" + product_name + '\'' +
                ", measure_name='" + measure_name + '\'' +
                '}';
    }
}
