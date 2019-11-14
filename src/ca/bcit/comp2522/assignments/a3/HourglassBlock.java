package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.paint.Color;
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
     * Number of large triangles in a Hourglass block.
     */
    private static final int NUMBER_OF_LARGE_TRIANGLES = 4;
    /**
     * Number of small triangles in a Hourglass block.
     */
    private static final int NUMBER_OF_SMALL_TRIANGLES = 8;
    /**
     * Number of small triangles in a colour section 2 in an Hourglass block.
     */
    private static final int NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_ONE = 4;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;
    private ArrayList<Polygon> colourGroup4;
    private Group block;

    /**
     * Generates a block with an hourglass pattern.
     */
    public HourglassBlock() {
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        colourGroup4 = new ArrayList<>();

        block = new Group();
        createSections();
        translateSections();
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
            if (largeTriangles.indexOf(largeTriangle) % EVEN_NUMBER != 0) {
                colourGroup1.add(largeTriangle);
            } else {
                colourGroup2.add(largeTriangle);
            }
        }

        int smallTriangleRotation = HALF_RIGHT_ANGLE;
        for (Polygon smallTriangle : smallTriangles) {
            // Rotating small triangles //
            setScaleXY(smallTriangle, TWO_THIRDS_RATIO);
            smallTriangleRotation += RIGHT_ANGLE;
            smallTriangle.setRotate(smallTriangleRotation);

            if (smallTriangles.indexOf(smallTriangle) % EVEN_NUMBER == 0) {
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
    };

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
        colourGroup1.get(4).setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup1.get(5).setTranslateY(HALF_BLOCK_LENGTH);

        // Group 2 large triangles //
        colourGroup2.get(0).setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup2.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        // Group 2 small triangles //
        colourGroup2.get(2).setTranslateY(QUARTER_BLOCK_LENGTH);
        colourGroup2.get(2).setTranslateX(HALF_BLOCK_LENGTH);
        colourGroup2.get(3).setTranslateY(QUARTER_BLOCK_LENGTH);

        // Group 3 //
        colourGroup3.get(0).setTranslateY(QUARTER_BLOCK_LENGTH);
        colourGroup3.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        colourGroup3.get(1).setTranslateY(QUARTER_BLOCK_LENGTH);
        }

    /**
     * Populates a single block with coloured groups of sections.
     */
    private void createBlock() {
        populateGroup(block, colourGroup1);
        populateGroup(block, colourGroup2);
        populateGroup(block, colourGroup3);
    }

    public void blockColour(
            String colourOne,
            String colourTwo,
            String colourThree) {
        Color groupOneColour = Color.web(colourOne, 1.0);
        Color groupTwoColour = Color.web(colourTwo, 1.0);
        Color groupThreeColour = Color.web(colourThree, 1.0);
    };

    /**
     * Returns the block.
     * @return block a Group
     */
    public Group getBlock() {
        return block;
    }
}
