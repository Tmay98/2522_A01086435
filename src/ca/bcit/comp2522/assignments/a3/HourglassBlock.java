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
        Polygon groupOneLargeTriangle1 = createTriangle();
        groupOneLargeTriangle1.setTranslateX(HALF_BLOCK_LENGTH);

        Polygon groupOneLargeTriangle2 = createTriangle();
        groupOneLargeTriangle2.setTranslateY(HALF_BLOCK_LENGTH);
        groupOneLargeTriangle2.setRotate(STRAIGHT_ANGLE);

        Polygon groupOneSmallTriangle1 = createTriangle();
        groupOneSmallTriangle1.setScaleX(HALF_RATIO);
        groupOneSmallTriangle1.setScaleY(HALF_RATIO);
        groupOneSmallTriangle1.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle1.setRotate(REFLEX_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle2 = createTriangle();
        groupOneSmallTriangle2.setScaleX(HALF_RATIO);
        groupOneSmallTriangle2.setScaleY(HALF_RATIO);
        groupOneSmallTriangle2.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle2.setTranslateY(QUARTER_BLOCK_LENGTH);
        groupOneSmallTriangle2.setRotate(RIGHT_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle3 = createTriangle();
        groupOneSmallTriangle3.setScaleX(HALF_RATIO);
        groupOneSmallTriangle3.setScaleY(HALF_RATIO);
        groupOneSmallTriangle3.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle3.setTranslateY(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle3.setRotate(REFLEX_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle4 = createTriangle();
        groupOneSmallTriangle4.setScaleX(HALF_RATIO);
        groupOneSmallTriangle4.setScaleY(HALF_RATIO);
        groupOneSmallTriangle4.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle4.setTranslateY(HALF_BLOCK_LENGTH + QUARTER_BLOCK_LENGTH);
        groupOneSmallTriangle4.setRotate(RIGHT_ANGLE + HALF_RIGHT_ANGLE);


        // Group 2 //
        Polygon groupTwoLargeTriangle1 = createTriangle();
        groupTwoLargeTriangle1.setTranslateX(HALF_BLOCK_LENGTH);
        groupTwoLargeTriangle1.setTranslateY(HALF_BLOCK_LENGTH);
        groupTwoLargeTriangle1.setRotate(RIGHT_ANGLE);

        Polygon groupTwoLargeTriangle2 = createTriangle();
        groupTwoLargeTriangle2.setRotate(REFLEX_ANGLE);

    };
    private void blockColour(String colourOne, String colourTwo, String colourThree){};
}
