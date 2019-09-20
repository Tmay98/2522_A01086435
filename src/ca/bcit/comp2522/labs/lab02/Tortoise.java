package ca.bcit.comp2522.labs.lab02;

import java.util.Objects;

/**
 * Tortoise.
 *
 * @author Tommy May
 * @version 2019
 */
public class Tortoise {

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
        if(Double.compare(randomNumber, 0.5) < 0) {
            this.position += 3;
            return this.position;
        }
        else if(Double.compare(randomNumber, 0.7) < 0) {
            this.position -= 6;
            return this.position;
        }
        else {
            this.position += 1;
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
