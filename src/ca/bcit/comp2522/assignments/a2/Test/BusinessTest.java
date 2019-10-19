package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.Business;
import ca.bcit.comp2522.assignments.a2.ContactInformation;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BusinessTest {

    private Business defaultBusinessCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultBusinessCard = new Business("eorgeio",
                "eerger",
                true,
                "description",
                new ContactInformation("6050403434", "email@email.com", "10:00 - 12:00"),
                "address");
    }

    @Test
    public void testGetAddress() {
        assertEquals("address", defaultBusinessCard.getAddress());
    }

    @Test
    public void testSetAddress() {
        defaultBusinessCard.setAddress("newAddress");
        assertEquals("newAddress", defaultBusinessCard.getAddress());
    }
}
