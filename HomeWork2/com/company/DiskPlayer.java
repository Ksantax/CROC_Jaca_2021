package com.company;

/**
 * DiskPlayer class - MediaDevice
 * @author ChekhovAI
 */
public class DiskPlayer extends MediaDevice {
    /** Constructor
     * @see MediaDevice#MediaDevice(String, int)
     * @param model - model of disk player
     * @param serialNumber - serial number of disk player
     */
    DiskPlayer(String model, int serialNumber) {
        super(model, serialNumber);
    }

    /**
     * @see MediaDevice#insertCarrier(Carrier)
     * @throws InsertionException when carrier is not SDCard
     */
    @Override
    public void insertCarrier(Carrier carrier) throws InsertionException {
        if (carrier instanceof Disk) {
            super.insertCarrier(carrier);
        }
        else throw new InsertionException("Supports only Disks");
    }
}
