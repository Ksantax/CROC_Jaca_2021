package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ProductCountRoot extends Root {
    @XmlElement(name = "productCount")
    private List<ProductCount> productCounts;

    public ProductCountRoot() {
    }

    public ProductCountRoot(List<ProductCount> productCounts) {
        this.productCounts = productCounts;
    }

    public List<ProductCount> getProductCounts() {
        return productCounts;
    }

    public void setProductCounts(List<ProductCount> productCounts) {
        this.productCounts = productCounts;
    }
}
