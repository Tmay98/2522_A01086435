package ca.bcit.comp2522.assignments.a3;
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
    public static final int LARGE_TRIANGLES_IN_HOURGLASS_BLOCK = 4;
    /**
     * Number of small triangles in a hourglass block.
     */
    public static final int SMALL_TRIANGLES_IN_HOURGLASS_BLOCK = 8;
    /**
     * Number of colour groups in an hourglass block.
     */
    public static final int COLOUR_GROUPS_IN_HOURGLASS_BLOCK = 3;
    /**
     * Number of small triangles in colour section 1 in an hourglass block.
     */
    public static final int SMALL_TRIANGLES_IN_SECTION_ONE = 4;
    /**
     * Number of small triangles in colour section 2 in an hourglass block.
     */
    public static final int SMALL_TRIANGLES_IN_SECTION_TWO = 2;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;

    /**
     * Generates a block with an hourglass pattern.
     *
     * @param scaleFactor a double
     */
    public HourglassBlock(double scaleFactor) {
        super(scaleFactor);
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        createBlock();
    }
    /**
     * Returns colourGroup1.
     * @return colourGroup1 an ArrayList
     */
    public ArrayList<Polygon> getColourGroup1() {
        return colourGroup1;
    }
    /**
     * Returns colourGroup2.
     * @return colourGroup2 an ArrayList
     */
    public ArrayList<Polygon> getColourGroup2() {
        return colourGroup2;
    }
    /**
     * Returns colourGroup3.
     * @return colourGroup3 an ArrayList
     */
    public ArrayList<Polygon> getColourGroup3() {
        return colourGroup3;
    }
    /**
     * Generates the sections in an hourglass block.
     */
    private void createSections() {
        ArrayList<Polygon> largeTriangles = createTriangles(
                LARGE_TRIANGLES_IN_HOURGLASS_BLOCK);
        ArrayList<Polygon> smallTriangles = createTriangles(
                SMALL_TRIANGLES_IN_HOURGLASS_BLOCK);

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
                getColourGroup1().add(smallTriangle);
            } else if (smallTriangles.indexOf(smallTriangle)
                    <= SMALL_TRIANGLES_IN_SECTION_ONE) {
                getColourGroup2().add(smallTriangle);
            } else {
                getColourGroup3().add(smallTriangle);
            }
        }
        for (Polygon polygon : colourGroup1) {
            polygon.setFill(Color.RED);
        }
    }
    /**
     * Translates the sections in a hourglass block.
     */
    private void translateSections() {

        // Group 1 large triangles //
        setTranslateXY(getColourGroup1().get(1), HALF_BLOCK_LENGTH);
        // Group 1 small triangles //
        for (int i = 2; i < getColourGroup1().size(); i++) {
            getColourGroup1().get(i).setTranslateX(QUARTER_BLOCK_LENGTH);
        }
        getColourGroup1().get(SMALL_TRIANGLES_IN_SECTION_ONE)
                .setTranslateY(HALF_BLOCK_LENGTH);
        getColourGroup1().get(SMALL_TRIANGLES_IN_SECTION_ONE + 1)
                .setTranslateY(HALF_BLOCK_LENGTH);

        // Group 2 large triangles //
        getColourGroup2().get(0).setTranslateY(HALF_BLOCK_LENGTH);
        getColourGroup2().get(1).setTranslateX(HALF_BLOCK_LENGTH);
        // Group 2 small triangles //
        getColourGroup2().get(SMALL_TRIANGLES_IN_SECTION_TWO)
                .setTranslateY(QUARTER_BLOCK_LENGTH);
        getColourGroup2().get(SMALL_TRIANGLES_IN_SECTION_TWO)
                .setTranslateX(HALF_BLOCK_LENGTH);
        getColourGroup2().get(SMALL_TRIANGLES_IN_SECTION_TWO + 1)
                .setTranslateY(QUARTER_BLOCK_LENGTH);

        // Group 3 //
        getColourGroup3().get(0).setTranslateY(QUARTER_BLOCK_LENGTH);
        getColourGroup3().get(1).setTranslateX(HALF_BLOCK_LENGTH);
        getColourGroup3().get(1).setTranslateY(QUARTER_BLOCK_LENGTH);
    }
    /**
     * Populates a single block with coloured groups of sections.
     */
    private void createBlock() {
        createSections();
        translateSections();

        populateGroup(getBlock(), getColourGroup1());
        populateGroup(getBlock(), getColourGroup2());
        populateGroup(getBlock(), getColourGroup3());
    }
    /**
     * Sets the colour of the sections in a block.
     * @param colour a Paint object
     * @param groupNumber an int
     */
    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon polygon : getColourGroup1()) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon polygon : getColourGroup2()) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == COLOUR_GROUPS_IN_HOURGLASS_BLOCK) {
            for (Polygon polygon : getColourGroup3()) {
                polygon.setFill(colour);
            }
        }
    }
}
