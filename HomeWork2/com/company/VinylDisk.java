package com.company;

/**
 * VinylDisk class - Carrier
 * @author ChekhovAI
 */
public class VinylDisk extends Carrier {
    /**
     * Constructor
     * @see Carrier#Carrier(Song...)
     * @param songs - songs to add with creating
     */
    VinylDisk(Song... songs) { super(songs); }
}
