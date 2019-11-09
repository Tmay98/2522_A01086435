package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
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
    private ArrayList<Polygon> colourGroup1 = new ArrayList<>();
    private ArrayList<Polygon> colourGroup2 = new ArrayList<>();
    private Group block = new Group();

    public void createSections() {
        //create group 1
        Section section = new Section();
        Polygon poly = section.createtriangle();
        colourGroup1.add(poly);
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
