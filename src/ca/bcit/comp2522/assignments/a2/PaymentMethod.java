package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a possible Payment Methods that cards may implement.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public interface PaymentMethod {
    /**
     * A method for a card to complete a payment transaction.
     */
    void payment(int amount);
}
