package ca.bcit.comp2522.assignments.a3;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Program to generate a quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */
public class QuiltProgram {
    private Quilt quilt;
    private ArrayList<Scene> scenes;
    private int blockSize;
    private Stage stage;

    /**
     * Constructs an object of type QuiltProgram.
     *
     * @param stage a Stage
     */
    public QuiltProgram(Stage stage) {
        this.blockSize = 0;
        this.quilt = new Quilt();
        this.stage = stage;
        this.scenes = new ArrayList<>();
        createSceneOne();
        createSceneTwo();
    }

    /**
     * Returns the stage.
     *
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * returns the scenes ArrayList.
     *
     * @return scenes
     */
    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    /**
     * Creates the first scene and adds it to the scenes ArrayList.
     */
    private void createSceneOne() {
        Text title = new Text("Quilt settings");
        title.setFont(Font.font(30));
        title.setFill(Color.RED);
        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");

        // create radio buttons
        VBox buttons = createRadioButtonGroup();

        // create spinners
        VBox spinners = createIntegerSpinnersGroup();

        // add selector controls to vbox
        VBox selectorControls =
                new VBox(buttons, spinners);
        selectorControls.setStyle("-fx-padding: 40px 45px; " + "-fx-background-color: skyblue");
        selectorControls.setSpacing(20);

        // create borderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPane, 800, 600));
    }

    /**
     * Creates a VBox with all the integer spinners.
     *
     * @return spinners
     */
    private VBox createIntegerSpinnersGroup() {
        // Add integer spinner for selecting number of blocks
        SpinnerValueFactory.IntegerSpinnerValueFactory svf1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, 100, 5);
        SpinnerValueFactory.IntegerSpinnerValueFactory svf2 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, 100, 5);
        SpinnerValueFactory.IntegerSpinnerValueFactory svf3 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, 100, 5);
        Spinner<Integer> blockSizeSpinner = new Spinner<>(svf1);
        Spinner<Integer> rowsSpinner = new Spinner<>(svf2);
        Spinner<Integer> columnsSpinner = new Spinner<>(svf3);

        // add labels for integer spinners
        Label blockSizeLabel = new Label("Block size (cm)");
        blockSizeLabel.setScaleX(1.8);
        blockSizeLabel.setScaleY(1.8);

        Label columnsLabel = new Label("Select Columns");
        columnsLabel.setScaleX(1.8);
        columnsLabel.setScaleY(1.8);

        Label rowsLabel = new Label("Select Rows");
        rowsLabel.setScaleX(1.8);
        rowsLabel.setScaleY(1.8);

        // add next scene button
        Button nextSceneButton = new Button("Next");
        nextSceneButton.setOnAction((event) -> {
            this.quilt.setColumns(columnsSpinner.getValue());
            this.quilt.setRows(rowsSpinner.getValue());
            this.blockSize = blockSizeSpinner.getValue();
            stage.setScene(scenes.get(1));
        });

        // Add spinners to VBox and return
        VBox spinners = new VBox(rowsLabel, rowsSpinner,
                columnsLabel, columnsSpinner,
                blockSizeLabel, blockSizeSpinner,
                nextSceneButton);
        spinners.setSpacing(20);
        return spinners;
    }

    /**
     * Creates a VBox with all the radio buttons.
     *
     * @return buttons
     */
    private VBox createRadioButtonGroup() {
        // radio buttons for single or multi block quilt
        ToggleGroup blockType = new ToggleGroup();
        RadioButton singleButton = new RadioButton("Single Block");
        RadioButton multiButton = new RadioButton("Multi Block");
        singleButton.setScaleX(2);
        singleButton.setScaleY(2);
        multiButton.setScaleX(2);
        multiButton.setScaleY(2);
        singleButton.setToggleGroup(blockType);
        multiButton.setToggleGroup(blockType);

        // set onclick events
        singleButton.setOnAction((event) -> createSingleQuilt());
        multiButton.setOnAction((event) -> createMultiQuilt());

        // add radio buttons label
        Label buttonLabel = new Label("select block type");
        buttonLabel.setScaleX(1.8);
        buttonLabel.setScaleY(1.8);

        // add to VBox and return
        VBox buttons = new VBox(buttonLabel, singleButton, multiButton);
        buttons.setSpacing(20);
        return buttons;
    }

    /**
     * Creates the secons scene and adds it to the scenes ArrayList.
     */
    private void createSceneTwo() {
        Text title = new Text("Scene two");
        title.setFont(Font.font(30));
        title.setFill(Color.RED);

        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");

        // Creating choice box for block selection.
        String[] selections = {"Pinwheel", "Hourglass"};
        ChoiceBox choice = new ChoiceBox<String>();
        choice.getItems().addAll(selections);
        choice.getSelectionModel().selectFirst();
        choice.setOnAction((event) -> {
            if (choice.getValue().equals("Pinwheel")) {
                System.out.println("hello");
            }
        });
        Button nextSceneButton = new Button("Next");
        nextSceneButton.setOnAction((event) -> stage.setScene(scenes.get(0)));

        VBox selectorControls =
                new VBox(choice, nextSceneButton);
        selectorControls.setStyle("-fx-padding: 40px 45px; " + "-fx-background-color: skyblue");
        selectorControls.setSpacing(20);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPane, 800, 600));
    }

    /**
     * Creates a singleQuilt.
     */
    private void createSingleQuilt() {
        this.quilt = null;
        this.quilt = new SingleBlockQuilt();
    }

    /**
     * Creates a multiQuilt.
     */
    private void createMultiQuilt() {
        this.quilt = null;
        this.quilt = new MultiBlockQuilt();
    }
}
