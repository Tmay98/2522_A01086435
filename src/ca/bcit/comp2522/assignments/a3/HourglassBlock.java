package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

/**
 * A quilt block with a hourglass shaped pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class HourglassBlock extends Block {
    /**
     * Number of large triangles in a hourglass block.
     */
    private static final int NUMBER_OF_LARGE_TRIANGLES = 4;
    /**
     * Number of small triangles in a hourglass block.
     */
    private static final int NUMBER_OF_SMALL_TRIANGLES = 8;
    /**
     * Number of colour groups in an hourglass block.
     */
    private static final int NUMBER_OF_COLOUR_GROUPS_IN_HOURGLASS_BLOCK = 3;
    /**
     * Number of small triangles in colour section 1 in an hourglass block.
     */
    private static final int NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_ONE = 4;
    /**
     * Number of small triangles in colour section 2 in an hourglass block.
     */
    private static final int NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO = 2;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;
    private Group block;
    private double scaleFactor;

    /**
     * Generates a block with an hourglass pattern.
     *
     * @param scaleFactor a double
     */
    public HourglassBlock(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();

        block = new Group();
        createBlock();
    }
    /**
     * Generates the sections in an hourglass block.
     */
    private void createSections() {
        ArrayList<Polygon> largeTriangles = createTriangles(
                NUMBER_OF_LARGE_TRIANGLES);
        ArrayList<Polygon> smallTriangles = createTriangles(
                NUMBER_OF_SMALL_TRIANGLES);

        int largeTriangleRotation = 0;
        for (Polygon largeTriangle : largeTriangles) {
            // Rotating large triangles  //
            largeTriangle.setRotate(largeTriangleRotation);
            largeTriangleRotation += RIGHT_ANGLE;

            // Adding large triangles to colour group //
            if (largeTriangles.indexOf(largeTriangle) % 2 != 0) {
                colourGroup1.add(largeTriangle);
            } else {
                colourGroup2.add(largeTriangle);
            }
        }

        int smallTriangleRotation = HALF_RIGHT_ANGLE;
        for (Polygon smallTriangle : smallTriangles) {
            // Rotating small triangles //
            super.setScaleXY(smallTriangle, HALF_TRIANGLE_RATIO);
            smallTriangleRotation += RIGHT_ANGLE;
            smallTriangle.setRotate(smallTriangleRotation);

            if (smallTriangles.indexOf(smallTriangle) % 2 == 0) {
                colourGroup1.add(smallTriangle);
            } else if (smallTriangles.indexOf(smallTriangle)
                    <= NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_ONE) {
                colourGroup2.add(smallTriangle);
            } else {
                colourGroup3.add(smallTriangle);
            }
        }
        for (Polygon polygon : colourGroup1) {
            polygon.setFill(Color.RED);
        }
    }
    /**
     * Translates the sections in an hourglass block.
     */
    private void translateSections() {

        // Group 1 large triangles //
        setTranslateXY(colourGroup1.get(1), HALF_BLOCK_LENGTH);
        // Group 1 small triangles //
        for (int i = 2; i < colourGroup1.size(); i++) {
            colourGroup1.get(i).setTranslateX(QUARTER_BLOCK_LENGTH);
        }
        colourGroup1.get(NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_ONE)
                .setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup1.get(NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_ONE + 1)
                .setTranslateY(HALF_BLOCK_LENGTH);

        // Group 2 large triangles //
        colourGroup2.get(0).setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup2.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        // Group 2 small triangles //
        colourGroup2.get(NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO)
                .setTranslateY(QUARTER_BLOCK_LENGTH);
        colourGroup2.get(NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO)
                .setTranslateX(HALF_BLOCK_LENGTH);
        colourGroup2.get(NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO + 1)
                .setTranslateY(QUARTER_BLOCK_LENGTH);

        // Group 3 //
        colourGroup3.get(0).setTranslateY(QUARTER_BLOCK_LENGTH);
        colourGroup3.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        colourGroup3.get(1).setTranslateY(QUARTER_BLOCK_LENGTH);
    }
    /**
     * Populates a single block with coloured groups of sections.
     */
    private void createBlock() {
        createSections();
        translateSections();

        populateGroup(block, colourGroup1);
        populateGroup(block, colourGroup2);
        populateGroup(block, colourGroup3);
    }
    /**
     * Returns an unscaled block.
     * @return blk a Group
     */
    public Group getBlockUnscaled() {
        return block;
    }
    /**
     * Returns a block without scaling.
     * @return blk a Group
     */
    public Group getBlock() {
        Group blk = getBlockUnscaled();

        // fix block position based on scale factor of quilt
        blk.setScaleX(scaleFactor);
        blk.setScaleY(scaleFactor);
        double translateAmount = Math.abs(1 - scaleFactor) * HALF_BLOCK_LENGTH;
        if (scaleFactor < 1) {
            blk.setTranslateX(-translateAmount);
        } else {
            blk.setTranslateX(translateAmount);
        }

        return blk;
    }
    /**
     * Sets the colour of the sections in a block.
     * @param colour a Paint object
     * @param groupNumber an integer
     */
    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon polygon : colourGroup1) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon polygon : colourGroup2) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == NUMBER_OF_COLOUR_GROUPS_IN_HOURGLASS_BLOCK) {
            for (Polygon polygon : colourGroup3) {
                polygon.setFill(colour);
            }
        }
    }
}
