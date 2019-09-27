package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Planatation {

    private ArrayList<Tree> trees;

    private Random randomNumberGenerator  = new Random();

    public Planatation() {
        this.trees = new ArrayList<>();
    }

    public int add(Tree tree) {
        this.trees.add(tree);
        return this.trees.size();
    }

    public int size() {
        return this.trees.size();
    }

    public int seed() {
        int treesPlanted = randomNumberGenerator.nextInt(991) + 10;
        for (int i = 0; i < treesPlanted; i++) {
            int treeAge = randomNumberGenerator.nextInt(1001);
            double trunkCircumference = randomNumberGenerator.nextDouble() * 90 + 10;
            int speciesIndex = randomNumberGenerator.nextInt(Tree.species.values().length);
            this.add(new Tree(Tree.species.values()[speciesIndex],
                    treeAge, trunkCircumference));
        }
        return this.trees.size();
    }

    public ArrayList<Tree> harvest(double circumferenceCutOff) {
        ArrayList<Tree> treesHarvested = new ArrayList<>();
        Iterator<Tree> it = this.trees.iterator();
        Tree tree;
        while (it.hasNext()) {
            tree = it.next();
            if (tree.getTrunkCircumference() >= circumferenceCutOff) {
                treesHarvested.add(tree);
                it.remove();
            }
        }
        return treesHarvested;
    }

    public static void main(String[] args) {
        Planatation testPlant = new Planatation();
        int test = testPlant.seed();
        ArrayList<Tree> harvested = new ArrayList<>();
        harvested = testPlant.harvest(60.0);
    }
}
