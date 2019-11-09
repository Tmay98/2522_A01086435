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
        largeTriangle1.setTranslateX(halfBlockLength);

        Polygon largeTriangle2 = createTriangle();
        largeTriangle2.setTranslateY(50);
        largeTriangle2.setRotate(rotate180);

        // Group 2 //
        Polygon largeTriangle3 = createTriangle();
        largeTriangle3.setTranslateX(halfBlockLength);
        largeTriangle3.setTranslateY(halfBlockLength);
        largeTriangle3.setRotate(rotate90);



    };
    private void blockColour(String colourOne, String colourTwo, String colourThree){};
}
