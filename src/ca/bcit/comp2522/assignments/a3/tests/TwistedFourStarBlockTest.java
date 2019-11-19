package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.TwistedFourStarBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TwistedFourStarBlockTest {

    private TwistedFourStarBlock testBlock;
    private int testScaleFactor = 50;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testBlock = new TwistedFourStarBlock(testScaleFactor);
    }

    @Test
    public void scaleFactorIsAssignedCorrectly() {
        assertEquals(testScaleFactor, testBlock.getScaleFactor(), 0.0);
    }

    @Test
    public void testNumberOfQuartersInBlockConstantIsCorrect() {
        assertEquals(TwistedFourStarBlock.QUARTERS_IN_BLOCK, 4, 0.0);
    }

    @Test
    public void testNumberOFTrianglesInColourGroup1ConstantIsCorrect() {
        assertEquals(TwistedFourStarBlock.TRIANGLES_IN_COLOUR_GROUP_ONE, 3, 0.0);
    }

    @Test
    public void testParallelogramsInQuarterSectionConstantIsCorrect() {
        assertEquals(TwistedFourStarBlock.PARALLELOGRAMS_IN_QUARTER_SECTION, 1, 0.0);
    }

    @Test
    public void testColourGroupsInBlockConstantIsCorrect() {
        assertEquals(TwistedFourStarBlock.COLOUR_GROUPS_IN_BLOCK, 4, 0.0);
    }

    @Test
    public void testColourGroup1HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup1().size(), 12);
    }

    @Test
    public void testColourGroup2HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup2().size(), 4);
    }

    @Test
    public void testColourGroup3HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup3().size(), 4);
    }

    @Test
    public void testColourGroup4HasCorrectAmountOfShapes() {
        assertEquals(testBlock.getColourGroup4().size(), 4);
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup1() {
        testBlock.blockColour(Color.BLUE, 1);
        for (Polygon poly : testBlock.getColourGroup1()) {
            assertEquals(poly.getFill(), Color.BLUE);
        }
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup2() {
        testBlock.blockColour(Color.BLUE, 2);
        for (Polygon poly : testBlock.getColourGroup2()) {
            assertEquals(poly.getFill(), Color.BLUE);
        }
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup3() {
        testBlock.blockColour(Color.BLUE, 3);
        for (Polygon poly : testBlock.getColourGroup3()) {
            assertEquals(poly.getFill(), Color.BLUE);
        }
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup4() {
        testBlock.blockColour(Color.BLUE, 4);
        for (Polygon poly : testBlock.getColourGroup4()) {
            assertEquals(poly.getFill(), Color.BLUE);
        }
    }
}
