package com.szub.smartfridgefullstack.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "product_type")
public class ProductType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "measure_id")
    private int measure_id;


    @OneToOne(mappedBy = "productType")
    private Products products;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "measure_id", referencedColumnName = "id")
    private Measure measure;

    public ProductType() {
    }

    public ProductType(int id, String name, int measure_id) {
        this.id = id;
        this.name = name;
        this.measure_id = measure_id;
    }


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

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }


    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure_id=" + measure_id +
                '}';
    }
}
