package ca.bcit.comp2522.assignments.a2;

public class StampRewardCard extends Card {

    private int maxStamps;
    private int currentStamps;

    /**
     * Constructs an object of type RewardCard.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     * @param maxStamps an int
     * @param currentStamps an int
     */
    public StampRewardCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                           int maxStamps, int currentStamps) {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (maxStamps <= 0) {
            throw new IllegalArgumentException("Max stamps must be a positive integer");
        }
        if (currentStamps < 0) {
            throw new IllegalArgumentException("Current stamps cannot be a negative integer");
        }
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
}
