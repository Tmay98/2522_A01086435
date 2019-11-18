package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.Block;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.swing.GroupLayout;

import static org.junit.Assert.*;

public class blockTest {

    private Block testBlock;
    private int testScaleFactor = 50;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testBlock = new Block(testScaleFactor);
    }

    @Test
    public void scaleFactorIsAssignedCorrectly() {
        assertEquals(testScaleFactor, testBlock.getScaleFactor(), 0.0);
    }

    @Test
    public void halfRightAngleConstantIsCorrect() {
        assertEquals(testBlock.HALF_RIGHT_ANGLE, 45, 0.0);
    }

    @Test
    public void rightAngleConstantIsCorrect() {
        assertEquals(testBlock.RIGHT_ANGLE, 90, 0.0);
    }

    @Test
    public void straightAngleConstantIsCorrect() {
        assertEquals(testBlock.STRAIGHT_ANGLE, 180, 0.0);
    }

    @Test
    public void reflexAngleConstantIsCorrect() {
        assertEquals(testBlock.REFLEX_ANGLE, 270, 0.0);
    }

    @Test
    public void quarterBlockLengthConstantIsCorrect() {
        assertEquals(testBlock.QUARTER_BLOCK_LENGTH, 25, 0.0);
    }

    @Test
    public void halfBlockLengthConstantIsCorrect() {
        assertEquals(testBlock.HALF_BLOCK_LENGTH, 50, 0.0);
    }

    @Test
    public void halfTriangleRatioConstantIsCorrect() {
        assertEquals(testBlock.HALF_TRIANGLE_RATIO, 0.707, 0.0);
    }

    @Test
    public void quarterTriangleRatioConstantIsCorrect() {
        assertEquals(testBlock.QUARTER_TRIANGLE_RATIO, 0.49, 0.0);
    }

    @Test
    public void squareLengthConstantIsCorrect() {
        assertEquals(testBlock.SQUARE_LENGTH, 25, 0.0);
    }

    @Test
    public void halfScaleConstantIsCorrect() {
        assertEquals(testBlock.HALF_SCALE, 0.5, 0.0);
    }

    @Test
    public void createTriangleStartsAtCoordinateZero() {
        assertEquals(testBlock.createTriangle().getPoints().get(0), 0, 0.0);
    }

    @Test
    public void createTriangleReturnsPolygonWithSixCoordinates() {
        assertEquals(testBlock.createTriangle().getPoints().size(), 6, 0.0);
    }

    

}
