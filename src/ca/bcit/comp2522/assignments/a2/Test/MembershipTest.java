package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.Membership;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MembershipTest {

    private Membership defaultMembership;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultMembership = new Membership("name", "cardname", true,
                "description", "Vip");
    }

    @Test
    public void testGetMembershipLevel() {
        assertEquals("Vip", defaultMembership.getMembershipLevel());
    }

    @Test
    public void testSetMembershipLevel() {
        defaultMembership.setMembershipLevel("level");
    }

    @Test
    public void testIncorrectMembershipLevelThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Membership test = new Membership("name", "cardname", true,
                "description", "  ");
    }

    @Test
    public void testNullMembershipLevelThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Membership test = new Membership("name", "cardname", true,
                "description", null);
    }
}
