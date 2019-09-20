package ca.bcit.comp2522.labs.lab02;

/**
 * Driver.
 *
 * @author Tommy May
 * @version 2019
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println(simulateDetailedRace(100));
        System.out.println(simulateRaces(100,100));
        System.out.println(simulateRaces(100,1000));
        System.out.println(simulateRaces(10000,100));
        System.out.println(simulateRaces(10000,1000));
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
            if (race.simulateRace().equals("Hare")) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }
        return numberOfRaces + " Races of length " + lengthOfRace + ":\nTortoise Wins: "
                + tortoiseWins + "\nHare Wins: " + hareWins + "\n";
    }

    /**
     * Simulates  1 race of length LengthOfRace between a tortoise and a hare and returns the results as a string
     *
     * @param lengthOfRace an int
     * @return string with who won and positions of the hare and tortoise
     */
    public static String simulateDetailedRace(int lengthOfRace) {
        Race race = new Race(lengthOfRace);
        if (race.simulateRace().equals("Hare")){
            return "The Hare won the race of length 100 after " + race.getClockTicks() +
                    " clock ticks: \n" + race.getHare().toString() + "\n" + race.getTortoise().toString() + "\n";
        } else {
            return "The Tortoise won the race of length 100 after" + race.getClockTicks() + "clock ticks: \n"
                    + race.getHare().toString() + "\n" + race.getTortoise().toString() + "\n";
        }
    }
}
