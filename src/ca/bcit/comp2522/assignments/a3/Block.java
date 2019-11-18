package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * A block of fabric in a quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class Block {
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
     * Ratio of half of a triangle.
     */
    public static final double HALF_TRIANGLE_RATIO = 0.707;
    /**
     * Ratio of quarter of a triangle.
     */
    public static final double QUARTER_TRIANGLE_RATIO = 0.49;

    public void blockColour(Paint paint, int group) { };

    public Group getBlock() {
        return new Group();
    }

    public Group getBlockUnscaled() {
        return new Group();
    }

    /**
     * Generates a 90 degree triangle.
     *
     * @return new Polygon a Polygon
     */
    protected Polygon createTriangle() {
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
     * Generates a square.
     *
     * @return  new rectangle a Rectangle
     */
    protected Rectangle createSquare() {
        return new Rectangle(
                0, 0,
                HALF_BLOCK_LENGTH, HALF_BLOCK_LENGTH
        );
    }
    /**
     * Generates a parallelogram.
     *
     * @return  parallelogram a Rectangle
     */
    protected Polygon createParallelogram() {
        return new Polygon(
                0,
                HALF_BLOCK_LENGTH,
                0,
                QUARTER_BLOCK_LENGTH,
                QUARTER_BLOCK_LENGTH,
                0,
                QUARTER_BLOCK_LENGTH,
                QUARTER_BLOCK_LENGTH
        );
    }
    /**
     * Generates a given number of triangles in an ArrayList.
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
     * Instantiates a given number of parallelograms in an ArrayList.
     *
     * @param numberOfParallelograms an int
     * @return an ArrayList of instantiated parallelograms an ArrayList
     */
    protected ArrayList<Polygon> createParallelograms(
            int numberOfParallelograms) {
        ArrayList<Polygon> parallelograms = new ArrayList<>();
        for (int i = 0; i < numberOfParallelograms; i++) {
            Polygon parallelogram = createParallelogram();
            parallelograms.add(parallelogram);
        }
        return parallelograms;
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
