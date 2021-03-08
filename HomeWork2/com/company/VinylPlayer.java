package com.company;

/**
 * VinylPlayer class - MediaDevice
 * @author ChekhovAI
 */
public class VinylPlayer extends MediaDevice {
    /** Constructor
     * @see MediaDevice#MediaDevice(String, int)
     * @param model - model of vinyl player
     * @param serialNumber - serial number of vinyl player
     */
    VinylPlayer(String model, int serialNumber) {
        super(model, serialNumber);
    }

    /**
     * @see MediaDevice#insertCarrier(Carrier)
     * @throws InsertionException when carrier is not SDCard
     */
    @Override
    public void insertCarrier(Carrier carrier) throws InsertionException {
        if (carrier instanceof VinylDisk) {
            super.insertCarrier(carrier);
        }
        else throw new InsertionException("Supports only vinyl disks");
    }
}
