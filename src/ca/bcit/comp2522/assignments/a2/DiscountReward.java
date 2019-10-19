package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a Discount Reward Card.
 *
 * @author Tommy
 * @author Aiman
 * @version 2019
 */
public class DiscountReward extends Card implements PaymentMethod {

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
    public DiscountReward(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
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
        if (discountAmount > 0) {
            this.discountAmount = discountAmount;
        }
    }

    /**
     * Receives card reward.
     *
     * @param amount an int
     */
    @Override
    public void payment(int amount) {
       System.out.println("You got a" + amount + "% discount");
    }

    @Override
    public String toString() {
        return "DiscountRewardCard{" + "\n" +
                "discountAmount=" + discountAmount + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountReward that = (DiscountReward) o;
        return discountAmount == that.discountAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountAmount);
    }
}
