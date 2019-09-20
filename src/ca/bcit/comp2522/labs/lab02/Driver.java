package ca.bcit.comp2522.labs.lab02;

/**
 * Driver.
 *
 * @author Tommy May
 * @version 2019
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println(simulateRaces(10000,100));
    }

    /**
     * Simulates numberOfRaces races of length lengthofrace between a tortoise and a hare and returns the results
     * as a string
     *
     * @param numberOfRaces an int
     * @param lengthOfRace an int
     * @return String with number of tortoise and hare wins
     */
    public static String simulateRaces(int numberOfRaces, int lengthOfRace) {
        Race race = new Race(lengthOfRace);
        int simulations = 0;
        int hareWins = 0;
        int tortoiseWins = 0;
        while(simulations < numberOfRaces) {
            simulations++;
            if (race.simulateRace().equals(race.getHare())) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }
        return "Tortoise Wins: " + tortoiseWins + "\nHare Wins: " + hareWins;
    }
}
