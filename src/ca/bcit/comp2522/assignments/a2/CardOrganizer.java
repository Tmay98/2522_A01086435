package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;

public class CardOrganizer {
    ArrayList<Card> cardList = new ArrayList<>();

    public static void main(String[] args) {
        //todo Total amount of cards is 35.

//todo print out collection of cards
    }

    public void createAdditionalIdentificationCards() {
        //ubc Graduate card
        IdentificationCard graduateUniversityOfBritishColumbiaCard = new AdditionalIdentification(
                "UBC",
                "Graduate",
                true,
                "This card is issued to a Graduate from UBC",
                "12345678",
                new IssueAndExpiryDate("02/05/14", "08/31/17"),
                new Name("Christopher", "G","Thompson") );
        //gov't sin card
        IdentificationCard govermentSocialInsuranceNumberCard = new AdditionalIdentification(
                "Employment and Immigration Canada",
                "Social Insurance Number",
                true,
                "This card contains a unique social insurance number that is issued to a Canadian citizen or permanent resident.",
                "589 588 141",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));

    }
    public void createBusinessCards() {
        //danbo restaurant todo stamps reward
        BusinessCard danboRestaurantCard = new BusinessCard(
                "Danbo",
                "Danbo",
                true,
                "Fukouoka-Style Tonkotsu Ramen",
                new ContactInformation("6045598112","info@ramendanbo.com","11:00 a.m. to 11:00 p.m."),
                "1333 Robson St., Vancouver, BC V6E 1C6");

        // Old art Kanzando
        BusinessCard kanzandoArt = new BusinessCard("Kanzando",
                "Old Art Kanzando",
                true,
                "A business card for art.",
                new ContactInformation("0755610126","N/A","10:30 A.M. to 6:00 P.M."),
                "Japanese Kanji address");
        // Lucky Camera Shop
        BusinessCard luckyCameraShop = new BusinessCard("Lucky",
                "Lucky Camera Shop",
                true,
                "A business card for Lucky Camera Shop",
                new ContactInformation("0333547898", "N/A", "10:00 A.M. to 8:00 P.M."),
                "160-0022 3-3-9 Shinjuku Shinjuku-ku Tokyo Japan");
        // legendary boot company
        BusinessCard legendaryBootCompany = new BusinessCard(
                "Legendary Boot Company",
                "Legendary Boot Company",
                true,
                "Personal Business Card for Bob McLean",
                new ContactInformation("9154125541", "bob@legendarybootco.com", "N/A"),
                "El Paso, Texas");

    }
    public void createDiscountRewardCard() {

        // dispenary discount
        DiscountRewardCard dispenaryDiscountCard = new DiscountRewardCard("The Dispensary", "Sorry For the Inconvenience", true, "A apology card with a discount", 10);
    }
    public void createIdentificationCards() {
        // student card
        IdentificationCard studentCardUniversityOfBritishColumbia = new IdentificationCard("BCIT",
                "Student",
                true,
                "Student card for a BCIT student.",
                "A00987654",
                new IssueAndExpiryDate("00/00/00", "04/09/09"),
                new Name("Christopher", "G", "Thompson"));
        //VPL card
        IdentificationCard vancouverPublicLibraryCard = new IdentificationCard(
                "Vancouver Public Library",
                "VPL",
                true,
                "A membership card to the Vancouver Public Library",
                "",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        // AlumniUBC A-Card
        IdentificationCard alumniCard = new IdentificationCard(
                "UBC",
                "alumni UBC A-Card",
                true,
                "An alumni card for UBC",
                "2 9424 30011 7958",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        // vancouver art gallery
        IdentificationCard vancouverArtGalleryCard = new IdentificationCard(
                "Vancouver Art Gallery",
                "Membership",
                true,
                "Identification card for a member of the Vancouver Art Gallery",
                "79683",
                new IssueAndExpiryDate("00/00/00", "06/18"),
                new Name("Christopher", "G", "Thompson"));
    }
    public void createInsuranceCard() {
        //manulife card
    }
    public void createMembershipCard() {
        //bank of poland
        //independent flixx
        // lego vip card
        // mec todo include id#
        // MR RED CAFE
        // Fairmont President's Club
        // Black Bond Books membership card

        // hmart todo serial / id number
        MembershipCard hmartDiscountCard = new MembershipCard("H Mart", "Savings Card", true, "A membership card for H Mart", "Standard");

    }
    public void createPersonalBusinessCard() {
        // bcit mary wilson
        // FLower By Michael Park
        PersonalBusinessCard flowersByMichaelPark = new PersonalBusinessCard(
                "Flowers By Michael",
                "Michael Park",
                true,
                "Personal business card for Michael Park",
                new ContactInformation("6046815567","info@flowersbymichaelbc.ca","N/A"), new ContactInformation("6046714234","N/A","N/A"),
                "1378 West Georgia Street, Vancouver, B.C., V6E 4S2");


    }
    public void createPointsRewardCard() {
        //air miles todo includes id#
        // plum rewards todo serial
        // sunroute club point card edy todo serial
        // aeroplan todo serial
        // JAL mileage bank //todo serial id number
        // AIR MILES //todo id
    }
    public void createStampRewardCard() {
        StampRewardCard wholeFoodsCard = new StampRewardCard("Whole Foods",
                "Buy 10 rotisserie chickens get one FREE!",
                true,
                "Stamp card that allows redemption, upon completion, for a chicken",
                10,
                3,
                "Big ol' chicken");

    }
    public void createTicket() {
        // studio ghibli ticket
        // 2nd studio ghibli ticket
    }
    public void createTransitCard() {
        //hello kitty
        // oyster london
        // two japan endless discovery todo includes a id number
    }

}
