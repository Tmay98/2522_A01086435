package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

    private ArrayList<Polygon> tempGroup1;
    private ArrayList<Polygon> tempGroup2;
    private ArrayList<Polygon> tempGroup3;
    private ArrayList<Polygon> tempGroup4;
    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;
    private ArrayList<Polygon> colourGroup4;
    private ArrayList<Group> quarterSections;
    private Group block;
    private double scaleFactor;

    /**
     * Generates a block with a twisted star pattern.
     */
    public TwistedFourStarBlock(double scaleFactor) {
        quarterSections = new ArrayList<>();
        tempGroup1 = new ArrayList<>();
        tempGroup2 = new ArrayList<>();
        tempGroup3 = new ArrayList<>();
        tempGroup4 = new ArrayList<>();

        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        colourGroup4 = new ArrayList<>();
        this.scaleFactor = scaleFactor;
        block = new Group();

        createBlock();
    }
    /**
     * Generates the sections in a twisted star patterned block.
     */
    private void createSections() {
        // Group 1 //
        tempGroup1 = createTriangles(NUMBER_OF_TRIANGLES_IN_COLOUR_GROUP_ONE);
        for (Polygon triangle : tempGroup1) {
            triangle.setFill(Color.BLUE);
            setScaleXY(triangle, QUARTER_TRIANGLE_RATIO);
            rescaleTriangleCoordinates(triangle);
            triangle.setRotate(RIGHT_ANGLE);
        }
        tempGroup1.get(2).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);

        // Group 2 //
        tempGroup2 = createTriangles(1);
        tempGroup2.get(0).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);
        setScaleXY(tempGroup2.get(0), QUARTER_TRIANGLE_RATIO);

        // Group 3 //
        tempGroup3 = createParallelograms(1);

        // Group 4 //
        tempGroup4 = createParallelograms(1);

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
        tempGroup1.get(1).setTranslateX(QUARTER_BLOCK_LENGTH / 2.0);
        setTranslateXY(tempGroup1.get(2), QUARTER_BLOCK_LENGTH / 2.0);

        // Group 2 //
        setTranslateXY(tempGroup2.get(0), QUARTER_BLOCK_LENGTH);
        tempGroup2.get(0).setTranslateY(QUARTER_BLOCK_LENGTH / 2.0);
        tempGroup2.get(0).setTranslateX(-QUARTER_BLOCK_LENGTH / 2.0);

        // Group 4 //
        tempGroup4.get(0).setTranslateX(QUARTER_BLOCK_LENGTH);
    };

    /**
     * Populates a single block with coloured groups of sections.
     *
     * @return a group of coloured sections a Group
     */
    private Group createBlockQuarters() {
        createSections();
        translateSections();
        Group quarterBlocks = new Group();

        populateGroup(quarterBlocks, tempGroup1);
        populateGroup(quarterBlocks, tempGroup2);
        populateGroup(quarterBlocks, tempGroup3);
        populateGroup(quarterBlocks, tempGroup4);

        for (Polygon poly : tempGroup1) {
            colourGroup1.add(poly);
        }
        for (Polygon poly : tempGroup2) {
            colourGroup2.add(poly);
        }
        for (Polygon poly : tempGroup3) {
            colourGroup3.add(poly);
        }
        for (Polygon poly : tempGroup4) {
            colourGroup4.add(poly);
        }

        return quarterBlocks;
    }

    /**
     * Populates a block with quarter sections.
     */
    private void createBlock() {
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
     * Returns the scaled block.
     *
     * @return blk
     */
    public Group getBlock() {

        // fix block position based on scalefactor of quilt
        this.block.setScaleX(scaleFactor);
        this.block.setScaleY(scaleFactor);
        double translateAmount = Math.abs(1 - scaleFactor) * 50;
        if (scaleFactor < 1) {
            this.block.setTranslateX(-translateAmount);
        } else {
            this.block.setTranslateX(translateAmount);
        }

        return this.block;
    }

    /**
     * Returns the block unscaled.
     *
     * @return blk
     */
    public Group getBlockUnscaled() {
        return this.block;
    }


    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon poly : colourGroup2) {
                poly.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon poly : colourGroup2) {
                poly.setFill(colour);
            }
        } else if (groupNumber == 3) {
            for (Polygon poly : colourGroup3) {
                poly.setFill(colour);
            }
        } else if (groupNumber == 4) {
            for (Polygon poly : colourGroup4) {
                poly.setFill(colour);
            }
        }
    }
}
