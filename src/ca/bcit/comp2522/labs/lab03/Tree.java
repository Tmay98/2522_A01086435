package ca.bcit.comp2522.labs.lab03;

public class Tree {

    public enum species { MAPLE, ARBUTUS, BLUE_SPRUCE }

    private species type;

    private int ageInYears;

    private double trunkCircumference;

    public Tree(species type, int ageInYears, double trunkCircumference) {
        this.type = type;
        this.trunkCircumference = trunkCircumference;
        this.ageInYears = Math.max(ageInYears, 0);
    }

    public Tree(int ageInYears, double trunkCircumference) {
        this(species.MAPLE, ageInYears, trunkCircumference);
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

