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
     * Rotational value of a 45 degree angle.
     */
    public static final int rotate45 = 45;
    /**
     * Rotational value of a 90 degree angle.
     */
    public static final int rotate90 = 90;
    /**
     * Rotational value of a 180 degree angle.
     */
    public static final int rotate180 = 180;
    /**
     * A fourth of the total block length.
     */
    public static final int oneFourthBlockLength = 25;
    /**
     * Half of the total block length.
     */
    public static final int halfBlockLength = 50;
    /**
     * Length of a block.
     */
    public static final int fullBlockLength = 100;

    private void createSections(){};
    private void blockColour(){};


    /**
     * Instantiates a 90 degree triangle.
     *
     * @return new Polygon a Polygon
     */
    public Polygon createTriangle() {
        return new Polygon(
                50, 0,
                0, 50,
                100, 50
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
                50, 50
        );
    }
    /**
     * Instantiates a parallelogram.
     *
     * @return  parallelogram a Rectangle
     */
    public Rectangle createParallelogram() {
        Rectangle parallelogram = new Rectangle(0, 0, 100, 50);

        Shear parallelogramPivot = new Shear();
        parallelogramPivot.setPivotY(45);
        parallelogram.getTransforms().add(parallelogramPivot);

        return parallelogram;
    }
}
