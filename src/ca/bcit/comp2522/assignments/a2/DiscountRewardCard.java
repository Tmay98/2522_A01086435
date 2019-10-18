package ca.bcit.comp2522.assignments.a2;

public class DiscountRewardCard extends Card {

    private int discountAmount;

    /**
     * Constructs an object of type RewardCard.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     * @param discountAmount an int
     */
    public DiscountRewardCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                              int discountAmount) {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (discountAmount <= 0) {
            throw new IllegalArgumentException("Discount amount must be a positive integer");
        } else {
            this.discountAmount = discountAmount;
        }
    }

    /**
     * Returns the discount amount.
     *
     * @return discountAmount
     */
    public int getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets the discountAmount if it is a positive integer.
     *
     * @param discountAmount an int
     */
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
