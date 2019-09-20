package ca.bcit.comp2522.labs.lab02;

import java.util.Objects;

/**
 * Tortoise.
 *
 * @author Tommy May
 * @version 2019
 */
public class Tortoise {

    public static final double TORTOISE_FAST_PLOD_CHANCE = 0.5;

    public static final double TORTOISE_SLIP_CHANCE = 0.7;

    public static final int TORTOISE_FAST_PLOD_MOVEMENT = 3;

    public static final double TORTOISE_SLIP_MOVEMENT = -6;

    public static final double TORTOISE_SLOW_PLOD_MOVEMENT = 1;

    private int position;

    /**
     * Constructs an object of type Tortoise with default position.
     */
    public Tortoise() {
        this.position = 0;
    }

    /**
     * returns the position
     *
     * @return position as as int
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Sets position
     *
     * @param newPosition as an int
     */
    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    /**
     * Moves the Tortoise by adding a value to position and returns its new position
     * 50% of the time adds 3 to position
     * 20% of the time subtracts 6 from position
     * 30% of the time adds 1 to position
     *
     * @return position as an int
     */
    public int move() {
        double randomNumber = Math.random();
        if(Double.compare(randomNumber, TORTOISE_FAST_PLOD_CHANCE) < 0) {
            this.position += TORTOISE_FAST_PLOD_MOVEMENT;
            return this.position;
        }
        else if(Double.compare(randomNumber, TORTOISE_SLIP_CHANCE) < 0) {
            this.position += TORTOISE_SLIP_MOVEMENT;
            return this.position;
        }
        else {
            this.position += TORTOISE_SLOW_PLOD_MOVEMENT;
            return this.position;
        }
    }

    /**
     * Returns a String representation of this Tortoise
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Tortoise{" +
                "position=" + position +
                '}';
    }

    /**
     * Returns true if the specified object is equal to this Tortoise.
     *
     * @param o an Object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tortoise tortoise = (Tortoise) o;
        return position == tortoise.position;
    }
}
