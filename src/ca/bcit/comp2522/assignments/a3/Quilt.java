package ca.bcit.comp2522.assignments.a3;

import javafx.scene.layout.GridPane;

/**
 * Quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */
public class Quilt {
    /**
     * Size of the quilt on the screen.
     */
    private static final double QUILT_SIZE = 600;
    /**
     * Pixel size of a cell.
     */
    private static final int CELL_SIZE = 100;

    private int rows;
    private int columns;
    private GridPane quiltGrid;
    private double cellSize;

    /**
     * Constructs an object of type Quilt.
     */
    Quilt() {
        this.rows = 0;
        this.columns = 0;
        this.cellSize = CELL_SIZE;
        this.quiltGrid = new GridPane();
        quiltGrid.setMinWidth(QUILT_SIZE);
        quiltGrid.setMaxWidth(QUILT_SIZE);
        quiltGrid.setMinHeight(QUILT_SIZE);
        quiltGrid.setMaxHeight(QUILT_SIZE);
    }
    /**
     * Returns the grid pane of a quilt.
     * @return quiltGrid a GridPane
     */
    GridPane getQuiltGrid() {
        return this.quiltGrid;
    }

    /**
     * Returns the cell size of a quilt.
     * @return cellSize a double
     */
    double getCellSize() {
        return this.cellSize;
    }
    /**
     * Returns the number of rows in the quilt.
     *
     * @return rows an int
     */
    int getRows() {
        return rows;
    }
    /**
     * Returns the number of columns in the quilt.
     *
     * @return columns an int
     */
    int getColumns() {
        return columns;
    }
    /**
     * Sets the number of rows in the quilt.
     *
     * @param rows an int
     */
    void setRows(int rows) {
        this.rows = rows;
    }
    /**
     * Sets the block length scaling factor.
     */
    void setCellSize() {
        this.cellSize = QUILT_SIZE / Math.max(rows, columns);
    }
    /**
     * Sets the number of columns in the quilt.
     *
     * @param columns an int
     */
    void setColumns(int columns) {
        this.columns = columns;
    }
}
