package ca.bcit.comp2522.assignments.a3;

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
    private BorderPane borderPane;
    private ArrayList<ColorPicker> colorPickers;

    /**
     * Constructs an object of type QuiltProgram.
     *
     * @param stage a Stage
     */
    public QuiltProgram(Stage stage) {
        this.quilt = new SingleBlockQuilt();
        this.stage = stage;
        this.scenes = new ArrayList<>();
        this.choice = new ChoiceBox<String>();
        this.borderPane = new BorderPane();
        this.colorPickers = new ArrayList<>();
        createSceneOne();
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
        BorderPane borderPaneSceneOne = new BorderPane();
        borderPaneSceneOne.setTop(titlePane);
        borderPaneSceneOne.setLeft(selectorControls);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPaneSceneOne, 1000, 800));
    }

    /**
     * Creates the second scene and adds it to the scenes ArrayList
     * for creating a multi quilt.
     */
    private void createSceneMultiQuilt() {
        Text title = new Text("Scene two");
        title.setFont(Font.font(30));
        title.setFill(Color.RED);

        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");

        // Creating choice box for block selection.
        createDesignChoiceBox();

        // Add choice label
        Label choiceLabel = new Label("Select Design");
        choiceLabel.setScaleX(1.8);
        choiceLabel.setScaleY(1.8);

        // add colour pickers label
        Label colourPickerLabel = new Label("Select colours");
        colourPickerLabel.setScaleX(1.8);
        colourPickerLabel.setScaleY(1.8);

        // add colour pickers
        createColourPickers();

        // create next scene button
        Button nextSceneButton = new Button("Next");
        nextSceneButton.setOnAction((event) -> stage.setScene(scenes.get(1)));

        // create selector controls
        VBox selectorControls =
                new VBox(choiceLabel, choice, colourPickerLabel,
                        colorPickers.get(0), colorPickers.get(1),
                        colorPickers.get(2), colorPickers.get(3),
                        nextSceneButton);
        selectorControls.setStyle("-fx-padding: 40px 45px; " + "-fx-background-color: skyblue");
        selectorControls.setSpacing(20);

        // create quilt group
        Label quiltLabel = new Label("Quilt");
        quiltLabel.setFont(new Font("Arial", 35));
        VBox quiltGroup = new VBox(quiltLabel, quilt.getQuiltGrid());

        // set border panes
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);
        borderPane.setRight(quiltGroup);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPane, 1000, 800));
    }

    /**
     * Creates the second scene and adds it to the scenes ArrayList
     * for creating a single quilt.
     */
    private void createSceneSingleQuilt() {
        Text title = new Text("Scene three");
        title.setFont(Font.font(30));
        title.setFill(Color.RED);

        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");

        // Creating choice box for block selection.
        createDesignChoiceBox();

        // Add choice label
        Label choiceLabel = new Label("Select Design");
        choiceLabel.setScaleX(1.8);
        choiceLabel.setScaleY(1.8);

        // add colour pickers label
        Label colourPickerLabel = new Label("Select colours");
        colourPickerLabel.setScaleX(1.8);
        colourPickerLabel.setScaleY(1.8);

        // add colour pickers
        createColourPickers();

        // create next scene button
        Button createQuiltButton = new Button("Create Quilt with selected block");
        createQuiltButton.setOnAction((event) -> fillSingleQuiltGrid());

        // create selector controls
        VBox selectorControls =
                new VBox(choiceLabel, choice, colourPickerLabel,
                        colorPickers.get(0), colorPickers.get(1),
                        colorPickers.get(2), colorPickers.get(3),
                        createQuiltButton);
        selectorControls.setStyle("-fx-padding: 40px 45px; " + "-fx-background-color: skyblue");
        selectorControls.setSpacing(20);

        // create quilt group
        Label quiltLabel = new Label("Quilt");
        quiltLabel.setFont(new Font("Arial", 35));
        VBox quiltGroup = new VBox(quiltLabel, quilt.getQuiltGrid());

        // set border panes
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);
        borderPane.setRight(quiltGroup);

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
            // create multi block or single block scene depending on quilt type.
            if (quilt instanceof MultiBlockQuilt) {
                initializeGridMultiQuilt();
                createSceneMultiQuilt();
                stage.setScene(scenes.get(1));
            } else {
                initializeGridSingleQuilt();
                createSceneSingleQuilt();
                stage.setScene(scenes.get(1));
            }
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
     * Fills in the quilt with the selected blocks colours.
     */
    private void fillSingleQuiltGrid() {
        for (int i = 0; i < quilt.getColumns(); i++) {
            for (int j = 0; j < quilt.getRows(); j++) {
                Block tempBlock = createBlockOfSelectedType();
                this.quilt.getQuiltGrid().add(tempBlock.getBlock(), i, j);
            }
        }
    }

    /**
     * Creates and returns a block of currently selected type.
     *
     * @return tempBlock
     */
    private Block createBlockOfSelectedType() {
        Block tempBlock;
        if (selectedDesign instanceof PinwheelBlock) {
            tempBlock =  new PinwheelBlock(quilt.getCellSize() / 100);
        } else if (selectedDesign instanceof HourglassBlock) {
            tempBlock =  new HourglassBlock(quilt.getCellSize() / 100);
        } else if (selectedDesign instanceof TwistedFourStarBlock) {
            tempBlock =  new TwistedFourStarBlock();
        } else if (selectedDesign instanceof SquareGridBlock) {
            tempBlock =  new SquareGridBlock(quilt.getCellSize() / 100);
        } else {
            tempBlock = new RandomSquareBlock();
        }
        tempBlock.blockColour(colorPickers.get(0).getValue(), 1);
        tempBlock.blockColour(colorPickers.get(1).getValue(), 2);
        tempBlock.blockColour(colorPickers.get(2).getValue(), 3);
        tempBlock.blockColour(colorPickers.get(3).getValue(), 4);
        return tempBlock;
    }

    /**
     * Creates all the colour pickers for scene 2.
     */
    private void createColourPickers() {
        for (int i = 0; i < 4; i++) {
            colorPickers.add(new ColorPicker(Color.BLACK));
        }
        colorPickers.get(0).setOnAction((event) -> {
            selectedDesign.blockColour(colorPickers.get(0).getValue(), 1);
        });
        colorPickers.get(1).setOnAction((event) -> {
            selectedDesign.blockColour(colorPickers.get(1).getValue(), 2);
        });
        colorPickers.get(2).setOnAction((event) -> {
            selectedDesign.blockColour(colorPickers.get(2).getValue(), 3);
        });
        colorPickers.get(3).setOnAction((event) -> {
            selectedDesign.blockColour(colorPickers.get(3).getValue(), 4);
        });
    }

    /**
     * Creates the drop down for selecting designs for a block.
     */
    private void createDesignChoiceBox() {
        String[] selections = {"PinWheel", "HourGlass", "TwistedFourStar", "SquareGrid", "RandomSquare"};
        choice = new ChoiceBox<String>();
        choice.getItems().addAll(selections);
        choice.setOnAction((event) -> {
            if (choice.getSelectionModel().isEmpty()) {
                return;
            }
            if (choice.getValue().equals("PinWheel")) {
                selectedDesign = new PinwheelBlock(quilt.getCellSize() / 100);
            } else if (choice.getValue().equals("HourGlass")) {
                selectedDesign = new HourglassBlock(quilt.getCellSize() / 100);
            } else if (choice.getValue().equals("TwistedFourStar")) {
                selectedDesign = new HourglassBlock(quilt.getCellSize() / 100);
            } else if (choice.getValue().equals("SquareGrid")) {
                selectedDesign = new SquareGridBlock(quilt.getCellSize() / 100);
            } else if (choice.getValue().equals("RandomSquare")) {
                selectedDesign = new SquareGridBlock(quilt.getCellSize() / 100);
            }
            setDesignInitialColour();
            this.borderPane.setCenter(selectedDesign.getBlockUnscaled());
        });
    }

    /**
     * Initializes all the selected block designs colours.
     */
    private void setDesignInitialColour() {
        selectedDesign.blockColour(colorPickers.get(0).getValue(), 1);
        selectedDesign.blockColour(colorPickers.get(1).getValue(), 2);
        selectedDesign.blockColour(colorPickers.get(2).getValue(), 3);
        selectedDesign.blockColour(colorPickers.get(3).getValue(), 4);
    }

    /**
     * Initializes the multi quilts grid to selected rows and columns.
     */
    public void initializeGridMultiQuilt() {
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

    /**
     * Initializes the single quilts grid to selected rows and columns.
     */
    public void initializeGridSingleQuilt() {
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
                Pane pane = new Pane();
                quilt.getQuiltGrid().add(pane, i, j);
            }
        }
        quilt.getQuiltGrid().setGridLinesVisible(true);
    }

    /**
     * Adds the pane to the grid at spot colIndex, rowIndex.
     *
     * @param colIndex an int
     * @param rowIndex an int
     */
    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        quilt.getQuiltGrid().add(pane, colIndex, rowIndex);
        pane.setOnMouseClicked(e -> {
            Block tempBlock = createBlockOfSelectedType();
            quilt.getQuiltGrid().add(tempBlock.getBlock(), colIndex, rowIndex);
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
