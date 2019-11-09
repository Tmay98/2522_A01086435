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

    private void createSections() {
        // Group 1 //
        Polygon largeTriangle1 = createTriangle();
        largeTriangle1.setTranslateX(HALF_BLOCK_LENGTH);

        Polygon largeTriangle2 = createTriangle();
        largeTriangle2.setTranslateY(HALF_BLOCK_LENGTH);
        largeTriangle2.setRotate(STRAIGHT_ANGLE);

        // Group 2 //
        Polygon largeTriangle3 = createTriangle();
        largeTriangle3.setTranslateX(HALF_BLOCK_LENGTH);
        largeTriangle3.setTranslateY(HALF_BLOCK_LENGTH);
        largeTriangle3.setRotate(RIGHT_ANGLE);



    };
    private void blockColour(String colourOne, String colourTwo, String colourThree){};
}
