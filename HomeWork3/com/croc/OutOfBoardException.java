package com.croc;

/**
 * Exception for turning out chess board
 * Throw when turn coordinates are illegal
 * @author ChekhovAI
 */
public class OutOfBoardException extends Exception {
    /**
     * Standard exception constructor with message
     * @param message will be set as exception message
     */
    OutOfBoardException(String message) {super(message);}
}
