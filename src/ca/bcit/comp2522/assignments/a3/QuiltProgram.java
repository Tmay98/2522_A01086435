package ca.bcit.comp2522.assignments.a3;

import ca.bcit.comp2522.lectures.week02.printingAndConcatenation.Geometry;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
    private Stage stage;
    private ChoiceBox choice;
    private Block selectedDesign;

    /**
     * Constructs an object of type QuiltProgram.
     *
     * @param stage a Stage
     */
    public QuiltProgram(Stage stage) {
        this.quilt = new Quilt();
        this.stage = stage;
        this.scenes = new ArrayList<>();
        this.choice = new ChoiceBox<String>();
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
        scenes.add(new Scene(borderPane, 1000, 800));
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
            this.quilt.setCellSize();
            initializeGrid();
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
     * Creates the second scene and adds it to the scenes ArrayList.
     */
    private void createSceneTwo() {
        Text title = new Text("Scene two");
        title.setFont(Font.font(30));
        title.setFill(Color.RED);

        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");
        BorderPane borderPane = new BorderPane();

        // Creating choice box for block selection.
        String[] selections = {"PinWheel", "HourGlass", "TwistedFourStar"};
        choice = new ChoiceBox<String>();
        choice.getItems().addAll(selections);
        choice.setOnAction((event) -> {
            if (choice.getSelectionModel().isEmpty()) {
                return;
            }
            if (choice.getValue().equals("PinWheel")) {
                selectedDesign = new PinwheelBlock(quilt.getCellSize() / 100);
            } else if (choice.getValue().equals("HourGlass")) {
                selectedDesign = new HourglassBlock();
            } else if (choice.getValue().equals("TwistedFourStar")) {
                selectedDesign = new HourglassBlock();
                System.out.println("set TwistedFourStar");
            }
            borderPane.setCenter(selectedDesign.getBlockUnscaled());
        });

        // Add choice label
        Label choiceLabel = new Label("Select Design");
        choiceLabel.setScaleX(1.8);
        choiceLabel.setScaleY(1.8);

        // add colour pickers label
        Label colourPickerLabel = new Label("Select colours");
        colourPickerLabel.setScaleX(1.8);
        colourPickerLabel.setScaleY(1.8);

        // add colour pickers
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction((event) -> {
            selectedDesign.blockColour(colorPicker.getValue(), 1);
        });

        // create next scene button
        Button nextSceneButton = new Button("Next");
        nextSceneButton.setOnAction((event) -> stage.setScene(scenes.get(2)));

        // create selector controls
        VBox selectorControls =
                new VBox(choiceLabel, choice, colourPickerLabel, colorPicker, nextSceneButton);
        selectorControls.setStyle("-fx-padding: 40px 45px; " + "-fx-background-color: skyblue");
        selectorControls.setSpacing(20);

        // create quilt group
        Label quiltLabel = new Label("Your current quilt");
        quiltLabel.setFont(new Font("Arial", 35));
        VBox quiltGroup = new VBox(quiltLabel, quilt.getQuiltGrid());

        // set borderpanes
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);
        borderPane.setRight(quiltGroup);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPane, 1000, 800));
    }

    public void initializeGrid() {
        int numCols = quilt.getColumns();
        int numRows = quilt.getRows();
        quilt.setCellSize();
        double cellSize = quilt.getCellSize();
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints(cellSize);
            quilt.getQuiltGrid().getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConstraints = new RowConstraints(cellSize);
            quilt.getQuiltGrid().getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }
        quilt.getQuiltGrid().setGridLinesVisible(true);
    }

    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        quilt.getQuiltGrid().add(pane, colIndex, rowIndex);
        pane.setOnMouseClicked(e -> {
            quilt.getQuiltGrid().add(selectedDesign.getBlock(), colIndex, rowIndex);
            choice.getSelectionModel().clearSelection();
        });
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
