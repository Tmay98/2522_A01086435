package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.IssueAndExpiryDate;
import ca.bcit.comp2522.assignments.a2.Name;
import ca.bcit.comp2522.assignments.a2.PointsReward;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PointsRewardTest {

    private PointsReward defaultPointsAndRewardCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultPointsAndRewardCard = new PointsReward("name",
                "cardname",
                true,
                "description",
                "12312",
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                new Name("t", "w", "m"),
                100
                );
    }

    @Test
    public void testGetPoints() {
        assertEquals(100, defaultPointsAndRewardCard.getPoints());
    }

    @Test
    public void testSetPoints() {
        defaultPointsAndRewardCard.setPoints(200);
        assertEquals(200, defaultPointsAndRewardCard.getPoints());
    }

    @Test
    public void testPaymentMethod() {
        defaultPointsAndRewardCard.setPoints(100);
        defaultPointsAndRewardCard.payment(50);
        assertEquals(50, defaultPointsAndRewardCard.getPoints());
    }

    @Test
    public void testInvalidPointsThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        PointsReward test = new PointsReward("name",
                "cardname",
                true,
                "description",
                "12312",
                new IssueAndExpiryDate("02/02/02", "04/04/04"),
                new Name("t", "w", "m"),
                -50
        );

    }
}
