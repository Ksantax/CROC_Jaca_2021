package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="availabilities")
@XmlAccessorType(XmlAccessType.NONE)
public class AvailabilitiesRoot extends Root {
    @XmlElement(name="availability")
    private List<Availability> availabilities;

    public AvailabilitiesRoot() {}

    public AvailabilitiesRoot(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }
}
