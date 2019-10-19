package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.DiscountRewardCard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DiscountRewardCardTest {

    private DiscountRewardCard defaultDiscountRewardCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultDiscountRewardCard = new DiscountRewardCard("eorgeio",
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
