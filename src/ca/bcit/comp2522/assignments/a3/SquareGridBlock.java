package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;

/**
 * A quilt block with a colour alternating grid pattern.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class SquareGridBlock extends Block {
    /**
     * Number of geometrical sections sharing the same shape and colour.
     */
    private static final int NUMBER_OF_TRIANGLES_PER_SECTION = 4;

    private static final int NUM_ROWS = 4;

    private static final int NUM_COLS = 4;

    private static final int SQUARE_LENGTH = 25;

    private ArrayList<Rectangle> colourGroup1;
    private ArrayList<Rectangle> colourGroup2;
    private Group block;
    private double scaleFactor;

    /**
     * Instantiates an object of type PinwheelBlock.
     *
     * @param scaleFactor a double
     */
    public SquareGridBlock(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        block = new Group();
        createBlock();
    }

    /**
     * Creates the sections needed for the pinwheel block.
     */
    public void createSections() {
        //create group 1
        int currentBlockIndex = 0;
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = i % 2; j < NUM_COLS; j += 2) {
                colourGroup1.add(createSquare());
                colourGroup1.get(currentBlockIndex).setScaleX(0.5);
                colourGroup1.get(currentBlockIndex).setScaleY(0.5);
                colourGroup1.get(currentBlockIndex).setTranslateX(j * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
                colourGroup1.get(currentBlockIndex).setTranslateY(i * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
                colourGroup1.get(currentBlockIndex).setFill(Color.RED);
                currentBlockIndex++;
            }
        }

        //create group 2
        currentBlockIndex = 0;
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = (i + 1) % 2; j < NUM_COLS; j += 2) {
                colourGroup2.add(createSquare());
                colourGroup2.get(currentBlockIndex).setScaleX(0.5);
                colourGroup2.get(currentBlockIndex).setScaleY(0.5);
                colourGroup2.get(currentBlockIndex).setTranslateX(j * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
                colourGroup2.get(currentBlockIndex).setTranslateY(i * SQUARE_LENGTH - SQUARE_LENGTH / 2.0);
                currentBlockIndex++;
            }
        }
    }

    public void createBlock() {
        createSections();

        for (Rectangle rect : colourGroup1) {
            block.getChildren().add(rect);
        }

        for (Rectangle rect : colourGroup2) {
            block.getChildren().add(rect);
        }
    }

    public ArrayList<Rectangle> getColourGroup1() {
        return colourGroup1;
    }

    public ArrayList<Rectangle> getColourGroup2() {
        return colourGroup2;
    }

    /**
     * Returns the scaled block.
     *
     * @return blk
     */
    public Group getBlock() {
        Group blk = new Group();
        for (Rectangle rect : colourGroup1) {
            blk.getChildren().add(rect);
        }

        for (Rectangle rect : colourGroup2) {
            blk.getChildren().add(rect);
        }

        // fix block position based on scalefactor of quilt
        blk.setScaleX(scaleFactor);
        blk.setScaleY(scaleFactor);
        double translateAmount = Math.abs(1 - scaleFactor) * 50;
        if (scaleFactor < 1) {
            blk.setTranslateX(-translateAmount);
        } else {
            blk.setTranslateX(translateAmount);
        }

        return blk;
    }

    /**
     * Returns the block unscaled.
     *
     * @return blk
     */
    public Group getBlockUnscaled() {
        Group blk = new Group();
        for (Rectangle rect : colourGroup1) {
            blk.getChildren().add(rect);
        }

        for (Rectangle rect : colourGroup2) {
            blk.getChildren().add(rect);
        }

        return blk;
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
