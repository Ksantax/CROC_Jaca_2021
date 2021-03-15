package com.croc;

/**
 * Exception for turning to taken position
 * Throw when turn coordinates are taken
 * @author ChekhovAI
 */
public class TakenPositionException extends Exception {
    /**
     * Standard exception constructor with message
     * @param message will be set as exception message
     */
    TakenPositionException(String message) {super(message);}
}
