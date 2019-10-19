package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents an Insurance Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class InsuranceCard extends AdditionalIdentification {

    private String planNumber;

    public InsuranceCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                         String newIDNumber, String newSecondIDNumber,
                         IssueAndExpiryDate newIssueAndExpiryDate, Name newName, String planNumber) {
        super(organizationName, cardName, cardLogo, cardDescription, newIDNumber,
                newSecondIDNumber, newIssueAndExpiryDate, newName);

        if (planNumber == null) {
            throw new IllegalArgumentException("A Card's second Identification Number cannot be null.");
        }
        if (!isAlphaNumeric(planNumber)) {
            throw new IllegalArgumentException("Card second Identification Number has illegal characters.");
        } else {
            this.planNumber = planNumber;
        }
    }

    /**
     * Set the identification number of a card.
     *
     * @param newPlanNumber a String
     */
    public void setPlanNumber(String newPlanNumber) {
        if (newPlanNumber == null) {
            throw new IllegalArgumentException("A Card's Plan Number cannot be null.");
        }
        if (!isAlphaNumeric(newPlanNumber)) {
            throw new IllegalArgumentException("Card Plan Number has illegal characters.");
        } else {
            this.planNumber = newPlanNumber;
        }
    }

    /**
     * Return secondIDNumber as a String.
     *
     * @return a String
     */
    public String getPlanNumber() {
        return planNumber;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" + "\n" +
                "planNumber=" + planNumber + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InsuranceCard that = (InsuranceCard) o;
        return Objects.equals(planNumber, that.planNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planNumber);
    }
}

