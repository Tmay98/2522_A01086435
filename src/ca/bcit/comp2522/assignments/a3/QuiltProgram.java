package ca.bcit.comp2522.assignments.a3;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
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
    /**
     * Label scale amount.
     */
    private static final double LABEL_FONT_SIZE_SCALE = 1.8;
    /**
     * Number for conversion to a percentage.
     */
    private static final int CONVERT_TO_PERCENT = 100;
    /**
     * Spinner max value.
     */
    private static final int INT_SPINNER_MAX_VALUE = 50;
    /**
     * Initial value of spinner.
     */
    private static final int INT_SPINNER_INITIAL_VALUE = 5;
    /**
     * Pixel spaces between buttons.
     */
    private static final int BUTTON_SPACING = 20;
    /**
     * Width of a scene.
     */
    private static final int SCENE_WIDTH = 1000;
    /**
     * Height of a scene.
     */
    private static final int SCENE_HEIGHT = 800;
    /**
     * Size of the font in the GUI.
     */
    private static final int TITLE_FONT_SIZE = 30;
    /**
     * Number of colour pickers.
     */
    private static final int NUMBER_OF_COLOUR_PICKERS = 4;
    /**
     * Initial value for block size spinner.
     */
    private static final int BLOCK_SIZE_SPINNER_INITIAL_VALUE = 50;

    private Quilt quilt;
    private ArrayList<Scene> scenes;
    private Stage stage;
    private ChoiceBox<String> choice;
    private Block selectedDesign;
    private BorderPane borderPane;
    private ArrayList<ColorPicker> colorPickers;
    private String quiltType;

    /**
     * Constructs an object of type QuiltProgram.
     *
     * @param stage a Stage
     */
    QuiltProgram(Stage stage) {
        this.quilt = new Quilt();
        this.stage = stage;
        this.scenes = new ArrayList<>();
        this.borderPane = new BorderPane();
        this.choice = new ChoiceBox<>();
        this.colorPickers = new ArrayList<>();
        this.quiltType = "SingleQuilt";
        createSceneOne();
    }

    /**
     * Returns the stage.
     *
     * @return stage a Stage object
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Returns the ArrayList of scenes.
     *
     * @return scenes an ArrayList
     */
    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    /**
     * Create a title pane.
     *
     * @param titleText a String
     * @return titlePane a StackPane object
     */
    private StackPane createTitlePane(String titleText) {
        Text title = new Text(titleText);
        title.setFont(Font.font(TITLE_FONT_SIZE));
        title.setFill(Color.RED);

        StackPane titlePane = new StackPane(title);
        titlePane.setStyle("-fx-padding: 20px; -fx-background-color: black");

        return titlePane;
    }

    /**
     * Sets the style and spacing for controls.
     *
     * @param controls a VBox object
     */
    private void setControlSettings(VBox controls) {
        controls.setStyle("-fx-padding: 40px 45px; "
                        + "-fx-background-color: skyblue");
        controls.setSpacing(BUTTON_SPACING);
    }

    /**
     * Sets the buttons and title for a border.
     *
     * @param titlePane a StackPane object
     * @param selectorControls a VBox object
     * @return borderPane scene a BorderPane object
     */
    private BorderPane setBorderPaneSettings(
            StackPane titlePane,
            VBox selectorControls) {
        setControlSettings(selectorControls);
        borderPane = new BorderPane();
        borderPane.setTop(titlePane);
        borderPane.setLeft(selectorControls);

        return borderPane;
    }

    /**
     * Creates and formats a label.
     *
     * @param labelText a String
     * @return label a Label
     */
    private Label createLabel(String labelText) {
        Label label = new Label(labelText);
        label.setScaleX(LABEL_FONT_SIZE_SCALE);
        label.setScaleY(LABEL_FONT_SIZE_SCALE);

        return label;
    }

    /**
     * Creates button to go to the final scene.
     *
     * @return nextSceneButton
     */
    private Button createFinalSceneButton() {
        Button nextSceneButton = new Button("Finalize quilt design");
        nextSceneButton.setOnAction((event) -> {
            createSceneFinal();
            stage.setScene(scenes.get(2));
        });
        return nextSceneButton;
    }

    /**
     * Create the border pane for a single or multi quilt.
     *
     * @param titlePane a StackPane
     * @param selectorControls a VBox
     * @return a BorderPane
     */
    private BorderPane createQuiltBorderPane(StackPane titlePane,
                                             VBox selectorControls) {
        Label quiltLabel = new Label("Quilt");
        quiltLabel.setFont(new Font("Arial", TITLE_FONT_SIZE));
        VBox quiltGroup = new VBox(quiltLabel, quilt.getQuiltGrid());

        // set border panes
        BorderPane borderPaneMultiQuilt = setBorderPaneSettings(
                titlePane,
                selectorControls
        );
        borderPaneMultiQuilt.setRight(quiltGroup);
        return borderPaneMultiQuilt;
    }

    /**
     * Creates selector controls with any number of buttons.
     *
     * @param choiceLabel a Label
     * @param colourPickerLabel a Label
     * @param buttons Buttons
     * @return a VBox
     */
    private VBox createSelectorControls(Label choiceLabel,
                                        Label colourPickerLabel,
                                        Button... buttons) {
        // create selector controls
        VBox selectorControls =
                new VBox(choiceLabel, choice, colourPickerLabel);
        for (int i = 0; i < NUMBER_OF_COLOUR_PICKERS; i++) {
            selectorControls.getChildren().add(colorPickers.get(i));
        }
        for (Button button : buttons) {
            selectorControls.getChildren().add(button);
        }
        return selectorControls;
    }

    /**
     * Creates a radio button and adds it to the given ToggleGroup.
     *
     * @param s a string
     * @param group a ToggleGroup
     * @return button a RadioButton
     */
    private RadioButton createRadioButton(String s, ToggleGroup group) {
        RadioButton button = new RadioButton(s);
        button.setScaleX(2);
        button.setScaleY(2);
        button.setToggleGroup(group);
        return button;
    }

    /**
     * Creates the first scene and adds it to the scenes ArrayList.
     */
    private void createSceneOne() {
        StackPane titlePane = createTitlePane("Quilt Settings");

        // create radio buttons
        VBox buttons = createRadioButtonGroup();

        // create spinners
        VBox spinners = createIntegerSpinnersGroup();

        VBox selectorControls = new VBox(buttons, spinners);

        // create borderPane
        BorderPane borderPaneSceneOne = setBorderPaneSettings(
                titlePane,
                selectorControls
        );

        // add first scene to ArrayList
        scenes.add(new Scene(borderPaneSceneOne, SCENE_WIDTH, SCENE_HEIGHT));
    }

    /**
     * Creates the second scene and adds it to the scenes ArrayList
     * for creating a multi quilt.
     */
    private void createSceneMultiQuilt() {
        StackPane titlePane = createTitlePane(
                "Create a multi-patterned quilt");

        // Creating choice box for block selection.
        createDesignChoiceBox();

        // Add labels
        Label choiceLabel = createLabel("Select Design");
        Label colourPickerLabel = createLabel("Select colours");

        // add colour pickers
        createColourPickers();

        // create next scene button
        Button nextSceneButton = createFinalSceneButton();
        // create selector controls
        VBox selectorControls = createSelectorControls(choiceLabel,
                colourPickerLabel,
                nextSceneButton);

        // create quilt group
        BorderPane borderPaneMultiQuilt =
                createQuiltBorderPane(titlePane, selectorControls);

        // add scene to ArrayList
        scenes.add(new Scene(borderPaneMultiQuilt, SCENE_WIDTH, SCENE_HEIGHT));
    }

    /**
     * Creates the second scene and adds it to the scenes ArrayList
     * for creating a single quilt.
     */
    private void createSceneSingleQuilt() {
        StackPane titlePane = createTitlePane(
                "Create a single patterned quilt");

        // Creating choice box for block selection.
        createDesignChoiceBox();

        // Add choice label
        Label choiceLabel = createLabel("Select Design");

        // add colour pickers label
        Label colourPickerLabel = createLabel("Select colours");

        // add colour pickers
        createColourPickers();

        // create quilt button
        Button createQuiltButton = new Button("Create Quilt");
        createQuiltButton.setOnAction((event) -> fillSingleQuiltGrid());


        // create next scene button
        Button nextSceneButton = createFinalSceneButton();

        // create selector controls.
        VBox selectorControls = createSelectorControls(choiceLabel,
                colourPickerLabel,
                createQuiltButton,
                nextSceneButton);

        // create quilt group
        BorderPane borderPaneSingleQuilt =
                createQuiltBorderPane(titlePane, selectorControls);

        // add first scene to ArrayList
        scenes.add(new Scene(borderPaneSingleQuilt, SCENE_WIDTH, SCENE_HEIGHT));
    }

    /**
     * Creates the final scene to view the complete quilt.
     */
    private void createSceneFinal() {
        StackPane titlePane = createTitlePane("Final Quilt");

        // create quilt group
        Label quiltLabel = new Label("Quilt");
        quiltLabel.setFont(new Font("Arial", TITLE_FONT_SIZE));
        VBox quiltGroup = new VBox(quiltLabel, quilt.getQuiltGrid());

        // create reset button
        Button resetButton = new Button("Create a new quilt");
        resetButton.setOnAction((actionEvent -> {
            this.quilt = new Quilt();
            this.scenes = new ArrayList<>();
            this.choice = new ChoiceBox<>();
            this.borderPane = new BorderPane();
            this.colorPickers = new ArrayList<>();
            createSceneOne();
            this.stage.setScene(this.scenes.get(0));
            this.stage.show();
        }));

        // create reset button label
        Label resetLabel = createLabel("Create a new quilt");

        // create selector controls
        VBox resetControls =
                new VBox(resetLabel, resetButton);

        // set border panes
        BorderPane finalScenePane = setBorderPaneSettings(
                titlePane,
                resetControls
        );
        finalScenePane.setCenter(quiltGroup);

        // add first scene to ArrayList
        scenes.add(new Scene(finalScenePane, SCENE_WIDTH, SCENE_HEIGHT));
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
                        1, INT_SPINNER_MAX_VALUE,
                        BLOCK_SIZE_SPINNER_INITIAL_VALUE);
        SpinnerValueFactory.IntegerSpinnerValueFactory svf2 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, INT_SPINNER_MAX_VALUE,
                        INT_SPINNER_INITIAL_VALUE);
        SpinnerValueFactory.IntegerSpinnerValueFactory svf3 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, INT_SPINNER_MAX_VALUE,
                        INT_SPINNER_INITIAL_VALUE);
        Spinner<Integer> blockSizeSpinner = new Spinner<>(svf1);
        Spinner<Integer> rowsSpinner = new Spinner<>(svf2);
        Spinner<Integer> columnsSpinner = new Spinner<>(svf3);

        // add labels for integer spinners
        Label blockSizeLabel = createLabel("Block size (cm)");

        Label columnsLabel = createLabel("Select Columns");

        Label rowsLabel = createLabel("Select Rows");

        // add next scene button
        Button nextSceneButton =
                getSecondSceneButton(rowsSpinner,
                        columnsSpinner, blockSizeSpinner);

        // Add spinners to VBox and return
        VBox spinners = new VBox(rowsLabel, rowsSpinner,
                columnsLabel, columnsSpinner,
                blockSizeLabel, blockSizeSpinner,
                nextSceneButton);
        spinners.setSpacing(BUTTON_SPACING);
        return spinners;
    }

    /**
     * Creates and returns the second scene button.
     *
     * @param rowsSpinner a Spinner
     * @param columnsSpinner a Spinner
     * @param blockSizeSpinner a Spinner
     * @return a Button
     */
    private Button getSecondSceneButton(Spinner<Integer> rowsSpinner,
                                        Spinner<Integer> columnsSpinner,
                                        Spinner<Integer> blockSizeSpinner) {
        Button nextSceneButton = new Button("Next");
        nextSceneButton.setOnAction((event) -> {
            this.quilt.setColumns(columnsSpinner.getValue());
            this.quilt.setRows(rowsSpinner.getValue());
            this.quilt.setCellSize(blockSizeSpinner.getValue());
            // create multi block or single block scene depending on quilt type.
            if (quiltType.equals("MultiQuilt")) {
                initializeGridMultiQuilt();
                createSceneMultiQuilt();
                stage.setScene(scenes.get(1));
            } else {
                initializeGridSingleQuilt();
                createSceneSingleQuilt();
                stage.setScene(scenes.get(1));
            }
        });
        return nextSceneButton;
    }

    /**
     * Creates a VBox with all the radio buttons.
     *
     * @return buttons
     */
    private VBox createRadioButtonGroup() {
        // radio buttons for single or multi block quilt
        ToggleGroup blockType = new ToggleGroup();
        RadioButton singleButton = createRadioButton("SingleBlock", blockType);
        RadioButton multiButton = createRadioButton("MultiBlock", blockType);

        // set onclick events
        singleButton.setOnAction((event) -> this.quiltType = "SingleQuilt");
        multiButton.setOnAction((event) -> this.quiltType = "MultiQuilt");

        // add radio buttons label
        Label buttonLabel = createLabel("select block type");

        // add to VBox and return
        VBox buttons = new VBox(buttonLabel, singleButton, multiButton);
        buttons.setSpacing(BUTTON_SPACING);
        return buttons;
    }

    /**
     * Fills in the quilt with the selected blocks colours.
     */
    private void fillSingleQuiltGrid() {
        for (int i = 0; i < quilt.getColumns(); i++) {
            for (int j = 0; j < quilt.getRows(); j++) {
                Block tempBlock = createBlockOfSelectedType();
                this.quilt.getQuiltGrid().add(tempBlock.getBlockScaled(), i, j);
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
            tempBlock =  new PinwheelBlock(
                    quilt.getCellSize() / CONVERT_TO_PERCENT);
        } else if (selectedDesign instanceof HourglassBlock) {
            tempBlock =  new HourglassBlock(
                    quilt.getCellSize() / CONVERT_TO_PERCENT);
        } else if (selectedDesign instanceof TwistedFourStarBlock) {
            tempBlock =  new TwistedFourStarBlock(
                    quilt.getCellSize() / CONVERT_TO_PERCENT);
        } else if (selectedDesign instanceof SquareGridBlock) {
            tempBlock =  new SquareGridBlock(
                    quilt.getCellSize() / CONVERT_TO_PERCENT);
        } else {
            tempBlock = new RandomSquareBlock(
                    quilt.getCellSize() / CONVERT_TO_PERCENT);
        }

        for (int i = 0; i < NUMBER_OF_COLOUR_PICKERS; i++) {
            tempBlock.blockColour(colorPickers.get(i).getValue(), i + 1);
        }
        return tempBlock;
    }

    /**
     * Creates all the colour pickers for scene 2.
     */
    private void createColourPickers() {
        for (int i = 0; i < NUMBER_OF_COLOUR_PICKERS; i++) {
            colorPickers.add(new ColorPicker(Color.BLACK));
            setColourPickerOnAction(i);
        }
    }

    /**
     * Sets a colour picker of given index onAction.
     *
     * @param i an int
     */
    private void setColourPickerOnAction(int i) {
        colorPickers.get(i).setOnAction((event) -> {
            selectedDesign.blockColour(
                    colorPickers.get(i).getValue(), i + 1);
        });
    }

    /**
     * Creates the drop down for selecting designs for a block.
     */
    private void createDesignChoiceBox() {
        String[] selections = {"PinWheel", "HourGlass",
                "TwistedFourStar", "SquareGrid", "RandomSquare"};
        choice = new ChoiceBox<>();
        choice.getItems().addAll(selections);
        choice.setOnAction((event) -> {
            if (choice.getSelectionModel().isEmpty()) {
                return;
            }
            if (choice.getValue().equals("PinWheel")) {
                selectedDesign = new PinwheelBlock(
                        quilt.getCellSize() / CONVERT_TO_PERCENT);
            } else if (choice.getValue().equals("HourGlass")) {
                selectedDesign = new HourglassBlock(
                        quilt.getCellSize() / CONVERT_TO_PERCENT);
            } else if (choice.getValue().equals("TwistedFourStar")) {
                selectedDesign = new TwistedFourStarBlock(
                        quilt.getCellSize() / CONVERT_TO_PERCENT);
            } else if (choice.getValue().equals("SquareGrid")) {
                selectedDesign = new SquareGridBlock(
                        quilt.getCellSize() / CONVERT_TO_PERCENT);
            } else if (choice.getValue().equals("RandomSquare")) {
                selectedDesign = new RandomSquareBlock(
                        quilt.getCellSize() / CONVERT_TO_PERCENT);
            }
            setDesignInitialColour();
            this.borderPane.setCenter(selectedDesign.getBlockUnscaled());
        });
    }

    /**
     * Initializes all the selected block designs colours.
     */
    private void setDesignInitialColour() {
        for (int i = 0; i < NUMBER_OF_COLOUR_PICKERS; i++) {
            selectedDesign.blockColour(
                    colorPickers.get(i).getValue(), i + 1);
        }
    }

    /**
     * Initializes the multi quilts grid to selected rows and columns.
     */
    private void initializeGridMultiQuilt() {
        int numCols = quilt.getColumns();
        int numRows = quilt.getRows();
        createQuiltCells(numCols, numRows);

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
    private void initializeGridSingleQuilt() {
        int numCols = quilt.getColumns();
        int numRows = quilt.getRows();
        createQuiltCells(numCols, numRows);

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Pane pane = new Pane();
                quilt.getQuiltGrid().add(pane, i, j);
            }
        }
        quilt.getQuiltGrid().setGridLinesVisible(true);
    }

    /**
     * Creates the quilts grid cells.
     *
     * @param numCols an int
     * @param numRows an int
     */
    private void createQuiltCells(int numCols, int numRows) {
        double cellSize = quilt.getCellSize();
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints(cellSize);
            quilt.getQuiltGrid().getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConstraints = new RowConstraints(cellSize);
            quilt.getQuiltGrid().getRowConstraints().add(rowConstraints);
        }
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
            quilt.getQuiltGrid()
                    .add(tempBlock.getBlockScaled(), colIndex, rowIndex);
        });
    }
}
