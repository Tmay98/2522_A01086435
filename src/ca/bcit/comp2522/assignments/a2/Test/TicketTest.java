package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.Ticket;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket defaultTicket;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultTicket = new Ticket("name", "cardname", true,
                "description", 100);
    }

    @Test
    public void testGetTicketPrice() {
        assertEquals(100, defaultTicket.getTicketPrice());
    }

    @Test
    public void testSetTicketPrice() {
        defaultTicket.setTicketPrice(50);
        assertEquals(50, defaultTicket.getTicketPrice());
    }

    @Test
    public void testIncorrectTicketPriceThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Ticket test = new Ticket("name", "cardname", true,
                "description", -5);
    }
}
