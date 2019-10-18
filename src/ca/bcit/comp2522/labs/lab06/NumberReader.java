package ca.bcit.comp2522.labs.lab06;

public class NumberReader {

    private InputReader inputReader;

    public NumberReader() {
        inputReader = new InputReader();
    }

    public void guessNumber() {
        int userInput = 1;
        int total = 0;
        do {
            System.out.println("Enter an integer, 0 to stop: ");
            try {
                userInput = inputReader.getNumber();
                total += userInput;
            } catch (NotAnIntegerException e) {
                System.out.println(e.toString());
            }
        } while(userInput != 0);
        System.out.println("The sum of numbers entered is " + total);
    }

    public static void main(String[] args) {
        NumberReader test = new NumberReader();
        test.guessNumber();
    }
}
