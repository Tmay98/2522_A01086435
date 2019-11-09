package ca.bcit.comp2522.assignments.a3;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;

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
    public static final int ONE_FOURTH_BLOCK = 25;
    /**
     * Half of the total block length.
     */
    public static final int HALF_BLOCK_LENGTH = 50;
    /**
     * Length of a block.
     */
    public static final int FULL_BLOCK_LENGTH = 100;

    private void createSections(){};
    private void blockColour(){};


    /**
     * Instantiates a 90 degree triangle.
     *
     * @return new Polygon a Polygon
     */
    public Polygon createTriangle() {
        return new Polygon(
                HALF_BLOCK_LENGTH, 0,
                0, HALF_BLOCK_LENGTH,
                FULL_BLOCK_LENGTH, HALF_BLOCK_LENGTH
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
        Rectangle parallelogram = new Rectangle(0, 0, FULL_BLOCK_LENGTH, HALF_BLOCK_LENGTH);

        Shear parallelogramPivot = new Shear();
        parallelogramPivot.setPivotY(HALF_RIGHT_ANGLE);
        parallelogram.getTransforms().add(parallelogramPivot);

        return parallelogram;
    }
}
