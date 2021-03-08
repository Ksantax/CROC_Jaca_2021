package com.company;

/**
 * Exception class for some errors during
 * insertion carrier in media device
 */
public class InsertionException extends Exception{
    /**
     * Standard Exception constructor
     * @param massage - set massage for Exception
     */
    InsertionException(String massage) {
        super(massage);
    }
}
