package com.company;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для второго задания.
 * Используятся для маршаллинга JAXB
 */
@XmlRootElement
public class MeanSold {
    double mean;
    String data;

    protected MeanSold() {
    }

    public MeanSold(String data, double mean) {
        this.mean = mean;
        this.data = data;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
