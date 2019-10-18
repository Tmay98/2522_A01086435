package ca.bcit.comp2522.labs.lab06;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents an InputReader.
 *
 * @author Tommy May
 * @version 2019
 */
public class InputReader {

    private Scanner scanner;

    /**
     * Constructs an object of type InputReader.
     */
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    /**
     * Gets user input and returns it if it is an int else throws a NotAnIntegerException.
     *
     * @return userInput
     * @throws NotAnIntegerException an Exception
     */
    public int getNumber() throws NotAnIntegerException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new NotAnIntegerException("That's not an integer!");
        }
    }
}
