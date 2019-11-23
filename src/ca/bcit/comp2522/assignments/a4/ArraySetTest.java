package ca.bcit.comp2522.assignments.a4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySetTest {
    private ArraySet<Integer> testArraySet;
    private int testElement1;
    private int testElement2;
    private Integer testElement3;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet();
        testElement1 = 100;
        testElement2 = 1000;
        testElement3 = null;
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
    public void newArraySetHasDefaultCapacity() {
        assertEquals(testArraySet.getCapacity(), testArraySet.INITIAL_CAPACITY, 0.0);
    }

    @Test
    public void newArraySetSizeIsZero() {
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void addElementIsInArraySetIfElementDoesNotExist() {
        assertEquals(testArraySet.add(testElement1), true);
        assertEquals(testArraySet.contains(testElement1), true);
    }

    @Test
    public void addElementIncreasesElementCountByOne() {
        int previousSize = testArraySet.size();
        assertEquals(testArraySet.add(testElement1), true);
        assertEquals(testArraySet.size(), previousSize + 1, 0.0);
    }

    @Test
    public void addElementIncreasesElementCountByFive() {
        int previousSize = testArraySet.size();
        int testInt = 0;
        for (int i = 0; i < 5; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        assertEquals(testArraySet.size(), previousSize + 5, 0.0);
    }

    @Test
    public void addElementIncreasesElementCountByZeroUponFailure() {
        assertEquals(testArraySet.add(null), false);
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void addElementIsNotInArraySetIfElementIsNull() {
        testElement3 = null;
        testArraySet.add(null);
        assertEquals(testArraySet.contains(testElement3), false);
    }

    @Test
    public void addReturnTrueIfAddIsSuccessful() {
        assertEquals(testArraySet.contains(testElement1), false);
        assertEquals(testArraySet.add(testElement1), true);
    }

    @Test
    public void addReturnsFalseIfAddIsUnsuccessful() {
        assertEquals(testArraySet.add(testElement1), true);
        assertEquals(testArraySet.contains(testElement1), true);
        assertEquals(testArraySet.add(testElement1), false);
    }

    @Test
    public void addReturnsFalseIfElementIsNull() {
        assertEquals(testArraySet.add(null), false);
    }

    @Test
    public void addIncreaseMaxCapacityWhenLimitIsReached() {
        int previousSize = testArraySet.size();
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        assertEquals(testArraySet.size(), previousSize + 100, 0.0);
    }

    @Test
    public void elementIsNotInArraySetIfRemovedCorrectly() {
        testArraySet.add(testElement1);
        assertEquals(testArraySet.remove(testElement1), true);
    }

    @Test
    public void arraySetIsUnchangedIfRemovingNonExistingElement() {
        int previousSize = testArraySet.size();
        assertEquals(testArraySet.remove(testElement1), false);
        assertEquals(previousSize, testArraySet.size());
    }

    @Test
    public void arraySetSizeIsSmallerIfElementIsRemoved() {
        testArraySet.add(testElement1);
        int previousSize = testArraySet.size();

        testArraySet.remove(testElement1);
        assertEquals(previousSize, testArraySet.size() + 1);
    }

    @Test
    public void removeReturnsTrueIfElementIsRemovedCorrectly() {
        testArraySet.add(testElement1);
        assertEquals(testArraySet.remove(testElement1), true);
    }

    @Test
    public void removeReturnsFalseIfArraySetIsUnchanged() {
        
    }

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
