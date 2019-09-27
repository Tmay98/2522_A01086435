package ca.bcit.comp2522.labs.lab03;

public class Tree {

    /**
     * Enumeration of species.
     */
    enum species { MAPLE, ARBUTUS, BLUE_SPRUCE};

    private species type;

    private int ageInYears;

    private double trunkCircumference;

    public Tree(species type, int ageInYears, double trunkCircumference) {
        this.type = type;
        this.ageInYears = ageInYears;
        this.trunkCircumference = trunkCircumference;
    }

    public Tree(int ageInYears, double trunkCircumference) {
        this.type = species.MAPLE;
        this.ageInYears = ageInYears;
        this.trunkCircumference = trunkCircumference;
    }

    public double getTrunkCircumference() {
        return trunkCircumference;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public species getType() {
        return type;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public void setTrunkCircumference(double trunkCircumference) {
        this.trunkCircumference = trunkCircumference;
    }
}

