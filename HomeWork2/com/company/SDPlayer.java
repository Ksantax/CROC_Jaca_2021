package com.company;

/**
 * SDPlayer class - MediaDevice
 * @author ChekhovAI
 */
public class SDPlayer extends MediaDevice {
    /** Constructor
     * @see MediaDevice#MediaDevice(String, int)
     * @param model - model of sd player
     * @param serialNumber - serial number of sd player
     */
    SDPlayer(String model, int serialNumber) {
        super(model, serialNumber);
    }

    /**
     * @see MediaDevice#insertCarrier(Carrier)
     * @throws InsertionException when carrier is not SDCard
     */
    @Override
    public void insertCarrier(Carrier carrier) throws InsertionException {
        if (carrier instanceof SDCard) {
            super.insertCarrier(carrier);
        }
        else throw new InsertionException("Supports only SD cards");
    }
}
