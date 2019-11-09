package ca.bcit.comp2522.assignments.a3;
import javafx.scene.Group;

/**
 * A geometrical section in a block.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class Section {
    private String colour;

    private Polygon triangle = new Polygon(
            0, 0,
            60, 60,
            20, 40,
    );

    private Rectangle rectangle = new Rectangle(
            0, 0,
            40, 40,
    );

    

    private void setColour(String colour){};
}
