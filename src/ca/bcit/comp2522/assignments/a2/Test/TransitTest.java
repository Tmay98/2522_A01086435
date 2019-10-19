package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.IssueAndExpiryDate;
import ca.bcit.comp2522.assignments.a2.Transit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TransitTest {

    private Transit defaultTransit;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultTransit = new Transit("name", "cardname", true,
                "description", 100, "12341234123412345",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testGetAccountBalance() {
        assertEquals(100, defaultTransit.getAccountBalance(), 0);
    }

    @Test
    public void testGetTransitCardNumber() {
        assertEquals("12341234123412345", defaultTransit.getTransitCardNumber());
    }

    @Test
    public void testSetAccountBalance() {
        defaultTransit.setAccountBalance(2000);
        assertEquals(2000, defaultTransit.getAccountBalance(), 0);
    }

    @Test
    public void testInvalidAccountBalanceThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Transit test = new Transit("name", "cardname", true,
                "description", -5, "12341234123412345",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testInvalidTransitCardNumberThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Transit test = new Transit("name", "cardname", true,
                "description", 100, "asdd",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
    }

    @Test
    public void testPaymentMethod() {
        Transit test = new Transit("name", "cardname", true,
                "description", 100, "94859485948594859",
                new IssueAndExpiryDate("02/02/02", "04/04/04"));
        test.payment(50);
        assertEquals(50, test.getAccountBalance(), 0);
    }
}
