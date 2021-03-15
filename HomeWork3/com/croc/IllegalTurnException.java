package com.croc;

/**
 * Exception class for not supported tuns of figures
 * Throw when figure can't do a turn
 * @author ChakhovAI
 */
public class IllegalTurnException extends Exception {
    /**
     * Standard exception constructor with message
     * @param message will be set as exception message
     */
    IllegalTurnException(String message) {super(message);}
}
