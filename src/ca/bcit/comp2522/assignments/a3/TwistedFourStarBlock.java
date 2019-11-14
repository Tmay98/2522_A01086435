package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * A quilt block with a twisted star pattern divided into four sections.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class TwistedFourStarBlock extends Block {
    /**
     * Number of small triangles in a twisted star block.
     */
    private static final int NUMBER_OF_TRIANGLES = 16;
    /**
     * Number of parallelograms in a twisted star block.
     */
    private static final int NUMBER_OF_PARALLELOGRAMS = 8;

    private ArrayList<Polygon> colourGroup1;
    private ArrayList<Polygon> colourGroup2;
    private ArrayList<Polygon> colourGroup3;
    private Group block;
    /**
     * Generates a block with a twisted star pattern.
     */
    public TwistedFourStarBlock() {
        colourGroup1 = new ArrayList<>();
        colourGroup2 = new ArrayList<>();
        colourGroup3 = new ArrayList<>();

        block = new Group();
        createSections();
        translateSections();
        createBlock();
    }
    /**
     * Generates the sections in a twisted star patterned block.
     */
    private void createSections() {


    };
    private void translateSections() {};
    private void createBlock(){};
    private void blockColour() {};
}
