package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.MembershipCard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MembershipCardTest {

    private MembershipCard defaultMembershipCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultMembershipCard = new MembershipCard("name", "cardname", true,
                "description", "Vip");
    }

    @Test
    public void testGetMembershipLevel() {
        assertEquals("Vip", defaultMembershipCard.getMembershipLevel());
    }

    @Test
    public void testSetMembershipLevel() {
        defaultMembershipCard.setMembershipLevel("level");
    }

    @Test
    public void testIncorrectMembershipLevelThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        MembershipCard test = new MembershipCard("name", "cardname", true,
                "description", "  ");
    }

    @Test
    public void testNullMembershipLevelThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        MembershipCard test = new MembershipCard("name", "cardname", true,
                "description", null);
    }
}
