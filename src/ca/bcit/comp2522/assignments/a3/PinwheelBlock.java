package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
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
    public static final int numberOfSections = 2;
    public static final int polygonsInSection = 4;

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
    public void createSections() {
        //create group 1
        for(int i = 0; i < polygonsInSection; i++) {
            colourGroup1.add(createTriangle());
        }

        //create group 2
        for (int i = 0; i < polygonsInSection; i++) {
            colourGroup2.add(createTriangle());
            colourGroup2.get(i).setScaleX(-1);
            colourGroup2.get(i).setScaleY(-1);
            colourGroup2.get(i).setFill(Color.RED);
        }

        setColourGroup(colourGroup1);
        setColourGroup(colourGroup2);

    }

    private void setColourGroup(ArrayList<Polygon> colourGroup) {
        colourGroup.get(1).setRotate(90);
        colourGroup.get(1).setTranslateX(50);

        colourGroup.get(2).setRotate(180);
        colourGroup.get(2).setTranslateY(50);
        colourGroup.get(2).setTranslateX(50);

        colourGroup.get(3).setRotate(270);
        colourGroup.get(3).setTranslateY(50);
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

    private void blockColour(String colourOne, String colourTwo){};

}
