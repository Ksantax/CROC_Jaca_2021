package com.company;

import java.util.Objects;

/**
 * Class for song
 * @author ChekhovAI
 */
public class Song implements Comparable {
    /** Field for artist's pseudonym */
    private final String artist;
    /** Field for song title */
    private final String title;

    /**
     * Standard constructor
     * @param artist - for field artist
     * @param title - for field title
     */
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    /**
     * Method to get artist of song
     * @return artist value
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Method to get song title
     * @return title value
     */
    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(artist, song.artist) && Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, title);
    }


    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        Song other = (Song) o;
        return (artist + title).compareTo(other.artist + other.title);
    }
}
