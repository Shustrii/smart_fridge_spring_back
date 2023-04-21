package com.szub.smartfridgefullstack.model;

import antlr.collections.List;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String recipe;

    public Recipe() {
    }

    public Recipe(int id, String recipe) {
        this.id = id;
        this.recipe = recipe;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "product_to_recipe",
            joinColumns = {@JoinColumn(name = "recipes_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private Set<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
