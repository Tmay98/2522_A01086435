package ca.bcit.comp2522.assignments.a3;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * A quilt block with a colour alternating grid pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class RandomSquareBlock extends Block {
    /**
     * Number of geometrical sections sharing the same shape and colour.
     */
    private static final int NUMBER_OF_TRIANGLES_PER_SECTION = 4;

    private static final int NUM_ROWS = 4;

    private static final int NUM_COLS = 4;

    private static final int SQUARE_LENGTH = 25;

    private static final double HALF_SCALE = 0.5;

    private ArrayList<Rectangle> colourGroup1;
    private ArrayList<Rectangle> colourGroup2;

    /**
     * Instantiates an object of type PinwheelBlock.
     *
     * @param scaleFactor a double
     */
    public RandomSquareBlock(double scaleFactor) {
        super(scaleFactor);
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        createBlock();
    }

    /**
     * Creates the sections needed for the pinwheel block.
     */
    private void createSections() {
        //create group 1
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j += 2) {
                addNewSquare(colourGroup1, i, j);
            }
        }
        //create group 2
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 1; j < NUM_COLS; j += 2) {
                addNewSquare(colourGroup2, i, j);
            }
        }
    }

    private void addNewSquare(ArrayList<Rectangle> group, int i, int j) {
        Rectangle square = createSquare();
        square.setScaleX(HALF_SCALE);
        square.setScaleY(HALF_SCALE);
        square.setTranslateX(
                j * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
        square.setTranslateY(
                i * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
        square.setFill(Color.RED);
        group.add(square);
    }

    private void createBlock() {
        createSections();

        for (Rectangle rect : colourGroup1) {
            getBlock().getChildren().add(rect);
        }

        for (Rectangle rect : colourGroup2) {
            getBlock().getChildren().add(rect);
        }
    }

    /**
     * Colours colourgroup of given number to the given paint.
     *
     * @param colour a Paint
     * @param groupNumber a groupNumber
     */
    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Rectangle rect : colourGroup1) {
                rect.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Rectangle rect : colourGroup2) {
                rect.setFill(colour);
            }
        }
    }

}
