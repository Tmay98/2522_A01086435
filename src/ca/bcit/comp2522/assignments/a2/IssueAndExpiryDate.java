package ca.bcit.comp2522.assignments.a2;

/**
 * Represents issue and expiry dates of a card.
 *
 * @author Tommy
 * @author Aiman Ismail
 * @version 2019
 */
public class IssueAndExpiryDate {

    private String issueDate;
    private String expiryDate;

    /**
     * Creates an object of type IssueAndExpiryDate.
     *
     * @param issueDate a String
     * @param expiryDate a String
     * @throws IllegalArgumentException an Exception
     */
    public IssueAndExpiryDate(String issueDate, String expiryDate)
            throws IllegalArgumentException {
        if (issueDate.matches("\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}")) {
            this.issueDate = issueDate;
        } else {
            throw new IllegalArgumentException("Invalid issue date");
        }

        if (expiryDate.matches("\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}")) {
            this.expiryDate = expiryDate;
        } else {
            throw new IllegalArgumentException("Invalid expiry date");
        }
    }

    /**
     * Gets the issue date.
     *
     * @return issueDate
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Gets the expiry date.
     *
     * @return expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the issue date if it is in format day/month/year or month/year.
     *
     * @param issueDate a String
     */
    public void setIssueDate(String issueDate) {
        if (issueDate.matches("\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}")) {
            this.issueDate = issueDate;
        }
    }

    /**
     * Sets the expiry date if it is in format day/month/year or month/year.
     *
     * @param expiryDate a String
     */
    public void setExpiryDate(String expiryDate) {
        if (expiryDate.matches("\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}")) {
            this.expiryDate = expiryDate;
        }
    }
}
