package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
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

    private Group block;

    private void createSections() {
        ArrayList<Polygon> largeTriangles = createTriangles(
                NUMBER_OF_LARGE_TRIANGLES);
        ArrayList<Polygon> smallTriangles = createTriangles(
                NUMBER_OF_SMALL_TRIANGLES);

        // Rotating large triangles //
        int largeTriangleRotation = 0;
        for (Polygon largeTriangle : largeTriangles) {
            largeTriangleRotation += RIGHT_ANGLE;
            largeTriangle.setRotate(largeTriangleRotation);

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
    };

    private void translateSections() {

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
