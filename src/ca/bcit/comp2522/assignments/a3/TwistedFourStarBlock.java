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
    public static final int QUARTERS_IN_BLOCK = 4;
    /**
     * Number of small triangles in a single section of a twisted star block.
     */
    public static final int TRIANGLES_IN_COLOUR_GROUP_ONE = 3;
    /**
     * Number of parallelograms per quarter section of a twisted star block.
     */
    public static final int PARALLELOGRAMS_IN_QUARTER_SECTION = 1;
    /**
     * Number of coloured sections in a twisted star block
     */
    public static final int COLOUR_GROUPS_IN_BLOCK = 4;

    private ArrayList<Group> quarterSections;

    private ArrayList<Polygon> quarterSection1;
    private ArrayList<Polygon> quarterSection2;
    private ArrayList<Polygon> quarterSection3;
    private ArrayList<Polygon> quarterSection4;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;
    private ArrayList<Polygon> colourGroup4;

    /**
     * Generates a block with a twisted star pattern.
     *
     * @param scaleFactor a double
     */
    public TwistedFourStarBlock(double scaleFactor) {
        super(scaleFactor);
        quarterSections = new ArrayList<>();
        quarterSection1 = new ArrayList<>();
        quarterSection2 = new ArrayList<>();
        quarterSection3 = new ArrayList<>();
        quarterSection4 = new ArrayList<>();

        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();
        colourGroup4 = new ArrayList<>();

        createBlock();
    }

    /**
     * Returns colourGroup1.
     *
     * @return colourGroup1
     */
    public ArrayList<Polygon> getColourGroup1() {
        return colourGroup1;
    }

    /**
     * Returns colourGroup2.
     *
     * @return colourGroup2
     */
    public ArrayList<Polygon> getColourGroup2() {
        return colourGroup2;
    }

    /**
     * Returns colourGroup3.
     *
     * @return colourGroup3
     */
    public ArrayList<Polygon> getColourGroup3() {
        return colourGroup3;
    }

    /**
     * Returns colourGroup4.
     *
     * @return colourGroup4
     */
    public ArrayList<Polygon> getColourGroup4() {
        return colourGroup4;
    }

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
     * Generates the sections in a twisted star patterned block.
     */
    private void createSections() {
        // Group 1 //
        quarterSection1 = createTriangles(TRIANGLES_IN_COLOUR_GROUP_ONE);
        for (Polygon triangle : quarterSection1) {
            triangle.setFill(Color.BLUE);
            setScaleXY(triangle, QUARTER_TRIANGLE_RATIO);
            rescaleTriangleCoordinates(triangle);
            triangle.setRotate(RIGHT_ANGLE);
        }
        quarterSection1.get(2).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);

        // Group 2 //
        quarterSection2 = createTriangles(1);
        quarterSection2.get(0).setRotate(STRAIGHT_ANGLE + RIGHT_ANGLE);
        setScaleXY(quarterSection2.get(0), QUARTER_TRIANGLE_RATIO);

        // Group 3 //
        quarterSection3 = createParallelograms(PARALLELOGRAMS_IN_QUARTER_SECTION);

        // Group 4 //
        quarterSection4 = createParallelograms(PARALLELOGRAMS_IN_QUARTER_SECTION);

    }

    /**
     * Translates the sections in an twisted star block.
     */
    private void translateSections() {
        // Group 1 //
        quarterSection1.get(1).setTranslateX(QUARTER_BLOCK_LENGTH / 2.0);
        setTranslateXY(quarterSection1.get(2), QUARTER_BLOCK_LENGTH / 2.0);

        // Group 2 //
        setTranslateXY(quarterSection2.get(0), QUARTER_BLOCK_LENGTH);
        quarterSection2.get(0).setTranslateY(QUARTER_BLOCK_LENGTH / 2.0);
        quarterSection2.get(0).setTranslateX(-QUARTER_BLOCK_LENGTH / 2.0);

        // Group 4 //
        quarterSection4.get(0).setTranslateX(QUARTER_BLOCK_LENGTH);
    }

    /**
     * Populates a single block with coloured groups of sections.
     *
     * @return a group of coloured sections a Group
     */
    private Group createBlockQuarters() {
        createSections();
        translateSections();
        Group quarterBlocks = new Group();

        populateGroup(quarterBlocks, quarterSection1);
        populateGroup(quarterBlocks, quarterSection2);
        populateGroup(quarterBlocks, quarterSection3);
        populateGroup(quarterBlocks, quarterSection4);

        colourGroup1.addAll(quarterSection1);
        colourGroup2.addAll(quarterSection2);
        colourGroup3.addAll(quarterSection3);
        colourGroup4.addAll(quarterSection4);

        return quarterBlocks;
    }

    /**
     * Populates a block with quarter sections.
     */
    private void createBlock() {
        int quarterSectionRotation = 0;

        for (int i = 0; i < QUARTERS_IN_BLOCK; i++) {
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
            getBlock().getChildren().add(group);
        }
    }
    /**
     * Sets the colour of the sections in a block.
     * @param colour a Paint object
     * @param groupNumber an int
     */
    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon poly : getColourGroup1()) {
                poly.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon poly : getColourGroup2()) {
                poly.setFill(colour);
            }
        } else if (groupNumber == COLOUR_GROUPS_IN_BLOCK - 1) {
            for (Polygon poly : getColourGroup3()) {
                poly.setFill(colour);
            }
        } else if (groupNumber == COLOUR_GROUPS_IN_BLOCK) {
            for (Polygon poly : getColourGroup4()) {
                poly.setFill(colour);
            }
        }
    }
}
