package com.szub.smartfridgefullstack.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fridge")

public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;



    public Fridge() {
    }

    public Fridge(int id, String name, int quantity) {
        System.out.println("+++ Construct 1");
        this.id = id;
        this.name = name;
    }

//    public Fridge(int id, int quantity, int idOfProduct, String name, Products products) {
//        System.out.println("+++ Construct 2");
//        this.id = id;
//        this.quantity = quantity;
//        this.idOfProduct = idOfProduct;
//        this.name = name;
//        this.products = products;
//    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Fridge_Products",
            joinColumns = { @JoinColumn(name = "fridge_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<Product> products;

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


}
