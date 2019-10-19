package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.IssueAndExpiryDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class IssueAndExpiryDateTest {

    private IssueAndExpiryDate defaultIssueAndExpiryDate;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultIssueAndExpiryDate = new IssueAndExpiryDate("05/02/02", "05/03/20");
    }

    @Test
    public void testGetIssueDate() {
        assertEquals("05/02/02", defaultIssueAndExpiryDate.getIssueDate());
    }

    @Test
    public void testGetExpiryDate() {
        assertEquals("05/03/20", defaultIssueAndExpiryDate.getExpiryDate());
    }

    @Test
    public void testSetIssueDate() {
        defaultIssueAndExpiryDate.setIssueDate("20/08/05");
        assertEquals("20/08/05", defaultIssueAndExpiryDate.getIssueDate());
    }

    @Test
    public void testSetExpiryDate() {
        defaultIssueAndExpiryDate.setExpiryDate("20/08/25");
        assertEquals("20/08/25", defaultIssueAndExpiryDate.getExpiryDate());
    }

    @Test
    public void testIncorrectIssueDateThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        IssueAndExpiryDate test = new IssueAndExpiryDate("sdf", "02/02/98");
    }

    @Test
    public void testIncorrectExpiryDateThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        IssueAndExpiryDate test = new IssueAndExpiryDate("02/04/98", "ghtrh");
    }
}
