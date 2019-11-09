package ca.bcit.comp2522.assignments.a3;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Program to generate a quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */

public class QuiltProgram extends Application {
    private Quilt quilt;
    private Scene scene;

    public void start(Stage primaryStage) {
        Section section = new Section();
        PinwheelBlock test = new PinwheelBlock();
        test.createSections();
        test.createBlock();
        Rectangle ground = new Rectangle(0, 250, 500, 100);
        ground.setFill(Color.BURLYWOOD);

        // creating root
        Group root = new Group(test.getBlock());
        Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);

        primaryStage.setTitle("Tommy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
