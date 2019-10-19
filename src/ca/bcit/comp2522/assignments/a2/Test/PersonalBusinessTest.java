package ca.bcit.comp2522.assignments.a2.Test;

import ca.bcit.comp2522.assignments.a2.ContactInformation;
import ca.bcit.comp2522.assignments.a2.PersonalBusiness;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonalBusinessTest {

    private PersonalBusiness defaultPersonalBusiness;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        defaultPersonalBusiness = new PersonalBusiness("name",
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
        PersonalBusiness test = new PersonalBusiness("name",
                "cardname",
                true,
                "description",
                new ContactInformation("1112223333", "email@email.com", "10:00 - 12:00"),
                null,
                "address"
        );
    }
}
