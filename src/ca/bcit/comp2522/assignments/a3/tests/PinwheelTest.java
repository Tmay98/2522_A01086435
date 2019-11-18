package ca.bcit.comp2522.assignments.a3.tests;
import ca.bcit.comp2522.assignments.a3.PinwheelBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PinwheelTest {
    private PinwheelBlock testBlock;
    private double testScaleFactor = 50;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testBlock = new PinwheelBlock(testScaleFactor);
    }

    @Test
    public void numberOfTrianglesPerSectionConstantIsCorrect() {
        assertEquals(testBlock.TRIANGLES_PER_SECTION, 4, 0.0);
    }

    @Test
    public void numberOfTrianglesToRotatePerSectionConstantIsCorrect() {
        assertEquals(testBlock.TRIANGLES_TO_ROTATE_PER_SECTION, 3, 0.0);
    }

    @Test
    public void colourGroup1HasCorrectNumberOfTriangles() {
        assertEquals(testBlock.getColourGroup1().size(), 4, 0.0);
    }

    @Test
    public void colourGroup2HasCorrectNumberOfTriangles() {
        assertEquals(testBlock.getColourGroup2().size(), 4, 0.0);
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

}
