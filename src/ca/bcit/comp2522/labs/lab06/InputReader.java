package ca.bcit.comp2522.labs.lab06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    private Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public int getNumber() throws NotAnIntegerException {
        try {
            int userInput = scanner.nextInt();
            return userInput;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new NotAnIntegerException("That's not an integer!");
        }
    }
}
