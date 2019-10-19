package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.StampReward;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StampRewardTest {

    private StampReward defaultStampReward;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultStampReward = new StampReward("name", "cardname", true,
                "description", 10, 0, "chicken");
    }

    @Test
    public void testGetMaxStamps() {
        assertEquals(10, defaultStampReward.getMaxStamps());
    }

    @Test
    public void testGetCurrentStamps() {
        assertEquals(0, defaultStampReward.getCurrentStamps());
    }

    @Test
    public void testGetReward() {
        assertEquals("chicken", defaultStampReward.getReward());
    }

    @Test
    public void testSetMaxStamps() {
        defaultStampReward.setMaxStamps(20);
        assertEquals(20, defaultStampReward.getMaxStamps());
    }

    @Test
    public void testSetCurrentStamps() {
        defaultStampReward.setCurrentStamps(5);
        assertEquals(5, defaultStampReward.getCurrentStamps());
    }

    @Test
    public void testIncrementStamps() {
        defaultStampReward.setCurrentStamps(1);
        defaultStampReward.incrementStamps();
        assertEquals(2, defaultStampReward.getCurrentStamps());
    }

    @Test
    public void testPaymentMethod() {
        defaultStampReward.payment(defaultStampReward.getMaxStamps());
        assertEquals(0, defaultStampReward.getCurrentStamps());
    }

}
