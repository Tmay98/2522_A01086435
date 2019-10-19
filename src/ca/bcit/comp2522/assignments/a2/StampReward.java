package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a Stamp Reward Card.
 *
 * @author Tommy
 * @author Aiman
 * @version 2019
 */
public class StampReward extends Card implements PaymentMethod {

    private int maxStamps;
    private int currentStamps;
    private String reward;

    /**
     * Constructs an object of type RewardCard.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     * @param maxStamps        an int
     * @param currentStamps    an int
     * @param reward           a String
     */
    public StampReward(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                       int maxStamps, int currentStamps, String reward) {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (maxStamps <= 0) {
            throw new IllegalArgumentException("Max stamps must be a positive integer");
        }
        if (currentStamps < 0) {
            throw new IllegalArgumentException("Current stamps cannot be a negative integer");
        }
        if (reward == null || reward.trim().length() == 0) {
            throw new IllegalArgumentException("Must have a reward");
        }
        this.reward = reward;
        this.maxStamps = maxStamps;
        this.currentStamps = currentStamps;
    }

    /**
     * Returns the max stamps.
     *
     * @return maxStamps
     */
    public int getMaxStamps() {
        return maxStamps;
    }

    /**
     * Returns the reward.
     *
     * @return reward
     */
    public String getReward() {
        return reward;
    }

    /**
     * Returns the current stamps.
     *
     * @return currentStamps
     */
    public int getCurrentStamps() {
        return currentStamps;
    }

    /**
     * Sets the maxStamps if it is a positive integer.
     *
     * @param maxStamps an int
     */
    public void setMaxStamps(int maxStamps) {
        if (!(maxStamps <= 0)) {
            this.maxStamps = maxStamps;
        }
    }

    /**
     * Sets the currentStamps if it is a non-negative integer.
     *
     * @param currentStamps an int
     */
    public void setCurrentStamps(int currentStamps) {
        if (!(currentStamps <= 0)) {
            this.currentStamps = currentStamps;
        }
    }

    /**
     * Increments stamps by 1.
     */
    public void incrementStamps() {
        if (currentStamps++ == maxStamps) {
            payment(maxStamps);
        }
    }

    /**
     * Receives card reward.
     *
     * @param amount an int
     */
    @Override
    public void payment(int amount) {
        if (amount == maxStamps) {
            System.out.println("You got " + amount + "Stamps. You received" + getReward());
            setCurrentStamps(0);
        }
    }

    @Override
    public String toString() {
        return "StampRewardCard{" + "\n" +
                "maxStamps=" + maxStamps + "\n" +
                "currentStamps=" + currentStamps + "\n" +
                "reward=" + reward  + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StampReward that = (StampReward) o;
        return maxStamps == that.maxStamps &&
                currentStamps == that.currentStamps &&
                Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxStamps, currentStamps, reward);
    }
}
