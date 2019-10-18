package ca.bcit.comp2522.labs.lab06;

/**
 * Represents a NotAnIntegerException Exception object.
 *
 * @author Tommy May
 * @version 2019
 */
public class NotAnIntegerException extends java.lang.Exception {

    private String key;

    public NotAnIntegerException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String toString() {
        return "Invalid entry: " + key;
    }
}
