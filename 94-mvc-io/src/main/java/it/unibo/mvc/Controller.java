package it.unibo.mvc;

import java.util.List;

/**
 *  The Controller model a simple controller responsible of I/O access.
 */
public interface Controller {
    /**
     * Method for setting the next string to print. Null values are note acceptable,
     * and an exeption should be produced.
     * @param str
     * @throws NullPointerException
     * 
     */
    void setString(String str) throws NullPointerException;

    /**
     * Method for getting the next string to print.
     * @return the next string to print.
     */
    String getString();

    /**
     * Method for getting the history of the printed strings.
     * @return the history of the printed strings.
     */
    List<String> getPrintedHistory();

    /**
     * Method that prints the current strings. 
     * @throws IllegalStateException
     */
    void printCurrentString() throws IllegalStateException;
}
