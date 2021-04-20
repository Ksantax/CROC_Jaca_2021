package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.NONE)
public class ProductsRoot extends Root {
    @XmlElement(name="product")
    private List<Product> products;

    public ProductsRoot() {}

    public ProductsRoot(List<Product> products) { this.products = products; }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }
}
