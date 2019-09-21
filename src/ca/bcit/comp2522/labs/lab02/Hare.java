package ca.bcit.comp2522.labs.lab02;

import java.util.Objects;

/**
 * Hare.
 *
 * @author Tommy May
 * @version 2019
 */
public class Hare {

    private static final double HARE_SLEEP_CHANCE = 0.2;
    private static final double HARE_BIG_HOP_CHANCE = 0.3;
    private static final double HARE_BIG_SLIP_CHANCE = 0.4;
    private static final double HARE_SMALL_HOP_CHANCE = 0.7;
    private static final int HARE_BIG_HOP_MOVEMENT = 9;
    private static final int HARE_BIG_SLIP_MOVEMENT = -12;
    private static final int HARE_SMALL_HOP_MOVEMENT = 1;
    private static final int HARE_SMALL_SLIP_MOVEMENT = -2;

    private int position;

    /**
     * Constructs an object of type Hare with default position.
     */
    public Hare() {
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
     * Moves the Hare by adding a value to position and returns its new position
     * 20% of the time adds nothing
     * 10% of the time adds 9 to position
     * 10% of the time subtracts 12 to position
     * 30% of the time adds 1 to position
     * 30% of the time subtracts 3 from position
     *
     * @return position as an int
     */
    public int move() {
        double randomNumber = Math.random();
        if(Double.compare(randomNumber, HARE_SLEEP_CHANCE) < 0) {
        }
        else if(Double.compare(randomNumber, HARE_BIG_HOP_CHANCE) < 0) {
            this.position += HARE_BIG_HOP_MOVEMENT;
        }
        else if(Double.compare(randomNumber, HARE_BIG_SLIP_CHANCE) < 0) {
            this.position += HARE_BIG_SLIP_MOVEMENT;
        }
        else if(Double.compare(randomNumber, HARE_SMALL_HOP_CHANCE) < 0) {
            this.position += HARE_SMALL_HOP_MOVEMENT;
        }
        else {
            this.position += HARE_SMALL_SLIP_MOVEMENT;
        }
        return this.position;
    }

    /**
     * Returns a String representation of this Hare
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Hare{" +
                "position=" + position +
                '}';
    }

    /**
     * Returns true if the specified object is equal to this Hare.
     *
     * @param o an Object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Hare hare = (Hare) o;
        return position == hare.position;
    }
}
