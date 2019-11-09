package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * A geometrical section in a block.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class Section {
    private String colour;

    public Polygon createtriangle() {
        return new Polygon(
                50, 0,
                0, 50,
                100, 50
        );
    }

    private Rectangle rectangle = new Rectangle(
            0, 0,
            40, 40
    );

    

    private void setColour(String colour){};
}
