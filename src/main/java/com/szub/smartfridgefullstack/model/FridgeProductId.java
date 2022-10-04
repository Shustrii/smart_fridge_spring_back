package com.szub.smartfridgefullstack.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FridgeProductId implements Serializable {

    @Id
    private int fridge_id;
    @Id
    private int product_id;

    public FridgeProductId() {
    }

    public FridgeProductId(int fridge_id, int product_id) {
        this.fridge_id = fridge_id;
        this.product_id = product_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FridgeProductId that = (FridgeProductId) o;
        return fridge_id == that.fridge_id && product_id == that.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fridge_id, product_id);
    }
}
