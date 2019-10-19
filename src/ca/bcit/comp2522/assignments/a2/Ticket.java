package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Ticket.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class Ticket extends Card {

    private int ticketPrice;

    /**
     * Constructs an object of type Ticket.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     * @param ticketPrice an int
     */
    public Ticket(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                  int ticketPrice) {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (ticketPrice < 0) {
            throw new IllegalArgumentException("Ticket price must be a non-negative integer.");
        } else {
            this.ticketPrice = ticketPrice;
        }
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        if (ticketPrice >= 0) {
            this.ticketPrice = ticketPrice;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" + "\n" +
                "ticketPrice=" + ticketPrice + "\n" +
                '}' + super.toString();
    }
}
