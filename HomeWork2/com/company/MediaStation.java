package com.company;

/**
 * MediaStation class - universal MediaDevice
 * @author ChekhovAI
 */
public class MediaStation extends MediaDevice {
    /** Constructor
     * @see MediaDevice#MediaDevice(String, int)
     * @param model - model of media station
     * @param serialNumber - serial number of media station
     */
    MediaStation(String model, int serialNumber) {
        super(model, serialNumber);
    }

    /** @see MediaDevice#insertCarrier(Carrier) */
    @Override
    public void insertCarrier(Carrier carrier) {
        try {
            super.insertCarrier(carrier);
        } catch (InsertionException ex) {
            System.out.println("But how?");
        }
    }
}
