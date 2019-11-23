package ca.bcit.comp2522.assignments.a4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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
    public void newArraySetHasObjectType() {
        assertEquals(testArraySet.collection instanceof Object[], true);
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
    public void removeReturnsTrueIfElementIsRemovedCorrectly() {
        testArraySet.add(testElement1);
        assertEquals(testArraySet.remove(testElement1), true);
    }

    @Test
    public void removeReturnsFalseIfElementIsNotInArraySet() {
        assertEquals(testArraySet.contains(testElement1), false);
        assertEquals(testArraySet.remove(testElement1), false);
    }

    @Test
    public void removeReturnsFalseIfElementIsNull() {
        assertEquals(testArraySet.remove(null), false);
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
    public void arraySetSizeIsZeroAfterClear() {
        testArraySet.add(testElement1);
        testArraySet.add(testElement2);
        testArraySet.clear();
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void containsReturnsTrueIfElementIsInArraySet() {
        testArraySet.add(testElement1);
        assertEquals(testArraySet.contains(testElement1), true);
    }

    @Test
    public void containsReturnsFalseIfElementIsNotInArraySet() {
        testArraySet.add(testElement1);
        assertEquals(testArraySet.contains(testElement2), false);
    }

    @Test
    public void containsReturnsFalseIfElementIsNull() {
        testArraySet.add(testElement3);
        assertEquals(testArraySet.contains(testElement3), false);
    }

    @Test
    public void containsChecksEntireArraySet() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        testArraySet.add(testElement1);
        int secondTestInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(secondTestInt);
            secondTestInt++;
        }
        assertEquals(testArraySet.contains(testElement1), true);
    }

    @Test
    public void containsReturnsFalseOnEmptyArraySet() {
        testArraySet.clear();
        assertEquals(testArraySet.contains(testElement1), false);
    }

    @Test
    public void sizeReturnsCorrectValue() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        assertEquals(testArraySet.size(), 100, 0.0);
    }

    @Test
    public void sizeReturnsZeroOnEmptySet() {
        testArraySet.clear();
        assertEquals(testArraySet.size(), 0, 0.0);
    }

    @Test
    public void resizeDoublesCapacityCorrectly() {
        int testInt = 0;
        for (int i = 0; i < testArraySet.INITIAL_CAPACITY; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        int oldCapacity = testArraySet.getCapacity();
        testArraySet.add(testElement1);
        assertEquals(testArraySet.getCapacity(), oldCapacity * 2);
    }

    @Test
    public void resizeContainsOldCollectionData() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            assertEquals(testArraySet.contains(testInt), true);
            testInt++;
        }
    }

    @Test
    public void toArrayReturnsTheSameElementsAsArraySet() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        Object[] testArray = testArraySet.toArray();

        for (Object i : testArray) {
            assertEquals(testArraySet.contains((int)i), true);
        }
    }

    @Test
    public void toArraySizeIsTheSameAsCollectionSize() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        Object[] testArray = testArraySet.toArray();
        assertEquals(testArraySet.size(), testArray.length, 0.0);
    }

    @Test
    public void toArrayReturnsEmptyArrayForEmptyArraySet() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }
        testArraySet.clear();
        Object[] testArray = testArraySet.toArray();

        assertEquals(testArray.length, 0, 0.0);
    }

    @Test
    public void hasNextReturnsTrueIfIterationHasMoreElements() {
        int testInt = 0;
        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            testInt++;
        }

        ArraySet.SetIterator it = testArraySet.iterator();
        assertEquals(it.hasNext(), true);
    }

    @Test
    public void hasNextReturnsTrueIfIterationHasOneElement() {
        testArraySet.add(testElement1);
        ArraySet.SetIterator it = testArraySet.iterator();
        assertEquals(it.hasNext(), true);
    }

    @Test
    public void hasNextReturnsFalseOnEmptyArraySet() {
        ArraySet.SetIterator it = testArraySet.iterator();
        assertEquals(it.hasNext(), false);
    }

    @Test
    public void hasNextReturnsFalseOnNullElement() {
        testArraySet.add(testElement3);
        ArraySet.SetIterator it = testArraySet.iterator();
        assertEquals(it.hasNext(), false);
    }

    @Test
    public void nextReturnsNextElementInArraySet() {
        ArraySet.SetIterator it = testArraySet.iterator();
        int testInt = 0;

        for (int i = 0; i < 100; i++) {
            testArraySet.add(testInt);
            assertEquals(it.next(), testInt);
            testInt++;
        }
    }
}
