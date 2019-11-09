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
