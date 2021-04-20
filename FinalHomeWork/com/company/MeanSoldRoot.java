package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "means")
@XmlAccessorType(XmlAccessType.NONE)
public class MeanSoldRoot extends Root {
    @XmlElement(name = "meanSold")
    List<MeanSold> means;

    public MeanSoldRoot() {
    }

    public MeanSoldRoot(List<MeanSold> means) {
        this.means = means;
    }

    public List<MeanSold> getMeans() {
        return means;
    }

    public void setMeans(List<MeanSold> means) {
        this.means = means;
    }
}
