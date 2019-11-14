package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Shear;

import java.util.ArrayList;

/**
 * A block of fabric in a quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class Block {
    /**
     * Value of a number used to check for even numbers in a modulo operation.
     */
    public static final int EVEN_NUMBER = 2;
    /**
     * Rotational value of half of a right angle.
     */
    public static final int HALF_RIGHT_ANGLE = 45;
    /**
     * Rotational value of a right angle.
     */
    public static final int RIGHT_ANGLE = 90;
    /**
     * Rotational value of a straight angle.
     */
    public static final int STRAIGHT_ANGLE = 180;
    /**
     * Rotational value of a reflex angle.
     */
    public static final int REFLEX_ANGLE = 270;
    /**
     * A fourth of the total block length.
     */
    public static final int QUARTER_BLOCK_LENGTH = 25;
    /**
     * Half of the total block length.
     */
    public static final int HALF_BLOCK_LENGTH = 50;
    /**
     * Length of a block.
     */
    public static final int FULL_BLOCK_LENGTH = 100;    /**
     * Two-thirds of a full ratio..
     */
    public static final double TWO_THIRDS_RATIO = 0.70;
    /**
     * Half of a full ratio.
     */
    public static final double HALF_RATIO = 0.50;
    /**
     * Quarter of a full ratio.
     */
    public static final double QUARTER_RATIO = 0.25;

    private void createSections() { };
    private void blockColour() { };
    private void createBlock() { };
    private void translateSections() { };

    /**
     * Instantiates a 90 degree triangle.
     *
     * @return new Polygon a Polygon
     */
    public Polygon createTriangle() {
        return new Polygon(
                0,
                0,
                0,
                HALF_BLOCK_LENGTH,
                HALF_BLOCK_LENGTH,
                HALF_BLOCK_LENGTH
        );
    }
    /**
     * Instantiates a square.
     *
     * @return  new rectangle a Rectangle
     */
    public Rectangle createSquare() {
        return new Rectangle(
                0, 0,
                HALF_BLOCK_LENGTH, HALF_BLOCK_LENGTH
        );
    }
    /**
     * Instantiates a parallelogram.
     *
     * @return  parallelogram a Rectangle
     */
    public Rectangle createParallelogram() {
        Rectangle parallelogram = new Rectangle(
                0,
                0,
                FULL_BLOCK_LENGTH,
                HALF_BLOCK_LENGTH);

        Shear parallelogramPivot = new Shear();
        parallelogramPivot.setPivotY(HALF_RIGHT_ANGLE);
        parallelogram.getTransforms().add(parallelogramPivot);

        return parallelogram;
    }

    /**
     * Instantiates a given number of triangles in an ArrayList.
     *
     * @param numberOfTriangles an int
     * @return an ArrayList of instantiated triangles an ArrayList
     */
    protected ArrayList<Polygon> createTriangles(int numberOfTriangles) {
        ArrayList<Polygon> triangles = new ArrayList<>();
        for (int i = 0; i < numberOfTriangles; i++) {
            Polygon triangle = createTriangle();
            triangles.add(triangle);
        }
        return triangles;
    }

    /**
     * Sets both of the X and Y scale by a given ratio.
     *
     * @param <T> a Shape
     * @param shape a Shape
     * @param ratio a Double
     */
    protected <T extends Shape> void setScaleXY(T shape, double ratio) {
        shape.setScaleX(ratio);
        shape.setScaleY(ratio);
    }

    /**
     * Translates the shape by X and Y by a given ratio.
     *
     * @param <T> a Shape
     * @param shape a Shape
     * @param ratio a Double
     */
    protected <T extends Shape> void setTranslateXY(T shape, double ratio) {
        shape.setTranslateX(ratio);
        shape.setTranslateY(ratio);
    }

    /**
     * Populates a Group with members of an ArrayList.
     *
     * @param group a Group
     * @param list an ArrayList
     * @param <T> a Shape
     */
    protected <T extends Shape> void populateGroup(
            Group group,
            ArrayList<T> list) {
        for (T shape : list) {
            group.getChildren().add(shape);
        }
    }
}
