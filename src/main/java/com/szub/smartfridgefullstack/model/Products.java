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
    private int measure;

    @Column(name = "cost")
    private int cost;

    @Column(name = "pr_type_id")
    private int pr_type_id;

    public Products() {
    }

    public Products(String name, int measure, int cost) {
        this.name = name;
        this.measure = measure;
        this.cost = cost;

    }

    public Products(int id, String name, int measure, int cost) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.cost = cost;
    }

    public Products(String name, int measure, int cost, Set<Fridge> fridges) {
        this.name = name;
        this.measure = measure;
        this.cost = cost;
        this.fridges = fridges;
    }

    public Products(int id, String name, int measure, int cost, Set<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.cost = cost;
        this.recipes = recipes;
    }

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Fridge> fridges;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "measure_id", referencedColumnName = "id")
//    private Measure measure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pr_type_id", referencedColumnName = "id")
    private ProductType productType;


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

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPr_type_id() {
        return pr_type_id;
    }

    public void setPr_type_id(int pr_type_id) {
        this.pr_type_id = pr_type_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                ", cost=" + cost +
                ", fridges=" + fridges +
                '}';
    }
}
