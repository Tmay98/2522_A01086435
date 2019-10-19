package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.Identification;
import ca.bcit.comp2522.assignments.a2.IssueAndExpiryDate;
import ca.bcit.comp2522.assignments.a2.Name;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class IdentificationTest {

    private Identification defaultIdentificationCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultIdentificationCard = new Identification("orgname", "cardname", true,
                "description", "123123",
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                new Name("t", "m", "l"));
    }

    @Test
    public void testGetIdentificationNumber() {
        assertEquals("123123", defaultIdentificationCard.getIdentificationNumber());
    }

    @Test
    public void testSetIdentificationNumber() {
        defaultIdentificationCard.setIdentificationNumber("12345");
        assertEquals("12345", defaultIdentificationCard.getIdentificationNumber());
    }

    @Test
    public void testInvalidIdentificationNumberThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Identification test = new Identification("orgname", "cardname", true,
                "description", " ",
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                new Name("t", "m", "l"));
    }

    @Test
    public void testNullIdentificationNumberThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Identification test = new Identification("orgname", "cardname", true,
                "description", null,
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                new Name("t", "m", "l"));
    }

    @Test
    public void testNullNameThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Identification test = new Identification("orgname", "cardname", true,
                "description", "123123",
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                null);
    }

    @Test
    public void testNullIssueAndExpiryDateThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Identification test = new Identification("orgname", "cardname", true,
                "description", "123123",
                null,
                new Name("t", "m", "l"));
    }

}
