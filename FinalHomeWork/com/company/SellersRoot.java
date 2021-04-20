package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="sellers")
@XmlAccessorType(XmlAccessType.NONE)
public class SellersRoot extends Root  {
    @XmlElement(name="seller")
    private List<Seller> sellers;

    public SellersRoot() {}

    public SellersRoot(List<Seller> sellers) { this.sellers = sellers; }

    public List<Seller> getSellers() { return sellers; }

    public void setSellers(List<Seller> sellers) { this.sellers = sellers; }
}
