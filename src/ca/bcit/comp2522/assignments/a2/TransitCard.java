package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a Transit Card.
 *
 * @author Tommy
 * @version 2019
 */
public class TransitCard extends Card implements PaymentMethod {

    private static final int VALID_JAPAN_TRANSIT_CARD_NUMBER_LENGTH = 17;
    private static final int VALID_LONDON_TRANSIT_CARD_NUMBER_LENGTH = 8;

    private double accountBalance;
    private String transitCardNumber;
    private IssueAndExpiryDate issueAndExpiryDate;

    /**
     * Constsructs an object of type TransitCard.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     * @param accountBalance a double
     * @param transitCardNumber a String
     * @param issueAndExpiryDate an IssueAndExpiryDate
     * @throws IllegalArgumentException an Exception
     * */
    public TransitCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                       double accountBalance, String transitCardNumber, IssueAndExpiryDate issueAndExpiryDate)
            throws IllegalArgumentException {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (Double.compare(accountBalance, 0) < 0) {
            throw new IllegalArgumentException("Invalid account balance");
        }

        if (!(transitCardNumber.length() == VALID_JAPAN_TRANSIT_CARD_NUMBER_LENGTH
                || transitCardNumber.length() == VALID_LONDON_TRANSIT_CARD_NUMBER_LENGTH)) {
            throw new IllegalArgumentException("Invalid transit card number");
        }

        if (issueAndExpiryDate == null) {
            throw new IllegalArgumentException("Invalid issue and expiry date");
        }

        this.accountBalance = accountBalance;
        this.issueAndExpiryDate = issueAndExpiryDate;
        this.transitCardNumber = transitCardNumber;

    }

    /**
     * Returns account balance.
     *
     * @return accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Returns the transit card number.
     *
     * @return transitCardNumber
     */
    public String getTransitCardNumber() {
        return transitCardNumber;
    }

    /**
     * Returns the issue and expiry date.
     *
     * @return issueAndExpiryDate
     */
    public IssueAndExpiryDate getIssueAndExpiryDate() {
        return issueAndExpiryDate;
    }

    /**
     * Sets the account balance if the number is greater than 0.
     *
     * @param accountBalance a double
     */
    public void setAccountBalance(double accountBalance) {
        if (!(Double.compare(accountBalance, 0) < 0)) {
            this.accountBalance = accountBalance;
        }
    }

    /**
     * Sets the transit card number if it is of valid length.
     *
     * @param transitCardNumber a String
     */
    public void setTransitCardNumber(String transitCardNumber) {
        if (transitCardNumber.length() == VALID_JAPAN_TRANSIT_CARD_NUMBER_LENGTH
                || transitCardNumber.length() == VALID_LONDON_TRANSIT_CARD_NUMBER_LENGTH) {
            this.transitCardNumber = transitCardNumber;
        }
    }

    /**
     * Pays an amount of points and subtracts it from points.
     *
     * @param amount an int
     */
    @Override
    public void payment(int amount) {
        if (amount < accountBalance) {
            accountBalance -= amount;
            System.out.println("You payed" + amount);
        } else {
            System.out.println("You dont have" + amount + "in your account");
        }
    }

    @Override
    public String toString() {
        return "TransitCard{" +
                "accountBalance=" + accountBalance +
                ", transitCardNumber='" + transitCardNumber + '\'' +
                ", issueAndExpiryDate=" + issueAndExpiryDate +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransitCard that = (TransitCard) o;
        return Double.compare(that.accountBalance, accountBalance) == 0 &&
                Objects.equals(transitCardNumber, that.transitCardNumber) &&
                Objects.equals(issueAndExpiryDate, that.issueAndExpiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountBalance, transitCardNumber, issueAndExpiryDate);
    }
}
