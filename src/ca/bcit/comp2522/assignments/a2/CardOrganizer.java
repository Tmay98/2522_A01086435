package ca.bcit.comp2522.assignments.a2;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Objects;

public class CardOrganizer {
    private ArrayList<Card> cardList = new ArrayList<>();

    public static void main(String[] args) {

        CardOrganizer cardOrganizer = new CardOrganizer();
        cardOrganizer.createAdditionalIdentificationCards();
        cardOrganizer.createBusinessCards();
        cardOrganizer.createDiscountRewardCard();
        cardOrganizer.createIdentificationCards();
        cardOrganizer.createInsuranceCard();
        cardOrganizer.createMembershipCard();
        cardOrganizer.createPersonalBusinessCard();
        cardOrganizer.createPointsRewardCard();
        cardOrganizer.createStampRewardCard();
        cardOrganizer.createTicket();
        cardOrganizer.createTransitCard();

        cardOrganizer.printCards(); // Prints out all the cards in cardList.

        System.out.println(cardOrganizer.cardList.size());         //There are a total of 35 cards in this assignment.
    }

    public void printCards() {
        for (Card card : this.cardList) {
            System.out.println(card.toString());
            System.out.println();
        }
    }

    public void createAdditionalIdentificationCards() {
        AdditionalIdentification graduateUniversityOfBritishColumbiaStudentCard = new AdditionalIdentification(
                "UBC",
                "Graduate",
                true,
                "This card is issued to a Graduate from UBC",
                "12345678",
                "29424107463837",
                new IssueAndExpiryDate("02/05/14", "08/31/17"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(graduateUniversityOfBritishColumbiaStudentCard);

    }
    public void createBusinessCards() {

        BusinessCard danboRestaurantCard = new BusinessCard(
                "Danbo",
                "Danbo",
                true,
                "Fukouoka-Style Tonkotsu Ramen",
                new ContactInformation("6045598112","info@ramendanbo.com","11:00 a.m. to 11:00 p.m."),
                "1333 Robson St., Vancouver, BC V6E 1C6");
        cardList.add(danboRestaurantCard);

        BusinessCard kanzandoArt = new BusinessCard("Kanzando",
                "OldArtKanzando",
                true,
                "A business card for art.",
                new ContactInformation("0755610126","N@A","10:30 A.M. to 6:00 P.M."),
                "Japanese Kanji address");
        cardList.add(kanzandoArt);

        BusinessCard luckyCameraShop = new BusinessCard("Lucky",
                "LuckyCameraShop",
                true,
                "A business card for Lucky Camera Shop",
                new ContactInformation("0333547898", "N@A", "10:00 A.M. to 8:00 P.M."),
                "160-0022 3-3-9 Shinjuku Shinjuku-ku Tokyo Japan");
        cardList.add(luckyCameraShop);

        BusinessCard legendaryBootCompany = new BusinessCard(
                "Legendary Boot Company",
                "Legendary Boot Company",
                true,
                "Personal Business Card for Bob McLean",
                new ContactInformation("9154125541", "bob@legendarybootco.com", "N/A"),
                "El Paso, Texas");
        cardList.add(legendaryBootCompany);

        BusinessCard maryWilsonBusinessCard = new BusinessCard(
                "BCIT",
                "Business Card",
                true,
                "Business Card for Mary Wilson",
                new ContactInformation("6044328929", "mwilson5@bcit.ca", "N/A"),
                "3700 Willingdon Avenue, Burnaby B.C., Canada, V5G 3H2");
        cardList.add(maryWilsonBusinessCard);

    }
    public void createDiscountRewardCard() {

        DiscountRewardCard mrRedCafe = new DiscountRewardCard(
                "Mr Red Cafe",
                "Quintessence of Vietnamese Cuisine",
                true,
                "A Discount Card for Mr Red Cafe",
                10);
        cardList.add(mrRedCafe);

        DiscountRewardCard dispensaryDiscountCard = new DiscountRewardCard(
                "The Dispensary",
                "Sorry For the Inconvenience",
                true,
                "A apology card with a discount",
                10);
        cardList.add(dispensaryDiscountCard);
    }
    public void createIdentificationCards() {

        IdentificationCard studentCardUniversityOfBritishColumbia = new IdentificationCard("BCIT",
                "Student",
                true,
                "Student card for a BCIT student.",
                "A00987654",
                new IssueAndExpiryDate("00/00/00", "04/09/09"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(studentCardUniversityOfBritishColumbia);

        IdentificationCard vancouverPublicLibraryCard = new IdentificationCard(
                "Vancouver Public Library",
                "VPL",
                true,
                "A membership card to the Vancouver Public Library",
                "",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(vancouverPublicLibraryCard);

        IdentificationCard alumniCard = new IdentificationCard(
                "UBC",
                "alumni UBC A-Card",
                true,
                "An alumni card for UBC",
                "29424300117958",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(alumniCard);

        IdentificationCard vancouverArtGalleryCard = new IdentificationCard(
                "Vancouver Art Gallery",
                "Membership",
                true,
                "Identification card for a member of the Vancouver Art Gallery",
                "79683",
                new IssueAndExpiryDate("00/00/00", "06/18"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(vancouverArtGalleryCard);

        IdentificationCard mecCard = new IdentificationCard("Mountain Equipment CO-OP",
                "MEC Card",
                true,
                "A Identification Card for MEC",
                "16800004",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(mecCard);

        IdentificationCard govermentSocialInsuranceNumberCard = new IdentificationCard(
                "Employment and Immigration Canada",
                "Social Insurance Number",
                true,
                "This card contains a unique social insurance number that is issued to a Canadian citizen or permanent resident.",
                "589588141",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(govermentSocialInsuranceNumberCard);

        IdentificationCard sunrouteClubCard = new IdentificationCard("Sunroute",
                "Club Card",
                true,
                "A Club Card for Sunroute",
                "30092459",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"));
        cardList.add(govermentSocialInsuranceNumberCard);

    }
    public void createInsuranceCard() {
        InsuranceCard manulifeCard = new InsuranceCard(
                "Manulife",
                "Insurance Card",
                true,
                "A Insurance Card with Information",
                "987654",
                "0012321",
                new IssueAndExpiryDate("00/00/00", "00/00/00"),
                new Name("Christopher", "G", "Thompson"),
                "9505");
        cardList.add(manulifeCard);
    }
    public void createMembershipCard() {

        MembershipCard debitCardBankOfPoland = new MembershipCard(
                "Phony Credit Cards",
                "Bank of Poland Gold Card - The peasants card.",
                true, "A phony, novelty bank card.",
                "Standard");
        cardList.add(debitCardBankOfPoland);

        MembershipCard independentFlixxCard = new MembershipCard(
                "Independent Flixx Inc.",
                "Membership Card",
                true,
                "A membership to a Independent Flixx Inc.",
                "Standard");
        cardList.add(independentFlixxCard);

        MembershipCard legoCard = new MembershipCard(
                "Lego",
                "VIP Program",
                true,
                "A VIP Card for Lego",
                "Standard");
        cardList.add(legoCard);

        MembershipCard fairmontClubCard = new MembershipCard("Fairmont",
                "Fairmont President's Club",
                true,
                "A membership card for Fairmont",
                "Standard");
        cardList.add(fairmontClubCard);

        MembershipCard blackBondBooksCard = new MembershipCard(
                "Black Bond Books",
                "Readers Club Card",
                true,
                "Membership card to Black Bond Books.",
                "Standard");
        cardList.add(blackBondBooksCard);

        MembershipCard hmartDiscountCard = new MembershipCard(
                "H Mart",
                "Savings Card",
                true,
                "A membership card for H Mart",
                "Standard");
        cardList.add(hmartDiscountCard);
    }
    public void createPersonalBusinessCard() {

        PersonalBusinessCard flowersByMichaelPark = new PersonalBusinessCard(
                "Flowers By Michael",
                "Michael Park",
                true,
                "Personal business card for Michael Park",
                new ContactInformation("6046815567",
                        "info@flowersbymichaelbc.ca",
                        "N/A"),
                new ContactInformation("6046714234","N@A","N/A"),
                "1378 West Georgia Street, Vancouver, B.C., V6E 4S2");
        cardList.add(flowersByMichaelPark);
    }
    public void createPointsRewardCard() {

        PointsRewardCard airMilesCard = new PointsRewardCard(
                "Air Miles",
                "Air Miles Travel Card",
                true,
                "A Points Card for Air Miles",
                "82224440163",
                new IssueAndExpiryDate("00/00/00","06/94"),
                new Name("Christopher", "G", "Thompson"),
                1337);
        cardList.add(airMilesCard);

        PointsRewardCard plumRewardsCard = new PointsRewardCard(
                "Plum",
                "Plum Rewards, Enrich Your Life",
                true,
                "A Rewards Plum Card",
                "500028606142", new IssueAndExpiryDate("00/00/00","00/00/00"),
                new Name("Christopher", "G", "Thompson"), 1337);
        cardList.add(plumRewardsCard);

        PointsRewardCard airMilesCardTravelAndMore = new PointsRewardCard(
                "Air Miles",
                "Travel and More, Air Miles",
                true,
                "A exclusive Air Miles card.",
                "123433",
                new IssueAndExpiryDate("06/94", "00/00"),
                new Name("Christopher", "G", "Thompson"),
                1337);
        cardList.add(airMilesCardTravelAndMore);

        PointsRewardCard jalMileageBank = new PointsRewardCard(
                "JAL",
                "Mileage Bank Card",
                true,
                "A points card for JAL",
                "403954425",
                new IssueAndExpiryDate("00/00", "00/00"),
                new Name("Christopher", "G", "Thompson"),
                1337);
        cardList.add(jalMileageBank);


        PointsRewardCard sceneMovieCard = new PointsRewardCard(
                "Cineplex",
                "Scene",
                true,
                "A points card for the Scene program.",
                "6046468852159342",
                new IssueAndExpiryDate("00/00", "00/00"),
                new Name("Christopher", "G", "Thompson"),
                1337);
        cardList.add(sceneMovieCard);
    }
    public void createStampRewardCard() {
        StampRewardCard wholeFoodsCard = new StampRewardCard("Whole Foods",
                "Buy 10 rotisserie chickens get one FREE!",
                true,
                "Stamp card that allows redemption, upon completion, for a chicken",
                10,
                3,
                "Big ol' chicken");
        cardList.add(wholeFoodsCard);

    }
    public void createTicket() {

        Ticket ghibliTicketForHowlsMovingCastle = new Ticket(
                "Ghibli Musuem",
                "Ticket",
                true,
                "A ticket to the Ghibli Museum",
                1000);
        cardList.add(ghibliTicketForHowlsMovingCastle);

        Ticket ghibliTicketForPonyoByTheCliffSide = new Ticket(
                "Ghibli Musuem",
                "Ticket",
                true,
                "A ticket to the Ghibli Museum",
                1000);
        cardList.add(ghibliTicketForPonyoByTheCliffSide);
    }
    public void createTransitCard() {

        TransitCard helloKittyTransitCard = new TransitCard(
                "Suica",
                "ICOCA",
                true,
                "Suica Transit Card",
                0.0,
                "JW301B15042825970",
                new IssueAndExpiryDate("00/00","00/00"));
        cardList.add(helloKittyTransitCard);

        TransitCard londonOysterTransitCard = new TransitCard(
                "Transport for London",
                "Oyster",
                true,
                "A transit card for Oyster",
                0.0,
                "060054294844",
                new IssueAndExpiryDate("00/00","00/00"));
        cardList.add(londonOysterTransitCard);

        TransitCard japanEndlessDiscoveryPrimaryTransitCard = new TransitCard(
                "Suica",
                "Japan Endless Discovery",
                true,
                "Suica Transit Card",
                0.0,
                "JE338D13090202315",
                new IssueAndExpiryDate("00/00","00/00"));
        cardList.add(japanEndlessDiscoveryPrimaryTransitCard);

        TransitCard japanEndlessDiscoverySecondaryTransitCard = new TransitCard(
                "Suica",
                "Japan Endless Discovery",
                true,
                "Suica Transit Card",
                0.0,
                "JE338D13090202316",
                new IssueAndExpiryDate("00/00","00/00"));
        cardList.add(japanEndlessDiscoverySecondaryTransitCard);
    }

}
