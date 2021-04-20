package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Availability {
    private int sellerId, productId, productCount;
    private double price;

    protected Availability() {}

    public Availability(int sellerId, int productId, int productCount, double price) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.productCount = productCount;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
