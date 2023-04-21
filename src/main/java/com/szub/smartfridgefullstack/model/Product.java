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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "measure")
    private int measure;

    @Column(name = "pr_type_id")
    private int pr_type_id;

    //@ManyToMany
    //private Recipe recipe;
    @Transient
    private String prtName;
    @Transient
    private String measureName;
    @Transient
    private int measure_id;
    @Transient
    private int measure_measure_id;

    public Product() {
    }
    public Product(int measure_id, int measure_measure_id, String measureName){
        this.measure_id = measure_id;
        this.measure_measure_id = measure_measure_id;
        this.measureName = measureName;
    }

    public Product(String name, int pr_type_id) {
        this.name = name;
        this.pr_type_id = pr_type_id;
    }

    public Product(int id, String name, int measure) {
        this.id = id;
        this.name = name;
        this.measure = measure;

    }

    public Product(String name, int measure, Set<Fridge> fridges) {
        this.name = name;
        this.measure = measure;
        this.fridges = fridges;
    }

    public Product(int id, String name, int measure, Set<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.recipes = recipes;
    }

    public Product(int id, String name, int measure, int pr_type_id, String prtName, String measureName) {
        this.id = id;
        this.name = name;
        this.measure = measure;

        this.pr_type_id = pr_type_id;
        this.prtName = prtName;
        this.measureName = measureName;
    }



    public Product(int id, String name, int pr_type_id, String measureName, String prtName) {
        this.id = id;
        this.name = name;
        this.pr_type_id = pr_type_id;
        this.measureName = measureName;
        this.prtName = prtName;
    }



    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Fridge> fridges;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;


    @OneToOne
    @PrimaryKeyJoinColumn
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

    public int getPr_type_id() {
        return pr_type_id;
    }

    public void setPr_type_id(int pr_type_id) {
        this.pr_type_id = pr_type_id;
    }

    public String getPrtName() {
        return prtName;
    }

    public void setPrtName(String prtName) {
        this.prtName = prtName;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }

    public int getMeasure_measure_id() {
        return measure_measure_id;
    }

    public void setMeasure_measure_id(int measure_measure_id) {
        this.measure_measure_id = measure_measure_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                ", pr_type_id=" + pr_type_id +
                ", prtName=" + prtName +
                ", measureName=" + measureName +
                '}';
    }
}
