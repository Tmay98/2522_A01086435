package ca.bcit.comp2522.labs.lab02;

/**
 * Race.
 *
 * @author Tommy May
 * @version 2019
 */
public class Race {

    private static final double HARE_FIRST_MOVE_CHANCE = 0.5;

    private final Tortoise tortoise;

    private final Hare hare;

    private final int length;

    private int clockTicks;

    /**
     * returns the amount of clock_ticks
     *
     * @return clock_ticks as an int
     */
    public int getClockTicks() {
        return clockTicks;
    }

    /**
     * returns the hare
     *
     * @return hare as a Hare
     */
    public Hare getHare() {
        return hare;
    }

    /**
     * returns the tortoise
     *
     * @return tortoise as a Tortoise
     */
    public Tortoise getTortoise() {
        return tortoise;
    }

    /**
     * returns the length
     *
     * @return length as as int
     */
    public int getLength() {
        return length;
    }

    /**
     * one parameter constructor for objects of class Race
     *
     * @param length an int
     */
    public Race(int length) {
        this.length = length;
        this.hare = new Hare();
        this.tortoise = new Tortoise();
        this.clockTicks = 0;
    }

    /**
     * Sets tortoise and hare positions to 0
     */
    public void reset() {
        tortoise.setPosition(0);
        hare.setPosition(0);
        clockTicks = 0;
    }

    /**
     * Simulates a race between a hare and tortoise then returns the winner as a string
     *
     * @return String representation of the Hare or Tortoise based on who won the race
     */
    public String simulateRace() {
        reset();
        return race();
    }

    /**
     * Simulates a race between a hare and tortoise then returns the winner
     *
     * @return String representation of the Hare or Tortoise based on who won the race
     */
    private String race(){
        do {
            clockTicks++;
            double moveOrder = Math.random();
            if(moveOrder < HARE_FIRST_MOVE_CHANCE) {
                if(hare.move() >= length) {
                    return "Hare";
                }
                if(tortoise.move() >= length) {
                    return "Tortoise";
                }
            }
            else {
                if(tortoise.move() >= length) {
                    return "Tortoise";
                }
                if(hare.move() >= length) {
                    return "Hare";
                }
            }
        } while(true);
    }
}
