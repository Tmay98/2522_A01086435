package ca.bcit.comp2522.assignments.a3;

import javafx.scene.paint.Paint;

public interface Colourable {
    /**
     * Selects a colour for a colour section.
     *
     * @param paint a Paint object
     * @param groupNumber an int
     */
    default void blockColour(Paint paint, int groupNumber) { }
}
