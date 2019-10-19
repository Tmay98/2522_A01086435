package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.ContactInformation;
import ca.bcit.comp2522.assignments.a2.PersonalBusinessCard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PersonalBusinessCardTest {

    private PersonalBusinessCard defaultPersonalBusinessCard;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultPersonalBusinessCard = new PersonalBusinessCard("name",
                "cardname",
                true,
                "description",
                new ContactInformation("1112223333", "email@email.com", "10:00 - 12:00"),
                new ContactInformation("2223334444", "otherEmail@email.com", "1:00 - 3:00"),
                "address"
        );
    }

    @Test
    public void testInvalidContactInfoThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        PersonalBusinessCard test = new PersonalBusinessCard("name",
                "cardname",
                true,
                "description",
                new ContactInformation("1112223333", "email@email.com", "10:00 - 12:00"),
                null,
                "address"
        );
    }
}
