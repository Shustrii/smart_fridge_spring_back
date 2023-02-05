package com.szub.smartfridgefullstack.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RecipeProductId implements Serializable {

    @Id
    private int recipes_id;
    @Id
    private int product_id;

    public RecipeProductId() {
    }

    public RecipeProductId(int recipes_id, int product_id) {
        this.recipes_id = recipes_id;
        this.product_id = product_id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeProductId that = (RecipeProductId) o;
        return recipes_id == that.recipes_id && product_id == that.product_id;
    }

    @Override
    public String toString() {
        return "RecipeProductId{" +
                "recipes_id=" + recipes_id +
                ", product_id=" + product_id +
                '}';
    }
}
