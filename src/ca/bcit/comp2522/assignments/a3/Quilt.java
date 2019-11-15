package ca.bcit.comp2522.assignments.a3;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * Quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */
public class Quilt {
    private int rows;
    private int columns;
    private GridPane quiltGrid;
    private double cellSize;

    /**
     * Constructs an object of type Quilt.
     */
    public Quilt() {
        this.rows = 0;
        this.columns = 0;
        this.cellSize = 100;
        this.quiltGrid = new GridPane();
    }

    public GridPane getQuiltGrid() {
        return this.quiltGrid;
    }

    public double getCellSize() {
        return this.cellSize;
    }
    /**
     * returns the number of rows in the quilt.
     *
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * returns the number of columns in the quilt.
     *
     * @return columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Sets the number of rows in the quilt.
     *
     * @param rows an int
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Sets the block length scaling factor.
     *
     */
    public void setCellSize() {
        this.cellSize = 600 / Math.max(rows, columns);
    }

    /**
     * Sets the number of columns in the quilt.
     *
     * @param columns an int
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    private void removeBlock(Block block) {};
    public void createQuilt() {};
}
