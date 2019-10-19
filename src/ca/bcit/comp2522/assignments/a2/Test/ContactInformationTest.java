package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.ContactInformation;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ContactInformationTest {

    private ContactInformation defaultContactInfo;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultContactInfo = new ContactInformation("6049892302", "email@email.com", "10:00 - 12:00");
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("6049892302", defaultContactInfo.getPhoneNumber());
    }

    @Test
    public void testGetEmail() {
        assertEquals("email@email.com", defaultContactInfo.getEmail());
    }

    @Test
    public void testGetOperatingHours() {
        assertEquals("10:00 - 12:00", defaultContactInfo.getOperatingHours());
    }

    @Test
    public void testSetPhoneNumber() {
        defaultContactInfo.setPhoneNumber("6041112222");
        assertEquals("6041112222", defaultContactInfo.getPhoneNumber());
    }

    @Test
    public void testSetEmail() {
        defaultContactInfo.setEmail("newemail@email.com");
        assertEquals("newemail@email.com", defaultContactInfo.getEmail());
    }

    @Test
    public void testSetOperatingHours() {
        defaultContactInfo.setOperatingHours("9:00 - 15:00");
        assertEquals("9:00 - 15:00", defaultContactInfo.getOperatingHours());
    }

    @Test
    public void testIncorrectEmailThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        ContactInformation test = new ContactInformation("1112223333", "email", "10:00 - 12:00");
    }

    @Test
    public void testIncorrectPhoneNumberThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        ContactInformation test = new ContactInformation("irurn", "email@email.com", "10:00 - 12:00");
    }

    @Test
    public void testIncorrectOperatingHoursThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        ContactInformation test = new ContactInformation("irurn", "email@email.com", "  ");
    }
}
