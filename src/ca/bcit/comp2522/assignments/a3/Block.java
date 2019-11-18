package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.paint.Color;
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
    /**
     * The length of a square in a block.
     */
    public  static final int SQUARE_LENGTH = 25;
    /**
     * The value of an object scaled by half.
     */
    public static final double HALF_SCALE = 0.5;

    private Group block;
    private double scaleFactor;


    /**
     * Block constructor.
     *
     * @param scaleFactor a double
     */
    public Block(double scaleFactor) {
        this.block = new Group();
        this.scaleFactor = scaleFactor;
    }
    /**
     * Returns the scale factor of the block.
     * @return scaleFactor a double
     */
    public double getScaleFactor() {
        return scaleFactor;
    }
    /**
     * Returns the block Group.
     *
     * @return block
     */
    public Group getBlock() {
        return this.block;
    }

    /**
     * Selects a colour for a colour section.
     * @param paint a Paint object
     * @param group an int
     */
    public void blockColour(Paint paint, int group) { };
    /**
     * Returns an unscaled block.
     *
     * @return block a Group
     */
    Group getBlockUnscaled() {
        return block; }
    /**
     * Returns a scaled block.
     *
     * @return blk a Group
     */
    protected Group getBlockScaled() {
        Group blk = getBlockUnscaled();

        // fix block position based on scale factor of quilt
        blk.setScaleX(scaleFactor);
        blk.setScaleY(scaleFactor);
        double translateAmount = Math.abs(1 - scaleFactor) * HALF_BLOCK_LENGTH;
        if (scaleFactor < 1) {
            blk.setTranslateX(-translateAmount);
        } else {
            blk.setTranslateX(translateAmount);
        }

        return blk;
    }
    /**
     * Generates a 90 degree triangle.
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
     * Generates a square.
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
     * Generates a parallelogram.
     *
     * @return  parallelogram a Rectangle
     */
    private Polygon createParallelogram() {
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
     * Adds a scaled square to a group.
     * @param group a Group
     * @param i an int
     * @param j an int
     */
    protected void addNewSquare(ArrayList<Rectangle> group, int i, int j) {
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
    /**
     * Sets both of the X and Y scale by a given ratio.
     *
     * @param <T> a Shape
     * @param shape a Shape
     * @param ratio a Double
     */
    <T extends Shape> void setScaleXY(T shape, double ratio) {
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
