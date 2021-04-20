package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sale {
    private int id, sellerId, productId, productCount;
    private String saleDate;

    public Sale() {}

    public Sale(int id, int sellerId, int productId, int productCount, String saleDate) {
        this.id = id;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productCount = productCount;
        this.saleDate = saleDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }
}
