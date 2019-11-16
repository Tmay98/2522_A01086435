package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * A quilt block with a twisted star pattern divided into four sections.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class TwistedFourStarBlock extends Block {
    /**
     * Number of times a similar pattern is repeated in a twisted star block.
     */
    private static final int NUMBER_OF_QUARTERS_IN_BLOCK = 4;
    /**
     * Number of small triangles in a single section of a twisted star block.
     */
    private static final int NUMBER_OF_TRIANGLES_IN_COLOUR_GROUP_ONE = 3;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Rectangle> colourGroup3;
    private ArrayList<Rectangle> colourGroup4;
    private Group block;
    private Group quarterBlock;
    /**
     * Generates a block with a twisted star pattern.
     */
    public TwistedFourStarBlock() {
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        colourGroup4 = new ArrayList<>();

        block = new Group();
        quarterBlock = new Group();
        createSections();
        translateSections();
        createBlock();
    }
    /**
     * Generates the sections in a twisted star patterned block.
     */
    private void createSections() {
        // Group 1 //
        colourGroup1 = createTriangles(NUMBER_OF_TRIANGLES_IN_COLOUR_GROUP_ONE);
        for (Polygon triangle : colourGroup1) {
            setScaleXY(triangle, HALF_TRIANGLE_RATIO);
        }
        colourGroup1.get(3).setRotate(STRAIGHT_ANGLE);

        // Group 2 //
        colourGroup2 = createTriangles(1);
        colourGroup2.get(0).setRotate(STRAIGHT_ANGLE);

        // Group 3 //
        colourGroup3 = createParallelograms(1);
        colourGroup3.get(0).setRotate(-HALF_RIGHT_ANGLE);

        // Group 4 //
        colourGroup4 = createParallelograms(1);
        colourGroup4.get(0).setRotate(-HALF_RIGHT_ANGLE);

    };
    private void translateSections() {
        // Group 1 //
        colourGroup1.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        setTranslateXY(colourGroup1.get(2), HALF_BLOCK_LENGTH);

        // Group 2 //
        colourGroup2.get(0).setTranslateY(HALF_BLOCK_LENGTH);

        // Group 4 //
        colourGroup4.get(0).setTranslateX(HALF_BLOCK_LENGTH);
    };

    private void createBlockQuarters() {
        populateGroup(quarterBlock, colourGroup1);
        populateGroup(quarterBlock, colourGroup2);
        populateGroup(quarterBlock, colourGroup3);
        populateGroup(quarterBlock, colourGroup4);
    }

    private void createBlock() {
        for (int i = 0; i < NUMBER_OF_QUARTERS_IN_BLOCK; i++) {
            createBlockQuarters();
        }

    };
    private void blockColour() {};
}
