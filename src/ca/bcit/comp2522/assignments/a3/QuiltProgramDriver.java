package ca.bcit.comp2522.assignments.a3;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Quilt Program Driver.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */
public class QuiltProgramDriver extends Application {

    public void start(Stage primaryStage) {
        // Create first scene
        QuiltProgram quiltProgram = new QuiltProgram(primaryStage);
        quiltProgram.getStage().setTitle("Quilt Program");
        quiltProgram.getStage().setScene(quiltProgram.getScenes().get(0));
        quiltProgram.getStage().show();
    }
}
