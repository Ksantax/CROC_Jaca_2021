package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="sales")
@XmlAccessorType(XmlAccessType.NONE)
public class SalesRoot extends Root {
    @XmlElement(name="sale")
    private List<Sale> sales;

    public SalesRoot() {}

    public SalesRoot(List<Sale> sales) { this.sales = sales; }

    public List<Sale> getSales() { return sales; }

    public void setSales(List<Sale> sales) { this.sales = sales; }
}
