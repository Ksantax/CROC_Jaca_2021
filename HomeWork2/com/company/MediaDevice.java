package com.company;

import java.util.TreeSet;

/**
 * Abstract class for all media devices
 * @author ChekhovAI
 */
abstract public class MediaDevice {
    /** Carrier that was inserted in this device */
    private Carrier insertedCarrier = null;
    /** Model of device */
    private final String model;
    /** Serial number of device with the model */
    private final int serialNumber;

    /**
     * Constrictor
     * @param model - to set model for device
     * @param serialNumber - to set serial number for device
     */
    MediaDevice(String model, int serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    /**
     * Method to set insertedCarrier <strong> with replace </strong>
     * @param carrier - carrier to insert
     * @throws InsertionException when media device dose not support carrier
     */
    public void insertCarrier(Carrier carrier) throws InsertionException {
        insertedCarrier = carrier;
    }

    /** Method to extract inserted carrier */
    public void extractCarrier() { insertedCarrier = null; }

    /**
     * Method to play songs from inserted carrier
     * @throws NullPointerException when carrier is not inserted
     */
    public void playFromCarrier() throws NullPointerException {
        if (insertedCarrier == null) throw new NullPointerException("Carrier wasn't inserted");
        TreeSet<Song> playList = insertedCarrier.getSongsList();
        System.out.printf("  ~~ Now playing: %s - %d ~~\n", model, serialNumber);
        for (Song song : playList) {
            System.out.printf("> %s - %s\n", song.getArtist(), song.getTitle());
        }
    }
}
