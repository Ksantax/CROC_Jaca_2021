package com.company;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * MediaFabric class for getting media devices
 * @author ChekhovAI
 */
public class MediaFabric {
    /** Field for storing already released devises */
    private final HashMap<String, TreeSet<Integer>> releasedDevisesDB = new HashMap<>();

    /**
     * Method to check model for existing - create if not -
     * and add new serial number for model
     * @param model - model to chek and add new serial
     * @return - new serial
     */
    private int addNewSerial(String model) {
        int serial = 1;
        if (!releasedDevisesDB.containsKey(model)) {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(serial);
            releasedDevisesDB.put(model, set);
        }
        TreeSet<Integer> serialsOfModel = releasedDevisesDB.get(model);
        serial = serialsOfModel.last() + 1;
        serialsOfModel.add(serial);
        return serial;
    }

    /**
     * Method to get new SDPlayer
     * @param model - which model to return
     * @return new SDPlayer of the model with new serial number
     */
    public MediaDevice getSDPlayer(String model) {
        return new SDPlayer(model, addNewSerial(model));
    }

    /**
     * Method to get new FlashPlayer
     * @param model - which model to return
     * @return new FlashPlayer of the model with new serial number
     */
    public MediaDevice getFlashPlayer(String model) {
        return new FlashPlayer(model, addNewSerial(model));
    }

    /**
     * Method to get new DiskPlayer
     * @param model - which model to return
     * @return new DiskPlayer of the model with new serial number
     */
    public MediaDevice getDiskPlayer(String model) {
        return new DiskPlayer(model, addNewSerial(model));
    }

    /**
     * Method to get new VinylPlayer
     * @param model - which model to return
     * @return new VinylPlayer of the model with new serial number
     */
    public MediaDevice getVinylPlayer(String model) {
        return new VinylPlayer(model, addNewSerial(model));
    }

    /**
     * Method to get new MediaStation
     * @param model - which model to return
     * @return new MediaStation of the model with new serial number
     */
    public MediaDevice getMediaStation(String model) {
        return new MediaStation(model, addNewSerial(model));
    }
}
