package ca.bcit.comp2522.assignments.a4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySetTest {
    private ArraySet testArraySet;
    private int testElement1;
    private int testElement2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet();
        testElement1 = 100;
        testElement2 = 1000;
    }

    @Test
    public void constantInitialCapacityIsCorrect() {
        assertEquals(testArraySet.INITIAL_CAPACITY, 10, 0.0);
    }

    @Test
    public void elementCountIsZeroWhenArraySetIsInitialized() {
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void elementCountValueIsZeroWhenArraySetIsInitialized() {
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void collectionSizeIsCorrect() {
        int testInt = 0;
        for (int i = 0; i < 9; i++){
            testArraySet.add(testInt);
            testInt++;
        }
        assertEquals(testArraySet.size(), 9, 0.0);
    }

    @Test
    public void newArraySetHasDefaultCapacity() {
        assertEquals(testArraySet.getCapacity(), testArraySet.INITIAL_CAPACITY, 0.0);
    }

    @Test
    public void newArraySetSizeIsZero() {
    }

    @Test
    public void addElementIsInArraySetIfElementDoesNotExist() {
        assertEquals(testArraySet.add(testElement1), true);
        assertEquals(testArraySet.contains(testElement1), true);
    }

    @Test
    public void addElementIsNotInArraySetIfElementExists() {}

    @Test
    public void addElementIsNotInArraySetIfElementIsNull() {}

    @Test
    public void addReturnTrueIfAddIsSuccessful() {
        assertEquals(testArraySet.contains(testElement1), false);
        assertEquals(testArraySet.add(testElement1), true);
    }

    @Test
    public void addReturnsFalseIfAddIsUnsuccessful() {}

    @Test
    public void addReturnsFalseIfElementIsNull() {}

    @Test
    public void addReturnsFalseIfCollectionIsEmpty() {}

    @Test
    public void elementIsNotInArraySetIfRemovedCorrectly() {}

    @Test
    public void arraySetIsUnchangedIfRemovingNonExistingElement() {}

    @Test
    public void removeReturnsTrueIfElementIsRemovedCorrectly() {}

    @Test
    public void removeReturnsFalseIfArraySetIsUnchanged() {}

    @Test
    public void arraySetIsEmptyAfterClear() {}

    @Test
    public void containsReturnsTrueIfElementIsInArraySet() {}

    @Test
    public void containsReturnsFalseIfElementIsNotInArraySet() {}

    @Test
    public void containsChecksEntireArraySet() {}

    @Test
    public void containsReturnsFalseOnEmptyArraySet() {}

    @Test
    public void sizeReturnsCorrectValue() {}

    @Test
    public void sizeReturnsZeroOnEmptySet() {}

    @Test
    public void sizeReturnsNegativeOneUponFailure() {}


    @Test
    public void resizeDoublesCapacityCorrectly() {}


    @Test
    public void toArrayReturnsTheSameElementsAsArraySet() {}

    @Test
    public void toArrayReturnsEmptyArrayForEmptyArraySet() {}

    @Test
    public void toArrayReturnsNullUponFailure() {}

    @Test
    public void setIteratorReturnsIteratorForArraySet() {}

    @Test
    public void setIteratorPointsToFirstElementInArraySet() {}

    @Test
    public void setIteratorReturnsNullForEmptyArraySets() {}

    @Test
    public void setIteratorReturnsNullUponFailure() {}

    @Test
    public void hasNextReturnsTrueIfIterationHasMoreElements() {}

    @Test
    public void hasNextReturnsFalseIfIterationHasNoMoreElements() {}

    @Test
    public void hasNextReturnsFalseOnEmptyArraySet() {}

    @Test
    public void nextPointsToNextElementInArraySet() {}

    @Test
    public void nextReturnsNextElementInArraySet() {}

}
