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
    /**
     * Generates a block with a twisted star pattern.
     */
    public TwistedFourStarBlock() {
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        colourGroup4 = new ArrayList<>();

        block = new Group();

        createBlock();
    }
    /**
     * Generates the sections in a twisted star patterned block.
     */
    private void createSections() {
        // Group 1 //
        colourGroup1 = createTriangles(NUMBER_OF_TRIANGLES_IN_COLOUR_GROUP_ONE);
        for (Polygon triangle : colourGroup1) {
            setScaleXY(triangle, QUARTER_TRIANGLE_RATIO);
        }
        colourGroup1.get(2).setRotate(STRAIGHT_ANGLE);

        // Group 2 //
        colourGroup2 = createTriangles(1);
        colourGroup2.get(0).setRotate(STRAIGHT_ANGLE);
        setScaleXY(colourGroup2.get(0), QUARTER_TRIANGLE_RATIO);

        // Group 3 //
        colourGroup3 = createParallelograms(1);
        colourGroup3.get(0).setRotate(-HALF_RIGHT_ANGLE);
        setScaleXY(colourGroup3.get(0), HALF_RATIO);

        // Group 4 //
        colourGroup4 = createParallelograms(1);
        colourGroup4.get(0).setRotate(-HALF_RIGHT_ANGLE);
        setScaleXY(colourGroup4.get(0), HALF_RATIO);

    };

    private void translateSections() {
        // Group 1 //
        colourGroup1.get(1).setTranslateX(QUARTER_BLOCK_LENGTH);
        setTranslateXY(colourGroup1.get(2), QUARTER_BLOCK_LENGTH);

        // Group 2 //
        colourGroup2.get(0).setTranslateY(QUARTER_BLOCK_LENGTH);

        // Group 4 //
        colourGroup4.get(0).setTranslateX(QUARTER_BLOCK_LENGTH);
    };

    private Group createBlockQuarters() {
        createSections();
        translateSections();
        Group quarterBlock = new Group();

        populateGroup(quarterBlock, colourGroup1);
        populateGroup(quarterBlock, colourGroup2);
        populateGroup(quarterBlock, colourGroup3);
        populateGroup(quarterBlock, colourGroup4);

        quarterBlock.setTranslateX(HALF_BLOCK_LENGTH);
        return quarterBlock;
    }

    private void createBlock() {
        ArrayList<Group> quarterSections = new ArrayList<>();
        int quarterSectionRotation = 0;

        for (int i = 0; i < NUMBER_OF_QUARTERS_IN_BLOCK; i++) {
            Group quarterSection = createBlockQuarters();
            quarterSection.setRotate(quarterSectionRotation);
            quarterSectionRotation += RIGHT_ANGLE;
            quarterSections.add(quarterSection);
        }

        quarterSections.get(0).setTranslateX(HALF_BLOCK_LENGTH);
        quarterSections.get(1).setTranslateX(HALF_BLOCK_LENGTH);
        quarterSections.get(1).setTranslateY(HALF_BLOCK_LENGTH);
        quarterSections.get(2).setTranslateY(HALF_BLOCK_LENGTH);

        for (Group group : quarterSections) {
            block.getChildren().add(group);
        }
    };

    public Group getBlock() {
        return this.block;
    }

    private void blockColour() {};
}
