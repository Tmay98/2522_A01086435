package ca.bcit.comp2522.labs.lab02;

import java.util.Objects;

public class Hare {

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
     * Moves the hare by adding a value to position and returns its new position
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
        if(Double.compare(randomNumber, 0.2) < 0) {
            return this.position;
        }
        else if(Double.compare(randomNumber, 0.3) < 0) {
            this.position += 9;
            return this.position;
        }
        else if(Double.compare(randomNumber, 0.4) < 0) {
            this.position -= 12;
            return this.position;
        }
        else if(Double.compare(randomNumber, 0.7) < 0) {
            this.position += 1;
            return this.position;
        }
        else {
            this.position -= 3;
            return this.position;
        }
    }

    /**
     * Returns a String representation of this hare
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
     * Returns true if the specified object is equal to this Guppy.
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
