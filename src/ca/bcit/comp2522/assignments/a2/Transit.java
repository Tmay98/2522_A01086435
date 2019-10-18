package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Transit Card.
 *
 * @author Tommy
 * @version 2019
 */
public class Transit {

    private static final int VALID_JAPAN_TRANSIT_CARD_NUMBER_LENGTH = 15;
    private static final int VALID_LONDON_TRANSIT_CARD_NUMBER_LENGTH = 8;

    private double accountBalance;
    private String transitCardNumber;
    private IssueAndExpiryDate issueAndExpiryDate;

    /**
     * Constsructs an object of type Transit.
     *
     * @param accountBalance a double
     * @param transitCardNumber a String
     * @param issueAndExpiryDate an IssueAndExpiryDate
     * @throws IllegalArgumentException an Exception
     */
    public Transit(double accountBalance, String transitCardNumber, IssueAndExpiryDate issueAndExpiryDate)
            throws IllegalArgumentException {
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

}
