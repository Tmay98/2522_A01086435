package ca.bcit.comp2522.assignments.a3;

import java.util.ArrayList;

/**
 * Quilt.
 *
 * @author Frances Mach & Tommy May
 * @version 2019
 */
public class Quilt {
    private int numberOfBlocks;
    private int rows;
    private int columns;
    private int blockLength;
    private ArrayList<Block> blocks;

    /**
     * Constructs an object of type Quilt.
     */
    public Quilt() {
        this.numberOfBlocks = 0;
        this.rows = 0;
        this.columns = 0;
        this.blockLength = 100;
        this.blocks = new ArrayList<>();
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
     * Sets the number of columns in the quilt.
     *
     * @param columns an int
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    private void addBlock(Block block){};
    private void removeBlock(Block block){};
    public void createQuilt(){};
}
