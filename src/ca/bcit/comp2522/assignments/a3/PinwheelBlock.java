package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
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
    private static final int NUMBER_OF_TRIANGLES_PER_SECTION = 4;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private Group block;

    /**
     * Instantiates an object of type PinwheelBlock.
     */
    public PinwheelBlock() {
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        block = new Group();
        createSections();
        createBlock();
    }

    /**
     * Creates the sections needed for the pinwheel block.
     */
    private void createSections() {
        //create group 1
        for (int i = 0; i < NUMBER_OF_TRIANGLES_PER_SECTION; i++) {
            colourGroup1.add(createTriangle());
        }

        //create group 2
        for (int i = 0; i < NUMBER_OF_TRIANGLES_PER_SECTION; i++) {
            colourGroup2.add(createTriangle());
            colourGroup2.get(i).setScaleX(-1);
            colourGroup2.get(i).setScaleY(-1);
            colourGroup2.get(i).setFill(Color.RED);
        }

        translateSections(colourGroup1);
        translateSections(colourGroup2);

    }

    private void translateSections(ArrayList<Polygon> colourGroup) {
        colourGroup.get(1).setRotate(RIGHT_ANGLE);
        colourGroup.get(1).setTranslateX(HALF_BLOCK_LENGTH);

        colourGroup.get(2).setRotate(STRAIGHT_ANGLE);
        colourGroup.get(2).setTranslateY(HALF_BLOCK_LENGTH);
        colourGroup.get(2).setTranslateX(HALF_BLOCK_LENGTH);

        colourGroup.get(3).setRotate(REFLEX_ANGLE);
        colourGroup.get(3).setTranslateY(HALF_BLOCK_LENGTH);
    }

    public void createBlock() {
        for (Polygon polygon : colourGroup1) {
            block.getChildren().add(polygon);
        }

        for (Polygon polygon : colourGroup2) {
            block.getChildren().add(polygon);
        }
    }

    public ArrayList<Polygon> getColourGroup1() {
       return colourGroup1;
    }

    public ArrayList<Polygon> getColourGroup2() {
        return colourGroup1;
    }

    public Group getBlock() {
        return block;
    }

    public void blockColour(Paint colour, int groupNumber) {
        if (groupNumber == 1) {
            for (Polygon polygon : colourGroup1) {
                polygon.setFill(colour);
            }
        } else if (groupNumber == 2) {
            for (Polygon polygon : colourGroup2) {
                polygon.setFill(colour);
            }
        }
    }
}
