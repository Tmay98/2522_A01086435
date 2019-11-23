package ca.bcit.comp2522.assignments.a4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;
import static org.junit.Assert.*;

public class ArraySetTest {
    private ArraySet testArraySet;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet();
    }

    @Test
    public void constantInitialCapacityIsCorrect() {
        assertEquals(testArraySet.INITIAL_CAPACITY, 10, 0.0);
    }

    @Test
    public void CAPACITY_VALUE_IS_CORRECT() {}

    @Test
    public void ELEMENT_COUNT_VALUE_IS_CORRECT() {}

    @Test
    public void COLLECTION_SIZE_IS_CORRECT() {}

    @Test
    public void NEW_ARRAY_SET_HAS_DEFAULT_CAPACITY() {}

    @Test
    public void NEW_ARRAY_SET_SIZE_IS_ZERO() {}

    @Test
    public void ADD_ELEMENT_IS_IN_ARRAY_SET_IF_ELEMENT_DOES_NOT_EXIST () {}

    @Test
    public void ADD_ELEMENT_IS_NOT_IN_ARRAY_SET_IF_ELEMENT_EXISTS() {}

    @Test
    public void ADD_ELEMENT_IS_NOT_IN_ARRAY_SET_IF_ELEMENT_IS_NULL() {}

    @Test
    public void ADD_RETURNS_TRUE_IF_ADD_IS_SUCCESSFUL() {}

    @Test
    public void ADD_RETURNS_FALSE_IF_ADD_IS_UNSUCCESSFUL() {}

    @Test
    public void ADD_RETURNS_FALSE_IF_ELEMENT_IS_NULL() {}

    @Test
    public void ELEMENT_IS_NOT_IN_ARRAY_SET_IF_REMOVED_CORRECTLY() {}

    @Test
    public void ARRAY_SET_IS_UNCHANGED_IF_REMOVING_NON_EXISTING_ELEMENT() {}

    @Test
    public void REMOVE_RETURNS_TRUE_IF_ELEMENT_IS_REMOVED_CORRECTLY() {}

    @Test
    public void REMOVE_RETURNS_FALSE_IF_ARRAY_SET_IS_UNCHANGED() {}

    @Test
    public void ARRAY_SET_IS_EMPTY_AFTER_CLEAR() {}

    @Test
    public void CONTAINS_RETURNS_TRUE_IF_ELEMENT_IS_IN_ARRAY_SET() {}

    @Test
    public void CONTAINS_RETURNS_FALSE_IF_ELEMENT_IS_NOT_IN_ARRAY_SET() {}

    @Test
    public void CONTAINS_CHECKS_ENTIRE_ARRAY_SET() {}

    @Test
    public void CONTAINS_RETURNS_FALSE_ON_EMPTY_ARRAY_SET() {}

    @Test
    public void SIZE_RETURNS_CORRECT_VALUE() {}

    @Test
    public void SIZE_RETURNS_ZERO_ON_EMPTY_SET() {}

    @Test
    public void SIZE_RETURNS_NEGATIVE_ONE_UPON_FAILURE() {}

    @Test
    public void RESIZE_DOUBLES_CAPACITY_CORRECTLY() {}

    @Test
    public void TO_ARRAY_RETURNS_THE_SAME_ELEMENTS_AS_ARRAY_SET() {}

    @Test
    public void TO_ARRAY_RETURNS_EMPTY_ARRAY_FOR_EMPTY_ARRAY_SET() {}

    @Test
    public void TO_ARRAY_RETURNS_NULL_UPON_FAILURE() {}

    @Test
    public void SET_ITERATOR_RETURNS_ITERATOR_FOR_ARRAY_SET() {}

    @Test
    public void SET_ITERATOR_POINTS_TO_FIRST_ELEMENT_IN_ARRAY_SET() {}

    @Test
    public void SET_ITERATOR_RETURNS_NULL_FOR_EMPTY_ARRAY_SETS() {}

    @Test
    public void SET_ITERATOR_RETURNS_NULL_UPON_FAILURE() {}

    @Test
    public void HAS_NEXT_RETURNS_TRUE_IF_ITERATION_HAS_MORE_ELEMENTS() {}

    @Test
    public void HAS_NEXT_RETURNS_FALSE_IF_ITERATION_HAS_NO_MORE_ELEMENTS() {}

    @Test
    public void HAS_NEXT_RETURNS_FALSE_ON_EMPTY_ARRAY_SET() {}

    @Test
    public void NEXT_POINTS_TO_NEXT_ELEMENT_IN_ARRAY_SET() {}

    @Test
    public void NEXT_RETURNS_NEXT_ELEMENT_IN_ARRAY_SET() {}
}
