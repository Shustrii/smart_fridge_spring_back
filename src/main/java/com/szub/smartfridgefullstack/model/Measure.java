package com.szub.smartfridgefullstack.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "measure")
public class Measure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "measure_id")
    private int measure_id;

    @Column(name = "value")
    private int value;

    @OneToOne(mappedBy = "measure")
    private ProductType productType;

    public Measure() {
    }

    public Measure(int id, String name, int measure_id, int value) {
        this.id = id;
        this.name = name;
        this.measure_id = measure_id;
        this.value = value;
    }

    public Measure(int id, String name, int measure_id) {
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

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure_id=" + measure_id +
                ", value='" + value + '\'' +
                '}';
    }
}
