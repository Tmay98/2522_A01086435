package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.DiscountReward;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DiscountRewardTest {

    private DiscountReward defaultDiscountRewardCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultDiscountRewardCard = new DiscountReward("eorgeio",
                "eerger",
                true,
                "description",
                20);
    }

    @Test
    public void testGetDiscountAmount() {
        assertEquals(defaultDiscountRewardCard.getDiscountAmount(), 20);
    }

    @Test
    public void testSetDiscountAmount() {
        defaultDiscountRewardCard.setDiscountAmount(10);
        assertEquals(10, defaultDiscountRewardCard.getDiscountAmount());
    }
}
