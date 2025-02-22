package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.RandomSquareBlock;
import ca.bcit.comp2522.assignments.a3.SquareGridBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RandomSquareBlockTest {

    private RandomSquareBlock testBlock;
    private int testScaleFactor = 50;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testBlock = new RandomSquareBlock(testScaleFactor);
    }

    @Test
    public void scaleFactorIsAssignedCorrectly() {
        assertEquals(testScaleFactor, testBlock.getScaleFactor(), 0.0);
    }

    @Test
    public void testNumRowsConstantIsCorrect() {
        assertEquals(SquareGridBlock.NUMBER_OF_ROWS, 4, 0.0);
    }

    @Test
    public void testNumColsConstantIsCorrect() {
        assertEquals(SquareGridBlock.NUMBER_OF_COLUMNS, 4, 0.0);
    }

    @Test
    public void testColourGroup1HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup1().size(), 8);
    }

    @Test
    public void testColourGroup2HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup2().size(), 8);
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup1() {
        testBlock.blockColour(Color.BLUE, 1);
        for (Rectangle rect : testBlock.getColourGroup1()) {
            assertEquals(rect.getFill(), Color.BLUE);
        }
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup2() {
        testBlock.blockColour(Color.BLUE, 2);
        for (Rectangle rect : testBlock.getColourGroup2()) {
            assertEquals(rect.getFill(), Color.BLUE);
        }
    }
}

