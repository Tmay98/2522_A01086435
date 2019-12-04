package ca.bcit.comp2522.assignments.a1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a Pool.
 *
 * @author Tommy May
 * @version 2019
 */
public class Pool {

    /**
     * Default pool name.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    /**
     * Default pool temperature.
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /**
     * Minimum pool temp in celsius.
     */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /**
     * Maximum pool temp in celsius.
     */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /**
     * Neutral pH.
     */
    public static final double NEUTRAL_PH = 7.0;

    /**
     * Default nutrient coefficient.
     */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /**
     * Minimum nutrient coefficient.
     */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /**
     * Maximum nutrient coefficient.
     */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    /**
     * Constant to convert from mL to L.
     */
    public static final double ML_TO_L_CONVERSION = 0.001;

    /**
     * Constant to convert to percentage.
     */
    public static final int PERCENTAGE_CONVERSION = 100;

    /**
     * Maximum pH.
     */
    public static final double MAXIMUM_PH = 14.0;

    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;

    private static int numberOfPools;

    /**
     * Constructs an object of type Pool with default values.
     */
    public Pool() {
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS,
                NEUTRAL_PH, DEFAULT_NUTRIENT_COEFFICIENT);
    }

    /**
     * Constructs an object of type Pool.
     *
     * @param name                a String
     * @param volumeLitres        a double
     * @param temperatureCelsius  a double
     * @param pH                  a double
     * @param nutrientCoefficient a double
     * @throws IllegalArgumentException an exception
     */
    public Pool(String name, double volumeLitres, double temperatureCelsius,
                double pH, double nutrientCoefficient) throws IllegalArgumentException {
        if (!(name == null || name.trim().isEmpty())) {
            this.name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
        } else {
            throw new IllegalArgumentException("invalid name");
        }

        if (Double.compare(temperatureCelsius, MINIMUM_POOL_TEMP_CELSIUS) >= 0
                && Double.compare(temperatureCelsius, MAXIMUM_POOL_TEMP_CELSIUS) <= 0) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }

        if (pH >= 0.0 && pH <= MAXIMUM_PH) {
            this.pH = pH;
        } else {
            this.pH = NEUTRAL_PH;
        }

        if (Double.compare(nutrientCoefficient, MINIMUM_NUTRIENT_COEFFICIENT) >= 0
                && Double.compare(nutrientCoefficient, MAXIMUM_NUTRIENT_COEFFICIENT) <= 0) {
            this.nutrientCoefficient = nutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }

        this.volumeLitres = !(volumeLitres < 0) ? volumeLitres : 0.0;
        this.guppiesInPool = new ArrayList<Guppy>();
        this.randomNumberGenerator = new Random();
        this.identificationNumber = ++numberOfPools;
    }

    /**
     * Returns the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the volume in litres.
     *
     * @return volumeLitres
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Returns the temperature in celsius.
     *
     * @return temperatureCelsius
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Returns pH.
     *
     * @return pH
     */
    public double getpH() {
        return pH;
    }

    /**
     * Returns guppiesInPool.
     *
     * @return guppiesInPool
     */
    public ArrayList<Guppy> getGuppiesInPool() {
        return guppiesInPool;
    }

    /**
     * Returns the nutrient Coefficient.
     *
     * @return nutrientCoefficient
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Returns the identification number.
     *
     * @return identificationNumber
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * returns the number of living guppies in the pool.
     *
     * @return number of guppies
     */
    public int getPopulation() {

        int guppiesAlive = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                guppiesAlive++;
            }
        }
        return guppiesAlive;
    }

    /**
     * Returns the number of pools.
     *
     * @return numberOfPools
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Sets the volume in litres only if it is greater than 0.
     *
     * @param volumeLitres a double
     */
    public void setVolumeLitres(double volumeLitres) {
        if (!(volumeLitres < 0.0)) {
            this.volumeLitres = volumeLitres;
        }
    }

    /**
     * Sets the temperature in celsius if it is greater than MINIMUM_POOL_TEMP_CELSIUS
     * and less than MAXIMUM_POOL_TEMP_CELSIUS.
     *
     * @param temperatureCelsius a double
     */
    public void setTemperatureCelsius(double temperatureCelsius) {
        if (Double.compare(temperatureCelsius, MINIMUM_POOL_TEMP_CELSIUS) >= 0
                && Double.compare(temperatureCelsius, MAXIMUM_POOL_TEMP_CELSIUS) <= 0) {
            this.temperatureCelsius = temperatureCelsius;
        }
    }

    /**
     * Sets the pH if it is over 0.0 and less than 14.0.
     *
     * @param pH a double
     */
    public void setpH(double pH) {
        if (Double.compare(pH, 0.0) > 0 && Double.compare(pH, MAXIMUM_PH) < 0) {
            this.pH = pH;
        }
    }

    /**
     * Sets the nutrient coefficient if it is greater than MINIMUM_NUTRIENT_COEFFICIENT
     * and less than MAXIMUM_NUTRIENT_COEFFICIENT.
     *
     * @param nutrientCoefficient a double
     */
    public void setNutrientCoefficient(double nutrientCoefficient) {
        if (Double.compare(nutrientCoefficient, MINIMUM_NUTRIENT_COEFFICIENT) >= 0
                && Double.compare(nutrientCoefficient, MAXIMUM_NUTRIENT_COEFFICIENT) <= 0) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }

    /**
     * Adds value in delta to nutrientCoefficient instance variable.
     * If health becomes less than MINIMUM_NUTRIENT_COEFFICIENT sets nutrientCoefficient to MINIMUM_NUTRIENT_COEFFICIENT
     * If health becomes more than MAXIMUM_NUTRIENT_COEFFICIENT sets nutrientCoefficient to MAXIMUM_NUTRIENT_COEFFICIENT
     *
     * @param delta a double
     */
    public void changeNutrientCoefficient(double delta) {
        if (nutrientCoefficient + delta < MINIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else {
            this.nutrientCoefficient = Math.min(nutrientCoefficient + delta, MAXIMUM_NUTRIENT_COEFFICIENT);
        }
    }

    /**
     * Adds value in delta to temperatureCelsius instance variable.
     * If health becomes less than MINIMUM_POOL_TEMP_CELSIUS sets temperatureCelsius to MINIMUM_POOL_TEMP_CELSIUS
     * If health becomes more than MAXIMUM_POOL_TEMP_CELSIUS sets temperatureCelsius to MAXIMUM_POOL_TEMP_CELSIUS
     *
     * @param delta a double
     */
    public void changeTemperature(double delta) {
        if (temperatureCelsius + delta < MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else {
            this.temperatureCelsius = Math.min(temperatureCelsius + delta, MAXIMUM_POOL_TEMP_CELSIUS);
        }
    }

    /**
     * Adds a guppy to the pool. if input parameter is null returns false.
     *
     * @param guppy a Guppy
     * @return true if guppy was added, false otherwise
     */
    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        return guppiesInPool.add(guppy);
    }

    /**
     * Calculates which guppies have died of malnutrition
     * this week and returns the number of deaths.
     *
     * @return deadGuppies
     */
    public int applyNutrientCoefficient() {
        int deadGuppies = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (randomNumberGenerator.nextDouble() > this.nutrientCoefficient && guppy.getIsAlive()) {
                guppy.setIsAlive(false);
                deadGuppies++;
            }
        }
        return deadGuppies;
    }

    /**
     * Removes all dead guppies from guppiesInPool.
     *
     * @return deadGuppiesRemoved
     */
    public int removeDeadGuppies() {
        int deadGuppiesRemoved = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (!guppy.getIsAlive()) {
                it.remove();
                deadGuppiesRemoved++;
            }
        }
        return deadGuppiesRemoved;
    }

    /**
     * returns the total volume required in Litres for guppies in the pool.
     *
     * @return totalVolumeRequired
     */
    public double getGuppyVolumeRequirementInLitres() {
        double totalVolumeRequired = 0.0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                totalVolumeRequired += guppy.getVolumeNeeded() * ML_TO_L_CONVERSION;
            }
        }
        return totalVolumeRequired;
    }

    /**
     * Returns the average age of the living guppies in the pool.
     *
     * @return averageAgeOfGuppies
     */
    public double getAverageAgeInWeeks() {
        if (getPopulation() == 0) {
            return 0;
        }
        int totalGuppiesAge = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                totalGuppiesAge += guppy.getAgeInWeeks();
            }
        }
        return (double) totalGuppiesAge / getPopulation();
    }

    /**
     * Returns the average health coefficient of the living guppies in the pool.
     *
     * @return averageHealthCoefficient
     */
    public double getAverageHealthCoefficient() {
        if (getPopulation() == 0) {
            return 0;
        }
        double totalHealthCoefficient = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                totalHealthCoefficient += guppy.getHealthCoefficient();
            }
        }
        return totalHealthCoefficient / getPopulation();
    }

    /**
     * Returns the percentage of living guppies in the pool that are female.
     *
     * @return percentage of female guppies in the pool
     */
    public double getFemalePercentage() {
        if (getPopulation() == 0) {
            return 0;
        }
        double totalFemales = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsFemale() && guppy.getIsAlive()) {
                totalFemales++;
            }
        }
        return totalFemales / getPopulation() * PERCENTAGE_CONVERSION;
    }

    /**
     * Returns the median age of the living guppies in the pool.
     *
     * @return median age of living guppies in pool
     */
    public double getMedianAge() {
        this.removeDeadGuppies();
        if (getPopulation() == 0) {
            return 0;
        }
        Collections.sort(this.guppiesInPool, new GuppyAgeComparator());
        double medianAge = 0.0;
        int guppiesAmount = guppiesInPool.size();
        if (guppiesAmount % 2 == 0) {
            return (double) (guppiesInPool.get(guppiesAmount / 2).getAgeInWeeks()
                    + guppiesInPool.get(guppiesAmount / 2 - 1).getAgeInWeeks()) / 2;
        } else {
            return guppiesInPool.get(guppiesAmount / 2).getAgeInWeeks();
        }
    }

    /**
     * Iterates over all guppies in the pool and invokes the spawn method on each one.
     *
     * @return totalBabyGuppies
     */
    public int spawn() {
        if (getPopulation() == 0) {
            return 0;
        }
        Iterator<Guppy> it = guppiesInPool.iterator();
        ArrayList<Guppy> totalbabyGuppies = new ArrayList<>();
        ArrayList<Guppy> babyGuppies;
        while (it.hasNext()) {
            Guppy guppy = it.next();
            babyGuppies = guppy.spawn();
            if (babyGuppies != null) {
                totalbabyGuppies.addAll(babyGuppies);
            }
        }
        guppiesInPool.addAll(totalbabyGuppies);
        return totalbabyGuppies.size();
    }

    /**
     * Increments the age of every guppy in the pool
     * and returns the number that have died of old age.
     *
     * @return deadGuppiesAmount
     */
    public int incrementAge() {
        if (getPopulation() == 0) {
            return 0;
        }
        Iterator<Guppy> it = guppiesInPool.iterator();
        int deadGuppiesAmount = 0;
        boolean isAlive;
        while (it.hasNext()) {
            Guppy guppy = it.next();
            isAlive = guppy.getIsAlive();
            guppy.incrementAge();
            if (!guppy.getIsAlive() && isAlive) {
                deadGuppiesAmount++;
            }
        }
        return deadGuppiesAmount;
    }

    /**
     * Extinguishes the guppies that have suffocated due to overcrowding.
     *
     * @return Amount of guppies that suffocated
     */
    public int adjustForCrowding() {
        if (getPopulation() == 0) {
            return 0;
        }
        int deadGuppiesAmount = 0;
        double totalVolumeNeeded = getGuppyVolumeRequirementInLitres();
        while (Double.compare(totalVolumeNeeded, getVolumeLitres()) > 0) {
            Guppy weakestGuppy = findWeakestGuppy();
            totalVolumeNeeded -= weakestGuppy.getVolumeNeeded() * ML_TO_L_CONVERSION;
            weakestGuppy.setIsAlive(false);
            deadGuppiesAmount++;
        }
        return deadGuppiesAmount;
    }

    /**
     * Finds the weakest guppy in the pool and returns it.
     *
     * @return weakestGuppy
     */
    private Guppy findWeakestGuppy() {
        Guppy weakestGuppy = null;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (!guppy.getIsAlive()) {
                continue;
            }
            if (weakestGuppy == null) {
                weakestGuppy = guppy;
            }
            if (guppy.getHealthCoefficient() <= weakestGuppy.getHealthCoefficient()) {
                weakestGuppy = guppy;
            }
        }
        return weakestGuppy;
    }

    /**
     * prints pool details.
     */
    public void printDetails() {
        System.out.println(this.toString());
    }

    /**
     * String representation of this pool.
     *
     * @return representation as a string
     */
    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pool pool = (Pool) o;
        return Double.compare(pool.volumeLitres, volumeLitres) == 0 &&
                Double.compare(pool.temperatureCelsius, temperatureCelsius) == 0 &&
                Double.compare(pool.pH, pH) == 0 &&
                Double.compare(pool.nutrientCoefficient, nutrientCoefficient) == 0 &&
                identificationNumber == pool.identificationNumber &&
                Objects.equals(name, pool.name) &&
                Objects.equals(guppiesInPool, pool.guppiesInPool) &&
                Objects.equals(randomNumberGenerator, pool.randomNumberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, volumeLitres, temperatureCelsius, pH,
                nutrientCoefficient, identificationNumber, guppiesInPool, randomNumberGenerator);
    }
}
