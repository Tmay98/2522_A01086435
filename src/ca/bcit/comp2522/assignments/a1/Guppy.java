package ca.bcit.comp2522.assignments.a1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Guppy.
 *
 * @author Tommy May
 * @version 2019
 */
public class Guppy {

    /**
     * Young fish age in weeks.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**
     * Mature fish age in weeks.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**
     * Maximum age in weeks.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**
     * Minimum water volume in Ml.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**
     * Mature fish constant for finding volume needed.
     */
    public static final double MATURE_FISH_WATER_VOLUME_CONSTANT = 1.5;
    /**
     * Default genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";

    /**
     * Default species.
     */
    public static final String DEFAULT_SPECIES = "reticulata";

    /**
     * Default health coefficient.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**
     * Minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**
     * Maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    /**
     * Maximum number of babies spawned per spawn.
     */
    public static final int MAX_BABIES_SPAWN_AMOUNT = 100;

    /**
     * Chance for a female guppy to spawn.
     */
    public static final double SPAWN_CHANCE = 0.25;

    /**
     * Minimum age for a female guppy to spawn.
     */
    public static final int MINIMUM_SPAWNING_AGE = 8;


    private static int numberOfGuppiesBorn;
    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
    private Random randomNumberGenerator;

    /**
     * Constructs an object of type Guppy with default values.
     */
    public Guppy() {
        this(DEFAULT_GENUS, DEFAULT_SPECIES, 0, true, 0,
                DEFAULT_HEALTH_COEFFICIENT);
    }

    /**
     * Constructs an object of type Guppy.
     *
     * @param newGenus a String
     * @param newSpecies a String
     * @param newAgeInWeeks an int
     * @param newIsFemale a boolean
     * @param newGenerationNumber an int
     * @param newHealthCoefficient a double
     */
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber,
                 double newHealthCoefficient) {
        numberOfGuppiesBorn++;

        if (newGenus == null || newGenus.trim().isEmpty()) {
            this.genus = DEFAULT_GENUS;
        } else {
            this.genus = newGenus.trim().substring(0, 1).toUpperCase() + newGenus.trim().substring(1).toLowerCase();
        }

        if (newSpecies == null || newSpecies.trim().isEmpty()) {
            this.species = DEFAULT_SPECIES;
        } else {
            this.species = newSpecies.trim().toLowerCase();
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        } else {
            this.healthCoefficient = Math.min(newHealthCoefficient, MAXIMUM_HEALTH_COEFFICIENT);
        }

        this.ageInWeeks = Math.max(newAgeInWeeks, 0);
        this.isFemale = newIsFemale;
        this.generationNumber = newGenerationNumber < 0 ? 1 : newGenerationNumber;
        this.isAlive = true;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Increments age by 1 week.
     * Sets isAlive to false if age exceeds MAXIMUM_AGE_IN_WEEKS.
     */
    public void incrementAge() {
        ageInWeeks++;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * Returns the genus.
     *
     * @return genus
     */
    public String getGenus() {
        return genus;
    };

    /**
     * Returns the species.
     *
     * @return species
     */
    public String getSpecies() {
        return species;
    };

    /**
     * Returns the age in weeks.
     *
     * @return ageInWeeks
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    };

    /**
     * Returns if guppy is female.
     *
     * @return isFemale
     */
    public boolean getIsFemale() {
        return isFemale;
    };

    /**
     * Returns Generation number.
     *
     * @return generationNumber
     */
    public int getGenerationNumber() {
        return generationNumber;
    };

    /**
     * Returns if guppy is alive.
     *
     * @return isAlive
     */
    public boolean getIsAlive() {
        return isAlive;
    };

    /**
     * Returns Health coefficient.
     *
     * @return healthCoefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    };

    /**
     * Returns Identification number.
     *
     * @return identificationNumber
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    };

    /**
     * Returns Number of guppies born.
     *
     * @return numberOfGuppiesBorn
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    };

    /**
     * Sets the age in weeks only if it is over 0 and less than MAXIMUM_AGE_IN_WEEKS.
     *
     * @param newAgeInWeeks an int
     */
    public void setAgeInWeeks(int newAgeInWeeks) {
        if (newAgeInWeeks >= 0 && newAgeInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = newAgeInWeeks;
        }
    };

    /**
     * Sets isAlive.
     *
     * @param newIsAlive a boolean
     */
    public void setIsAlive(boolean newIsAlive) {
        this.isAlive = newIsAlive;
    };

    /**
     * Sets health coefficient if it is over MINIMUM_HEALTH_COEFFICIENT
     * and less than MAXIMUM_HEALTH_COEFFICIENT.
     *
     * @param newHealthCoefficient a double
     */
    public void setHealthCoefficient(double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = newHealthCoefficient;
        }
    };

    /**
     * Returns volume of water in Ml that this guppy needs.
     *
     * @return water in ML that the guppy needs
     */
    public double getVolumeNeeded() {
        if (ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * MATURE_FISH_WATER_VOLUME_CONSTANT;
        }
        return 0.0;
    }

    /**
     * Adds value in delta to healthCoefficient instance variable.
     * If health becomes less than MINIMUM_HEALTH_COEFFICIENT sets isAlive to false and healthCoefficient to 0
     * If health becomes more than MAXIMUM_HEALTH_COEFFICIENT sets healthCoefficient to MAXIMUM_HEALTH_COEFFICIENT.
     *
     * @param delta a double
     */
    public void changeHealthCoefficient(double delta) {
        if (healthCoefficient + delta < MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            isAlive = false;
        } else {
            healthCoefficient = Math.min(healthCoefficient + delta, MAXIMUM_HEALTH_COEFFICIENT);
        }
    }

    /**
     * 25% chance to Spawn a random number of guppies if the guppy
     * is over 8 weeks old then returns them in an arrayList.
     * otherwise returns null.
     *
     * @return arrayList of guppies if spawned otherwise returns null
     */
    public ArrayList<Guppy> spawn() {
        if (!this.isFemale) { return null; }
        if (this.ageInWeeks < MINIMUM_SPAWNING_AGE) { return null; }
        if (Double.compare(randomNumberGenerator.nextDouble(), SPAWN_CHANCE) > 0) { return null; }

        ArrayList<Guppy> babyGuppies = new ArrayList<>();
        int babiesAmount = randomNumberGenerator.nextInt(MAX_BABIES_SPAWN_AMOUNT + 1);
        for (int i = 0; i < babiesAmount; i++) {
            babyGuppies.add(new Guppy(genus,
                    species,
                    0,
                    randomNumberGenerator.nextBoolean(),
                    generationNumber + 1,
                    (healthCoefficient + 1) / 2));
            }
            return babyGuppies;
    }

    /**
     * Returns a string representation of this Guppy object.
     *
     * @return representation as a String
     */
    public String toString() {
        String representation;
        representation = "Genus: " + genus + "\n";
        representation += "Species: " + species + "\n";
        representation += "Age in weeks: " + ageInWeeks + "\n";
        representation += "Is female?" + isFemale + "\n";
        representation += "Generation number: " + generationNumber + "\n";
        representation += "IsAlive: " + isAlive + "\n";
        representation += "Health coefficient: " + healthCoefficient + "\n";
        representation += "Identification number: " + identificationNumber + "\n";

        return representation;
    }

    /**
     * Checks whether Guppies are equal.
     *
     * @param obj an Object
     * @return true if objects are equal false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Guppy otherGuppy = (Guppy) obj;
        return genus.equals(otherGuppy.genus) && species.equals(otherGuppy.species)
                && ageInWeeks == otherGuppy.ageInWeeks && isFemale == otherGuppy.isFemale
                && generationNumber == otherGuppy.generationNumber && isAlive == otherGuppy.isAlive
                && healthCoefficient == otherGuppy.healthCoefficient;
    }

    public static void main(String[] args) {
        Guppy myGuppy = new Guppy("hi", "me", 10, true, 2, 0.5);
        ArrayList<Guppy> babyGuppies = myGuppy.spawn();
    }
}
