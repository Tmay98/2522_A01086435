package ca.bcit.comp2522.assignments.a1;

import java.util.ArrayList;
import java.util.Random;

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

    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;

    private static int numberOfPools = 0;

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
     * @param name a String
     * @param volumeLitres a double
     * @param temperatureCelsius a double
     * @param pH a double
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

        if (temperatureCelsius > MINIMUM_POOL_TEMP_CELSIUS
                && temperatureCelsius < MAXIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(temperatureCelsius);
        } else {
            setTemperatureCelsius(DEFAULT_POOL_TEMP_CELSIUS);
        }

        if (pH > 0.0 && pH < 14.0) {
            setpH(pH);
        } else {
            setpH(NEUTRAL_PH);
        }

        if (nutrientCoefficient > MINIMUM_NUTRIENT_COEFFICIENT
                && nutrientCoefficient < MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(nutrientCoefficient);
        } else {
            setNutrientCoefficient(DEFAULT_NUTRIENT_COEFFICIENT);
        }

        setVolumeLitres(!(volumeLitres < 0) ? volumeLitres : 0.0);
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
        if (temperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS)  {
            this.temperatureCelsius = temperatureCelsius;
        }
    }

    /**
     * Sets the pH if it is over 0.0 and less than 14.0.
     *
     * @param pH a double
     */
    public void setpH(double pH) {
        if (pH > 0.0 || pH < 14.0) {
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
        if (nutrientCoefficient > MINIMUM_NUTRIENT_COEFFICIENT
                && nutrientCoefficient < MAXIMUM_NUTRIENT_COEFFICIENT) {
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
            setNutrientCoefficient(MINIMUM_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(Math.min(nutrientCoefficient + delta, MAXIMUM_NUTRIENT_COEFFICIENT));
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
            setTemperatureCelsius(MINIMUM_POOL_TEMP_CELSIUS);
        } else {
            setTemperatureCelsius(Math.min(temperatureCelsius + delta, MAXIMUM_POOL_TEMP_CELSIUS));
        }
    }

    public static void main(String[] args) {
        Pool test = new Pool();
        int i = 0;
    }

}
