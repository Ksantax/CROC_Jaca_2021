package com.company;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Abstract class for all audio carriers
 * @author ChekhovAI
 */
abstract public class Carrier {
    /** Field to store song list */
    private final TreeSet<Song> songList;

    /**
     * Constructor
     * @param songs - songs to add to the song list
     */
    Carrier(Song... songs) { songList = new TreeSet<>(Arrays.asList(songs)); }
    
    /**
     * Method to get the song list
     * @return songList
     */
    protected TreeSet<Song> getSongsList() { return songList; }

    /**
     * Method to add songs to the song list
     * @param songs - songs to add to the song list
     */
    public void addSongs(Song... songs) {
        songList.addAll(Arrays.asList(songs));
    }

    /**
     * Method to remove songs from the song list
     * @param songs - songs to remove from the song list
     */
    public void removeSong(Song... songs) {
        songList.removeAll(Arrays.asList(songs));
    }
}
