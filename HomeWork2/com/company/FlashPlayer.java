package com.company;

/**
 * FlashPlayer class - MediaDevice
 * @author ChekhovAI
 */
public class FlashPlayer extends MediaDevice {
    /** Constructor
     * @see MediaDevice#MediaDevice(String, int)
     * @param model - model of flash player
     * @param serialNumber - serial number of flash player
     */
    FlashPlayer(String model, int serialNumber) {
        super(model, serialNumber);
    }

    /**
     * @see MediaDevice#insertCarrier(Carrier)
     * @throws InsertionException when carrier is not SDCard
     */
    @Override
    public void insertCarrier(Carrier carrier) throws InsertionException {
        if (carrier instanceof FlashCard) {
            super.insertCarrier(carrier);
        }
        else throw new InsertionException("Supports only Flash cards");
    }
}
