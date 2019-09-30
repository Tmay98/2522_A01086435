package ca.bcit.comp2522.assignments.a1;

import java.util.ArrayList;

public class Ecosystem {

    private ArrayList<Pool> pools;

    /**
     * Constructs an object of type Ecosystem.
     */
    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    /**
     * Adds newPool to the pools ArrayList if it is not null.
     *
     * @param newPool a Pool
     */
    public void addPool(Pool newPool) {
        if (newPool == null) { return; }
        pools.add(newPool);
    }

    /**
     * Resets the Ecosystem by emptying the pools ArrayList.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * Returns the guppy population in the Ecosystem.
     *
     * @return guppyPopulation
     */
    public int getGuppyPopulation() {
        int guppyPopulation = 0;
        for (Pool pool : pools) {
            guppyPopulation += pool.getPopulation();
        }
        return guppyPopulation;
    }

    /**
     * Invokes the adjustForCrowding method on all pools and returns
     * the total guppies that were removed due to overcrowding.
     *
     * @return totalGuppiesRemoved
     */
    public int adjustForCrowding() {
        int totalGuppiesRemoved = 0;
        for (Pool pool : pools) {
            totalGuppiesRemoved += pool.adjustForCrowding();
        }
        return totalGuppiesRemoved;
    }

    /**
     * Invokes the incrementAge method on all pools and returns
     * the total guppies that died of old age.
     *
     * @return totalGuppiesRemoved
     */
    public int incrementAges() {
        int totalGuppiesRemoved = 0;
        for (Pool pool : pools) {
            totalGuppiesRemoved += pool.incrementAge();
        }
        return totalGuppiesRemoved;
    }

    /**
     * Invokes the removeDeadGuppies method on all pools and returns
     * the total guppies that were removed.
     *
     * @return numberRemoved
     */
    public int removeDeadGuppies() {
        int totalGuppiesRemoved = 0;
        for (Pool pool : pools) {
            totalGuppiesRemoved += pool.removeDeadGuppies();
        }
        return totalGuppiesRemoved;
    }

    /**
     * Invokes the applyNutrientCoefficient method on all pools and returns
     * the total guppies that died of starvation.
     *
     * @return starvedToDeath
     */
    public int applyNutrientCoefficient() {
        int totalGuppiesRemoved = 0;
        for (Pool pool : pools) {
            totalGuppiesRemoved += pool.applyNutrientCoefficient();
        }
        return totalGuppiesRemoved;
    }

    /**
     * Invokes the spawn method on all pools and returns
     * the total guppies that spawned.
     *
     * @return newFry
     */
    public int spawn() {
        int newFry = 0;
        for (Pool pool : pools) {
            newFry += pool.spawn();
        }
        return newFry;
    }

    /**
     * Invokes SimulateOneWeek as many times as is given.
     *
     * @param numberOfWeeks an int
     */
    public void simulate(int numberOfWeeks) {
        for (int i = 0; i < numberOfWeeks; i++) {
            simulateOneWeek();
        }
    }

    /**
     * Runs the simulation for 1 week.
     */
    public void simulateOneWeek() {
        int diedOfOldAge = incrementAges();
        int numberRemoved = removeDeadGuppies();
        int starvedToDeath = applyNutrientCoefficient();
        numberRemoved += removeDeadGuppies();
        int newFry = spawn();
        int crowdedOut = adjustForCrowding();
        numberRemoved += removeDeadGuppies();

        if (diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved) {
            System.out.println("simulateOneWeek ERROR!!!");
        } else {
            System.out.println("Week number: ??"
                    + "\nDeaths this week due to old age: " + diedOfOldAge
                    + "\nDeaths this week due to starvation:" + starvedToDeath
                    + "\nDeaths this week due to overcrowding: " + crowdedOut
                    + "\nNumber of births this week: " + newFry
                    + "\nEcosystem population this week: " + this.getGuppyPopulation());
            for (Pool pool : pools) {
                System.out.println(pool.getName() + "Population: " + pool.getPopulation());
            }
            System.out.println();
        }
    }

}
