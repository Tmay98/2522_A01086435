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

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;

    private Group block;


    public void createSections() {
        ArrayList<Polygon> largeTriangles = createTriangles(NUMBER_OF_LARGE_TRIANGLES);
        ArrayList<Polygon> smallTriangles = createTriangles(NUMBER_OF_SMALL_TRIANGLES);

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

        for (Polygon polygon : colourGroup1) {
            block.getChildren().add(polygon);
        }

        for (Polygon polygon : colourGroup2) {
            block.getChildren().add(polygon);
        }
    };


    private void blockColour(String colourOne, String colourTwo, String colourThree){};

    public Group getBlock() {
        return block;
    }
}
