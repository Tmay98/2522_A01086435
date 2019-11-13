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
    private static final int NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO = 2;

    private ArrayList<Polygon> colourGroup1 = new ArrayList<>();
    private ArrayList<Polygon> colourGroup2 = new ArrayList<>();;
    private ArrayList<Polygon> colourGroup3 = new ArrayList<>();;

    private Group block = new Group();

    public void createSections() {
        ArrayList<Polygon> largeTriangles = createTriangles(
                NUMBER_OF_LARGE_TRIANGLES);
        ArrayList<Polygon> smallTriangles = createTriangles(
                NUMBER_OF_SMALL_TRIANGLES);

        // Rotating large triangles //
        int largeTriangleRotation = 0;
        for (Polygon largeTriangle : largeTriangles) {
            largeTriangle.setRotate(largeTriangleRotation);
            largeTriangleRotation += RIGHT_ANGLE;

            // Adding large triangles to colour group //
            if (largeTriangles.indexOf(largeTriangle) % EVEN_NUMBER == 0) {
                colourGroup1.add(largeTriangle);
            } else {
                colourGroup2.add(largeTriangle);
            }
        }

        // Rotating small triangles //
        int smallTriangleRotation = HALF_RIGHT_ANGLE;
        for (Polygon smallTriangle : smallTriangles) {
            setScaleXY(smallTriangle, HALF_RATIO);
            smallTriangleRotation += RIGHT_ANGLE;
            smallTriangle.setRotate(smallTriangleRotation);

            if (smallTriangles.indexOf(smallTriangle) % EVEN_NUMBER != 0) {
                colourGroup1.add(smallTriangle);
            } else if (smallTriangles.indexOf(smallTriangle)
                    <= NUMBER_OF_SMALL_TRIANGLES_IN_SECTION_TWO) {
                colourGroup2.add(smallTriangle);
            } else {
                colourGroup3.add(smallTriangle);
            }
        }
        for (Polygon polygon : colourGroup1) {
            polygon.setFill(Color.RED);
        }

        translateSections(colourGroup1);
    };

    private void translateSections(
            ArrayList<Polygon> sectionList1) {

        // Group 1 //
        setTranslateXY(sectionList1.get(1), HALF_BLOCK_LENGTH);
            for (int i = 2; i < sectionList1.size(); i++) {
                sectionList1.get(i).setTranslateX(QUARTER_BLOCK_LENGTH);
            }
            sectionList1.get(3).setTranslateY(
                    HALF_BLOCK_LENGTH
                  + QUARTER_BLOCK_LENGTH);
            sectionList1.get(4).setTranslateY(QUARTER_BLOCK_LENGTH);
            sectionList1.get(5).setTranslateY(HALF_BLOCK_LENGTH);

    }

    public void createBlock() {
        populateGroup(block, colourGroup1);
        populateGroup(block, colourGroup2);
        populateGroup(block, colourGroup3);
    }



    private void blockColour(String colourOne, String colourTwo, String colourThree){};

    public Group getBlock() {
        return block;
    }
}
