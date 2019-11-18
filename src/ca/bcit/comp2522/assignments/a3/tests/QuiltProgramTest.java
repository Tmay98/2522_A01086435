package ca.bcit.comp2522.assignments.a3.tests;

import ca.bcit.comp2522.assignments.a3.QuiltProgram;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class QuiltProgramTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLabelFontSizeConstantIsCorrect() {
        assertEquals(QuiltProgram.LABEL_FONT_SIZE_SCALE, 1.8, 0.0);
    }

    @Test
    public void testConvertToPercentConstantIsCorrect() {
        assertEquals(QuiltProgram.CONVERT_TO_PERCENT, 100, 0.0);
    }

    @Test
    public void testIntSpinnerMaxValueConstantIsCorrect() {
        assertEquals(QuiltProgram.INT_SPINNER_MAX_VALUE, 50, 0.0);
    }

    @Test
    public void testIntSpinnerInitialValueConstantIsCorrect() {
        assertEquals(QuiltProgram.INT_SPINNER_INITIAL_VALUE, 5, 0.0);
    }

    @Test
    public void testButtonSpacingConstantIsCorrect() {
        assertEquals(QuiltProgram.BUTTON_SPACING, 20, 0.0);
    }

    @Test
    public void testSceneWidthConstantIsCorrect() {
        assertEquals(QuiltProgram.SCENE_WIDTH, 1000, 0.0);
    }

    @Test
    public void testSceneHeightConstantIsCorrect() {
        assertEquals(QuiltProgram.SCENE_HEIGHT, 800, 0.0);
    }

    @Test
    public void testTitleFontSizeConstantIsCorrect() {
        assertEquals(QuiltProgram.TITLE_FONT_SIZE, 30, 0.0);
    }

    @Test
    public void testNumberOfColourPickersConstantIsCorrect() {
        assertEquals(QuiltProgram.NUMBER_OF_COLOUR_PICKERS, 4, 0.0);
    }

    @Test
    public void testBlockSizeSpinnerInitialValueConstantIsCorrect() {
        assertEquals(QuiltProgram.BLOCK_SIZE_SPINNER_INITIAL_VALUE, 50, 0.0);
    }

}
