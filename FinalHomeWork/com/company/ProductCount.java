package com.company;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для первого задания.
 * Используятся для маршаллинга JAXB
 */
@XmlRootElement
public class ProductCount {
    private String name;
    private int count;

    protected ProductCount() {
    }

    public ProductCount(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
