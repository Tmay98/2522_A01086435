package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.Name;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class NameTest {

    private Name defaultName;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultName = new Name("Tommy", "William", "May");
    }

    @Test
    public void testGetFirstName() {
        assertEquals(defaultName.getFirstName(), "Tommy");
    }

    @Test
    public void testGetMiddleName() {
        assertEquals(defaultName.getMiddleName(), "William");
    }

    @Test
    public void testGetLastName() {
        assertEquals(defaultName.getLastName(), "May");
    }

    @Test
    public void testSetFirstName() {
        defaultName.setFirstName("Aiman");
        assertEquals("Aiman", defaultName.getFirstName());
    }

    @Test
    public void testSetMiddleName() {
        defaultName.setMiddleName("G");
        assertEquals("G", defaultName.getMiddleName());
    }

    @Test
    public void testSetLastName() {
        defaultName.setLastName("Ismail");
        assertEquals("Ismail", defaultName.getLastName());
    }

    @Test
    public void testIncorrectFirstNameInputThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Name test = new Name("123", "sdf", "sdf");
    }

    @Test
    public void testIncorrectMiddleNameInputThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Name test = new Name("erg", "123", "sdf");
    }

    @Test
    public void testIncorrectLastNameInputThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Name test = new Name("ojfi", "edg", "123");
    }
}
