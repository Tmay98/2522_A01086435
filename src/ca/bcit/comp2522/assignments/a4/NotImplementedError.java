package ca.bcit.comp2522.assignments.a4;

/**
 * NotImplementedError
 *
 * @author Frances Mach
 * @author Tommy May
 * @version 2019
 */
public class NotImplementedError extends Exception {
    private String key;

    public NotImplementedError(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String toString() {
        return "Invalid entry: " + key;
    }
}
