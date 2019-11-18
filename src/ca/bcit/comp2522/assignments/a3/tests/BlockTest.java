package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.Block;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlockTest {

    private Block testBlock;
    private double testScaleFactor = 50;

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
        assertEquals(Block.HALF_RIGHT_ANGLE, 45, 0.0);
    }

    @Test
    public void rightAngleConstantIsCorrect() {
        assertEquals(Block.RIGHT_ANGLE, 90, 0.0);
    }

    @Test
    public void straightAngleConstantIsCorrect() {
        assertEquals(Block.STRAIGHT_ANGLE, 180, 0.0);
    }

    @Test
    public void reflexAngleConstantIsCorrect() {
        assertEquals(Block.REFLEX_ANGLE, 270, 0.0);
    }

    @Test
    public void quarterBlockLengthConstantIsCorrect() {
        assertEquals(Block.QUARTER_BLOCK_LENGTH, 25, 0.0);
    }

    @Test
    public void halfBlockLengthConstantIsCorrect() {
        assertEquals(Block.HALF_BLOCK_LENGTH, 50, 0.0);
    }

    @Test
    public void halfTriangleRatioConstantIsCorrect() {
        assertEquals(Block.HALF_TRIANGLE_RATIO, 0.707, 0.0);
    }

    @Test
    public void quarterTriangleRatioConstantIsCorrect() {
        assertEquals(Block.QUARTER_TRIANGLE_RATIO, 0.49, 0.0);
    }

    @Test
    public void squareLengthConstantIsCorrect() {
        assertEquals(Block.SQUARE_LENGTH, 25, 0.0);
    }

    @Test
    public void halfScaleConstantIsCorrect() {
        assertEquals(Block.HALF_RATIO, 0.5, 0.0);
    }

    @Test
    public void createTriangleStartsAtCoordinateZero() {
        assertEquals(testBlock.createTriangle().getPoints().get(0), 0, 0.0);
    }

    @Test
    public void createTriangleLengthIsHalfBlockLength() {
        assertEquals(testBlock.createTriangle().getPoints().get(4), Block.HALF_BLOCK_LENGTH, 0.0);
    }

    @Test
    public void createTriangleReturnsPolygonWithSixCoordinates() {
        assertEquals(testBlock.createTriangle().getPoints().size(), 6, 0.0);
    }

    @Test
    public void createSquareStartsAtCoordinateZero() {
        assertEquals(testBlock.createSquare().getX(), 0, 0.0);
    }

    @Test
    public void createSquareHeightIsHalfBlockLength() {
        assertEquals(testBlock.createSquare().getHeight(), Block.HALF_BLOCK_LENGTH, 0.0);
    }

    @Test
    public void createSquareWidthIsHalfBlockLength() {
        assertEquals(testBlock.createSquare().getWidth(), Block.HALF_BLOCK_LENGTH, 0.0);
    }

    @Test
    public void createParallelogramReturnsPolygonWithEightCoordinates() {
        assertEquals(testBlock.createParallelogram().getPoints().size(), 8, 0.0);
    }

    @Test
    public void createParallelogramWidthIsHalfBlockLength() {
        assertEquals(testBlock.createParallelogram().getPoints().get(1), Block.HALF_BLOCK_LENGTH, 0.0);
    }

    @Test
    public void createParallelogramHeightIsQuarterBlockLength() {
        assertEquals(testBlock.createParallelogram().getPoints().get(3), Block.QUARTER_BLOCK_LENGTH, 0.0);
    }

    @Test
    public void createTrianglesCreatesCorrectNumberOfTriangles() {
        assertEquals(testBlock.createTriangles(10).size(), 10, 0.0 );
    }

    @Test
    public void createParallelogramsCreatesCorrectNumberOfParallelograms() {
        assertEquals(testBlock.createParallelograms(10).size(), 10, 0.0 );
    }

    @Test
    public void addSquareAddsSquareToGroupCorrectly() {
        ArrayList<Rectangle> testRectangleArray = new ArrayList<>();
        testBlock.addNewSquare(testRectangleArray, 5, 5);
        assertEquals(testRectangleArray.size(), 1, 0.0);

    }

    @Test
    public void addSquareIsScaledCorrectly() {
        ArrayList<Rectangle> testRectangleArray = new ArrayList<>();
        testBlock.addNewSquare(testRectangleArray, 5, 5);
        assertEquals(testRectangleArray.get(0).getScaleX(), Block.HALF_RATIO, 0.0);
    }

    @Test
    public void setScaleXYSetsXScaleCorrectly() {
        Rectangle testSquare = testBlock.createSquare();
        testBlock.setScaleXY(testSquare, 10.0);

        assertEquals(testSquare.getScaleX(), 10.0, 0.0);
    }

    @Test
    public void setScaleXYSetsYScaleCorrectly() {
        Rectangle testSquare = testBlock.createSquare();
        testBlock.setScaleXY(testSquare, 10.0);

        assertEquals(testSquare.getScaleY(), 10.0, 0.0);
    }

    @Test
    public void setTranslateXYSetsXTranslateCorrectly() {
        Rectangle testSquare = testBlock.createSquare();
        testBlock.setTranslateXY(testSquare, 10.0);

        assertEquals(testSquare.getTranslateX(), 10.0, 0.0);
    }

    @Test
    public void setTranslateXYSetsYTranslateCorrectly() {
        Rectangle testSquare = testBlock.createSquare();
        testBlock.setTranslateXY(testSquare, 10.0);

        assertEquals(testSquare.getTranslateY(), 10.0, 0.0);
    }
}
