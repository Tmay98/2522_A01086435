package ca.bcit.comp2522.assignments.a1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Ecosystem {

    public static final int SKOOKUMCHUK_VOLUME_LITRES = 3000;
    public static final int SQUAMISH_VOLUME_LITRES = 15000;
    public static final int SEMIAHMOO_VOLUME_LITRES = 8500;
    public static final int SKOOKUMCHUK_TEMP_CELSIUS = 42;
    public static final double SKOOKUMCHUK_PH = 7.9;
    public static final double SKOOKUMCHUK_NUTRIENT_COEFFICIENT = 0.9;
    public static final int SQUAMISH_TEMP_CELSIUS = 39;
    public static final double SQUAMISH_PH = 7.7;
    public static final double SQUAMISH_NUTRIENT_COEFFICIENT = 0.85;
    public static final int SEMIAHMOO_TEMP_CELSIUS = 37;
    public static final double SEMIAHMOO_PH = 7.5;
    public static final double SEMIAHMOO_NUTRIENT_COEFFICIENT = 1.0;
    public static final int SKOOKUMCHUK_POPULATION = 300;
    public static final int SKOOKUMCHUK_AGE_IN_YEARS_RANGE = 16;
    public static final int SKOOKUMCHUK_AGE_IN_YEARS_MIN = 10;
    public static final double SKOOKUMCHUK_FEMALE_CHANCE = 0.75;
    public static final double SKOOKUMCHUK_HEALTH_COEFFICIENT_RANGE = 0.3;
    public static final double SKOOKUMCHUK_HEALTH_COEFFICIENT_MIN = 0.5;
    public static final int SQUAMISH_AGE_IN_YEARS_RANGE = 6;
    public static final int SQUAMISH_AGE_IN_YEARS_MIN = 10;
    public static final double SQUAMISH_FEMALE_CHANCE = 0.75;
    public static final double SQUAMISH_HEALTH_COEFFICIENT_RANGE = 0.2;
    public static final double SQUAMISH_HEALTH_COEFFICIENT_MIN = 0.8;
    public static final int SQUAMISH_POPULATION = 100;
    public static final int SEMIAHMOO_POPULATION = 200;
    public static final int SEMIAHMOO_AGE_IN_YEARS_RANGE = 35;
    public static final int SEMIAHMOO_AGE_IN_YEARS_MIN = 15;
    public static final double SEMIAHMOO_FEMALE_CHANCE = 0.35;

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
     * Returns pools ArrayList.
     *
     * @return pools
     */
    public ArrayList<Pool> getPools() {
        return pools;
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
     * Sets up a new ecosystem for simulation.
     */
    public void setupSimulation() {
        Pool skookumchuk = new Pool("Skookumchuk", SKOOKUMCHUK_VOLUME_LITRES,
                SKOOKUMCHUK_TEMP_CELSIUS, SKOOKUMCHUK_PH, SKOOKUMCHUK_NUTRIENT_COEFFICIENT);
        Pool squamish = new Pool("Squamish", SQUAMISH_VOLUME_LITRES,
                SQUAMISH_TEMP_CELSIUS, SQUAMISH_PH, SQUAMISH_NUTRIENT_COEFFICIENT);
        Pool semiahmoo = new Pool("Semiahmoo", SEMIAHMOO_VOLUME_LITRES,
                SEMIAHMOO_TEMP_CELSIUS, SEMIAHMOO_PH, SEMIAHMOO_NUTRIENT_COEFFICIENT);
        addPool(skookumchuk);
        addPool(squamish);
        addPool(semiahmoo);
        Random rand = new Random();
        for (int i = 0; i < SKOOKUMCHUK_POPULATION; i++) {
            skookumchuk.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    rand.nextInt(SKOOKUMCHUK_AGE_IN_YEARS_RANGE) + SKOOKUMCHUK_AGE_IN_YEARS_MIN,
                    Double.compare(rand.nextDouble(), SKOOKUMCHUK_FEMALE_CHANCE) < 0,
                    0,
                    rand.nextDouble() * SKOOKUMCHUK_HEALTH_COEFFICIENT_RANGE
                            + SKOOKUMCHUK_HEALTH_COEFFICIENT_MIN)
            );
        }

        for (int i = 0; i < SQUAMISH_POPULATION; i++) {
            squamish.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    rand.nextInt(SQUAMISH_AGE_IN_YEARS_RANGE) + SQUAMISH_AGE_IN_YEARS_MIN,
                    Double.compare(rand.nextDouble(), SQUAMISH_FEMALE_CHANCE) < 0,
                    0,
                    rand.nextDouble() * SQUAMISH_HEALTH_COEFFICIENT_RANGE
                            + SQUAMISH_HEALTH_COEFFICIENT_MIN)
            );
        }

        for (int i = 0; i < SEMIAHMOO_POPULATION; i++) {
            semiahmoo.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    rand.nextInt(SEMIAHMOO_AGE_IN_YEARS_RANGE) + SEMIAHMOO_AGE_IN_YEARS_MIN,
                    Double.compare(rand.nextDouble(), SEMIAHMOO_FEMALE_CHANCE) < 0,
                    0,
                    rand.nextDouble())
            );
        }
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

    @Override
    public String toString() {
        return "Ecosystem{" +
                "pools=" + pools +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ecosystem ecosystem = (Ecosystem) o;
        return Objects.equals(pools, ecosystem.pools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pools);
    }
}
