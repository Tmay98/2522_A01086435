package ca.bcit.comp2522.assignments.a3;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

/**
 * A quilt block with a pinwheel shaped pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class PinwheelBlock extends Block {
    /**
     * Number of geometrical sections sharing the same shape and colour.
     */
    public static final int TRIANGLES_PER_SECTION = 4;
    /**
     * Number of triangles per section that require rotation.
     */
    public static final int TRIANGLES_TO_ROTATE_PER_SECTION = 3;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;

    /**
     * Instantiates an object of type PinwheelBlock.
     *
     * @param scaleFactor a double
     */
    public PinwheelBlock(double scaleFactor) {
        super(scaleFactor);
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        createBlock();
    }
    /**
     * Returns colourGroup1.
     * @return colourGroup1 an ArrayList
     */
    public ArrayList<Polygon> getColourGroup1() {
        return colourGroup1;
    }
    /**
     * Returns colourGroup2.
     * @return colourGroup2 an ArrayList
     */
    public ArrayList<Polygon> getColourGroup2() {
        return colourGroup2;
    }
    /**
     * Generates the sections needed for the pinwheel block.
     */
    private void createSections() {
        //create group 1
        for (int i = 0; i < TRIANGLES_PER_SECTION; i++) {
            getColourGroup1().add(createTriangle());
        }

        //create group 2
        for (int i = 0; i < TRIANGLES_PER_SECTION; i++) {
            getColourGroup2().add(createTriangle());
            getColourGroup2().get(i).setScaleX(-1);
            getColourGroup2().get(i).setScaleY(-1);
            getColourGroup2().get(i).setFill(Color.RED);
        }

        translateSections(getColourGroup1());
        translateSections(getColourGroup2());

    }
    /**
     * Translates the sections in a pinwheel block.
     *
     * @param colourGroup an ArrayList
     */
    private void translateSections(ArrayList<Polygon> colourGroup) {
        colourGroup.get(1).setRotate(RIGHT_ANGLE);
        colourGroup.get(1).setTranslateX(HALF_BLOCK_LENGTH);

        colourGroup.get(2).setRotate(STRAIGHT_ANGLE);
        colourGroup.get(2).setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup.get(2).setTranslateX(HALF_BLOCK_LENGTH);

        colourGroup.get(TRIANGLES_TO_ROTATE_PER_SECTION)
                .setRotate(REFLEX_ANGLE);
        colourGroup.get(TRIANGLES_TO_ROTATE_PER_SECTION)
                .setTranslateY(HALF_BLOCK_LENGTH);
    }
    /**
     * Populates a single block with coloured groups of sections.
     */
    private void createBlock() {
        createSections();

        populateGroup(getBlock(), getColourGroup1());
        populateGroup(getBlock(), getColourGroup2());
    }
    /**
     * Sets the colour of the sections in a block.
     * @param colour a Paint object
     * @param groupNumber an int
     */
    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon polygon : getColourGroup1()) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon polygon : getColourGroup2()) {
                polygon.setFill(colour);
            }
        }
    }
}
