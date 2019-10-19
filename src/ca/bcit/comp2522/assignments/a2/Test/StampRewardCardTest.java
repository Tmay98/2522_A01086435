package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.StampRewardCard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StampRewardCardTest {

    private StampRewardCard defaultStampRewardCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultStampRewardCard = new StampRewardCard("name", "cardname", true,
                "description", 10, 0, "chicken");
    }

    @Test
    public void testGetMaxStamps() {
        assertEquals(10, defaultStampRewardCard.getMaxStamps());
    }

    @Test
    public void testGetCurrentStamps() {
        assertEquals(0, defaultStampRewardCard.getCurrentStamps());
    }

    @Test
    public void testGetReward() {
        assertEquals("chicken", defaultStampRewardCard.getReward());
    }

    @Test
    public void testSetMaxStamps() {
        defaultStampRewardCard.setMaxStamps(20);
        assertEquals(20, defaultStampRewardCard.getMaxStamps());
    }

    @Test
    public void testSetCurrentStamps() {
        defaultStampRewardCard.setCurrentStamps(5);
        assertEquals(5, defaultStampRewardCard.getCurrentStamps());
    }

    @Test
    public void testIncrementStamps() {
        defaultStampRewardCard.setCurrentStamps(1);
        defaultStampRewardCard.incrementStamps();
        assertEquals(2, defaultStampRewardCard.getCurrentStamps());
    }

    @Test
    public void testPaymentMethod() {
        defaultStampRewardCard.payment(defaultStampRewardCard.getMaxStamps());
        assertEquals(0, defaultStampRewardCard.getCurrentStamps());
    }

}
