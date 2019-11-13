package ca.bcit.comp2522.assignments.a3;
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

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;

    private ArrayList<Polygon> createLargeTriangles(int numberOfTriangles) {
        ArrayList<Polygon> largeTriangles = new ArrayList<>();
        for (int i = 0; i < numberOfTriangles; i++) {
            Polygon triangle = createTriangle();
            largeTriangles.add(triangle);
        }
        return largeTriangles;
    }

    private void createSections() {
        ArrayList<Polygon> largeTriangles = createLargeTriangles(NUMBER_OF_LARGE_TRIANGLES);








        // Group 1 //
        Polygon groupOneLargeTriangle1 = createTriangle();
        groupOneLargeTriangle1.setTranslateX(HALF_BLOCK_LENGTH);

        Polygon groupOneLargeTriangle2 = createTriangle();
        groupOneLargeTriangle2.setTranslateY(HALF_BLOCK_LENGTH);
        groupOneLargeTriangle2.setRotate(STRAIGHT_ANGLE);

        Polygon groupOneSmallTriangle1 = createTriangle();
        setScaleXY(groupOneSmallTriangle1, HALF_RATIO);
        groupOneSmallTriangle1.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle1.setRotate(REFLEX_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle2 = createTriangle();
        setScaleXY(groupOneSmallTriangle2, HALF_RATIO);
        groupOneSmallTriangle2.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle2.setTranslateY(QUARTER_BLOCK_LENGTH);
        groupOneSmallTriangle2.setRotate(RIGHT_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle3 = createTriangle();
        setScaleXY(groupOneSmallTriangle3, HALF_RATIO);
        groupOneSmallTriangle3.setTranslateX(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle3.setTranslateY(HALF_BLOCK_LENGTH);
        groupOneSmallTriangle3.setRotate(REFLEX_ANGLE + HALF_RIGHT_ANGLE);

        Polygon groupOneSmallTriangle4 = createTriangle();
        setScaleXY(groupOneSmallTriangle4, HALF_RATIO);
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

        Polygon groupTwoSmallTriangle1 = createTriangle();
        setScaleXY(groupTwoLargeTriangle1, HALF_RATIO);


    };
    private void blockColour(String colourOne, String colourTwo, String colourThree){};
}
