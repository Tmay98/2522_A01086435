package ca.bcit.comp2522.assignments.a2;

public class PersonalBusiness extends Business {

    private ContactInformation ownerContactInformation;

    public PersonalBusiness(ContactInformation contactInformation,
                     ContactInformation personalContactInformation, String address) {
        super(contactInformation, address);

        if (personalContactInformation == null) {
            throw new IllegalArgumentException("Invalid personal contact info");
        }
    }

    public ContactInformation getOwnerContactInformation() {
        return ownerContactInformation;
    }
}
