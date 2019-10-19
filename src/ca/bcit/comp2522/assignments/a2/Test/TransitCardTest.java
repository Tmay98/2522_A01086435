package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.IssueAndExpiryDate;
import ca.bcit.comp2522.assignments.a2.TransitCard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TransitCardTest {

    private TransitCard defaultTransitCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultTransitCard = new TransitCard("name", "cardname", true,
                "description", 100, "12341234123412345",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testGetAccountBalance() {
        assertEquals(100, defaultTransitCard.getAccountBalance(), 0);
    }

    @Test
    public void testGetTransitCardNumber() {
        assertEquals("12341234123412345", defaultTransitCard.getTransitCardNumber());
    }

    @Test
    public void testSetAccountBalance() {
        defaultTransitCard.setAccountBalance(2000);
        assertEquals(2000, defaultTransitCard.getAccountBalance(), 0);
    }

    @Test
    public void testInvalidAccountBalanceThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        TransitCard test = new TransitCard("name", "cardname", true,
                "description", -5, "12341234123412345",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testInvalidTransitCardNumberThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        TransitCard test = new TransitCard("name", "cardname", true,
                "description", 100, "asdd",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testPaymentMethod() {
        TransitCard test = new TransitCard("name", "cardname", true,
                "description", 100, "94859485948594859",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
        test.payment(50);
        assertEquals(50, test.getAccountBalance(), 0);
    }
}
