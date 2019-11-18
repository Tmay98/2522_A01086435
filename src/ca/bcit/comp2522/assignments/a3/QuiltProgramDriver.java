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
        // testing

//        primaryStage.setTitle("T");
//        PinwheelBlock hblock = new PinwheelBlock();
//        Group test = hblock.getBlock();
//        Scene sc = new Scene(test, 800, 600);
//        primaryStage.setScene(sc);
//        primaryStage.show();

//        primaryStage.setTitle("T");
//        TwistedFourStarBlock hblock = new TwistedFourStarBlock(1);
//        Group test = hblock.getBlock();
//        Scene sc = new Scene(test, 800, 600);
//        primaryStage.setScene(sc);
//        primaryStage.show();

        // Create first scene
        QuiltProgram quiltProgram = new QuiltProgram(primaryStage);
        quiltProgram.getStage().setTitle("Quilt Program");
        quiltProgram.getStage().setScene(quiltProgram.getScenes().get(0));
        quiltProgram.getStage().show();
    }
}
