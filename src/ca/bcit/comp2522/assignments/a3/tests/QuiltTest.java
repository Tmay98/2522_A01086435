package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.Quilt;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class QuiltTest {
    private Quilt testQuilt;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testQuilt = new Quilt();
    }

    @Test
    public void quiltSizeConstantIsCorrect() {
        assertEquals(testQuilt.QUILT_SIZE, 600, 0.0);
    }

    @Test
    public void cellSizeConstantIsCorrect() {
        assertEquals(testQuilt.CELL_SIZE, 100, 0.0);
    }

    @Test
    public void rowsAreInstantiatedToValueZero() {
        assertEquals(testQuilt.getRows(), 0, 0.0);
    }

    @Test
    public void columnsAreInstantiatedToValueZero() {
        assertEquals(testQuilt.getColumns(), 0, 0.0);
    }

    @Test
    public void getCellSizeReturnsCorrectValue() {
        testQuilt.setCellSize(20.0);
        assertEquals(testQuilt.getCellSize(), 20.0, 0.0);
    }

    @Test
    public void getColumnsReturnsCorrectValue() {
        testQuilt.setRows(20);
        assertEquals(testQuilt.getRows(), 20, 0.0);
    }

    @Test
    public void getRowsReturnsCorrectValue() {
        testQuilt.setRows(20);
        assertEquals(testQuilt.getRows(), 20, 0.0);
    }

    @Test
    public void setCellSizeAssignsValueCorrectly() {
        testQuilt.setRows(10);
        testQuilt.setColumns(10);
        testQuilt.setCellSize(50);

        assertEquals(testQuilt.getCellSize(), 50, 0.0);
    }

    @Test
    public void setCellSizeDoesNotExceedMaxValue() {
        testQuilt.setRows(10);
        testQuilt.setColumns(10);
        testQuilt.setCellSize(70);

        assertEquals(testQuilt.getCellSize(), 60, 0.0);
    }


}
