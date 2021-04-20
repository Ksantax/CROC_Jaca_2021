package com.company;

import javax.xml.bind.annotation.*;


@XmlRootElement
public class Product {
    private int id;
    private String name;

    protected Product() {}

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }
}
