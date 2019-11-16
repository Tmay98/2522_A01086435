package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

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
    private ArrayList<Polygon> colourGroup3;
    private ArrayList<Polygon> colourGroup4;
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
            triangle.setFill(Color.BLUE);
            setScaleXY(triangle, QUARTER_TRIANGLE_RATIO);
            rescaleTriangleCoordinates(triangle);
            triangle.setRotate(RIGHT_ANGLE);
        }
        colourGroup1.get(2).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);

        // Group 2 //
        colourGroup2 = createTriangles(1);
        colourGroup2.get(0).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);
        setScaleXY(colourGroup2.get(0), QUARTER_TRIANGLE_RATIO);

        // Group 3 //
        colourGroup3 = createParallelograms(1);

        // Group 4 //
        colourGroup4 = createParallelograms(1);

    };

    /**
     * Rescales coordinates for triangles that have been rescaled.
     * @param triangle a Polygon
     */
    private void rescaleTriangleCoordinates(Polygon triangle) {
        triangle.setTranslateX(
                -(QUARTER_BLOCK_LENGTH
                        - QUARTER_BLOCK_LENGTH / 2.0));
        triangle.setTranslateY(-QUARTER_BLOCK_LENGTH / 2.0);
    }
    /**
     * Translates the sections in an twisted star block.
     */
    private void translateSections() {
        // Group 1 //
        colourGroup1.get(1).setTranslateX(QUARTER_BLOCK_LENGTH / 2.0);
        setTranslateXY(colourGroup1.get(2), QUARTER_BLOCK_LENGTH / 2.0);

        // Group 2 //
        setTranslateXY(colourGroup2.get(0), QUARTER_BLOCK_LENGTH);
        colourGroup2.get(0).setTranslateY(QUARTER_BLOCK_LENGTH / 2.0);
        colourGroup2.get(0).setTranslateX(-QUARTER_BLOCK_LENGTH / 2.0);

        // Group 4 //
        colourGroup4.get(0).setTranslateX(QUARTER_BLOCK_LENGTH);
    };
    /**
     * Populates a single block with coloured groups of sections.
     * @return a group of coloured sections a Group
     */
    private Group createBlockQuarters() {
        createSections();
        translateSections();
        Group quarterBlocks = new Group();

        populateGroup(quarterBlocks, colourGroup1);
        populateGroup(quarterBlocks, colourGroup2);
        populateGroup(quarterBlocks, colourGroup3);
        populateGroup(quarterBlocks, colourGroup4);

        return quarterBlocks;
    }
    /**
     * Populates a block with quarter sections.
     */
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

    /**
     * Returns the block.
     * @return block a Block
     */
    public Group getBlock() {
        return this.block;
    }

    private void blockColour() {};
}
