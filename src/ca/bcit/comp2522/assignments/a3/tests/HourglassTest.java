package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.Block;
import ca.bcit.comp2522.assignments.a3.HourglassBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HourglassTest {
    private HourglassBlock testBlock;
    private double testScaleFactor = 50;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testBlock = new HourglassBlock(testScaleFactor);
    }

    @Test
    public void numberOfLargeTrianglesConstantIsCorrect() {
        assertEquals(testBlock.LARGE_TRIANGLES_IN_HOURGLASS_BLOCK, 4, 0.0);
    }

    @Test
    public void numberOfSmallTrianglesConstantIsCorrect() {
        assertEquals(testBlock.SMALL_TRIANGLES_IN_HOURGLASS_BLOCK, 8, 0.0);
    }

    @Test
    public void numberOfSmallTrianglesInSectionOneConstantIsCorrect() {
        assertEquals(testBlock.SMALL_TRIANGLES_IN_SECTION_ONE, 4, 0.0);
    }

    @Test
    public void numberOfSmallTrianglesInSectionTwoConstantIsCorrect() {
        assertEquals(testBlock.SMALL_TRIANGLES_IN_SECTION_TWO, 2, 0.0);
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup1() {
        testBlock.blockColour(Color.BLUE, 1);
        for (Polygon tri : testBlock.getColourGroup1()) {
            assertEquals(tri.getFill(), Color.BLUE);
        }
    }
    @Test
    public void blockColourSetsColourCorrectlyForGroup2() {
        testBlock.blockColour(Color.BLUE, 2);
        for (Polygon tri : testBlock.getColourGroup2()) {
            assertEquals(tri.getFill(), Color.BLUE);
        }
    }

    @Test
    public void blockColourSetsColourCorrectlyForGroup3() {
        testBlock.blockColour(Color.BLUE, 3);
        for (Polygon tri : testBlock.getColourGroup3()) {
            assertEquals(tri.getFill(), Color.BLUE);
        }
    }
}
