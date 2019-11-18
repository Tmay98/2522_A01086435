package ca.bcit.comp2522.assignments.a3;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * A quilt block with a colour alternating grid pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class SquareGridBlock extends Block {
    /**
     * Number of rows in a random square block.
     */
    public static final int NUM_ROWS = 4;
    /**
     * Number of columns in a random square block.
     */
    public static final int NUM_COLS = 4;

    private ArrayList<Rectangle> colourGroup1;
    private ArrayList<Rectangle> colourGroup2;

    /**
     * Returns colourGroup1.
     *
     * @return colourGroup1
     */
    public ArrayList<Rectangle> getColourGroup1() {
        return colourGroup1;
    }

    /**
     * Returns colourGroup2.
     *
     * @return colourGroup2
     */
    public ArrayList<Rectangle> getColourGroup2() {
        return colourGroup2;
    }

    /**
     * Instantiates an object of type SquareGridBlock.
     *
     * @param scaleFactor a double
     */
    public SquareGridBlock(double scaleFactor) {
        super(scaleFactor);
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        createBlock();
    }
    /**
     * Creates the sections needed for the square grid block.
     */
    private void createSections() {
        //create group 1
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = i % 2; j < NUM_COLS; j += 2) {
                addNewSquare(getColourGroup1(), i, j);
            }
        }
        //create group 2
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = (i + 1) % 2; j < NUM_COLS; j += 2) {
                addNewSquare(getColourGroup2(), i, j);
            }
        }
    }
    /**
     * Creates a square grid block.
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
            for (Rectangle rect : getColourGroup1()) {
                rect.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Rectangle rect : getColourGroup2()) {
                rect.setFill(colour);
            }
        }
    }

}
