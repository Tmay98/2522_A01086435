package ca.bcit.comp2522.assignments.a3;
import javafx.scene.shape.Polygon;

/**
 * A quilt block with a hourglass shaped pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class HourglassBlock extends Block {
    /**
     * Number of geometrical sections sharing the same shape and colour.
     */
    public static final int numberOfSections = 3;
    /**
     * Number of large triangles in a Hourglass patterned block.
     */
    public static final int numberOfLargeTrianglesPerGroup = 2;

    private void createSections() {
        int rotation = 0;
        int translationX = 50;
        int translationY = 0;

        // Group 1 of large triangles
        for (int i = 0; i < numberOfLargeTrianglesPerGroup; i ++) {
            Polygon largeTriangle = createTriangle();

        }

    };
    private void blockColour(String colourOne, String colourTwo, String colourThree){};
}
