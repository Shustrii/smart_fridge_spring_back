package com.szub.smartfridgefullstack.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "measure")
    private String measure;

    @Column(name = "cost")
    private int cost;


    public Products() {
    }

    public Products(String name, String measure, int cost) {
        this.name = name;
        this.measure = measure;
        this.cost = cost;

    }

    public Products(int id, String name, String measure, int cost) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.cost = cost;
    }

    public Products(String name, String measure, int cost, Set<Fridge> fridges) {
        this.name = name;
        this.measure = measure;
        this.cost = cost;
        this.fridges = fridges;
    }

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Fridge> fridges;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
