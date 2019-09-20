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
     * @return position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Sets position
     *
     * @param newPosition an int
     */
    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

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

    @Override
    public String toString() {
        return "Hare{" +
                "position=" + position +
                '}';
    }

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
