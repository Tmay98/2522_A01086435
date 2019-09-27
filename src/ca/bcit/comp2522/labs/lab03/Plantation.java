package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Plantation  {

    public static final int TREES_PLANTED_RANGE = 991;

    public static final int TREES_PLANTED_MIN = 10;

    public static final int TREES_AGE_MAX = 1001;

    public static final int TREES_CIRCUMFERENCE_RANGE = 90;

    public static final int TREES_CIRCUMFERENCE_MIN = 10;

    private ArrayList<Tree> trees;

    private Random randomNumberGenerator  = new Random();

    public Plantation() {
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
        int treesPlanted = randomNumberGenerator.nextInt(TREES_PLANTED_RANGE) + TREES_PLANTED_MIN;
        for (int i = 0; i < treesPlanted; i++) {
            int treeAge = randomNumberGenerator.nextInt(TREES_AGE_MAX);
            double trunkCircumference = randomNumberGenerator.nextDouble()
                    * TREES_CIRCUMFERENCE_RANGE + TREES_CIRCUMFERENCE_MIN;
            Tree.species species = Tree.species.values()[randomNumberGenerator.nextInt(Tree.species.values().length)];
            this.add(new Tree(species, treeAge, trunkCircumference));
        }
        return this.trees.size();
    }

    public ArrayList<Tree> harvest(double circumferenceCutOff) {
        ArrayList<Tree> treesHarvested = new ArrayList<>();
        Iterator<Tree> it = this.trees.iterator();
        while (it.hasNext()) {
            Tree tree = it.next();
            if (tree.getTrunkCircumference() >= circumferenceCutOff) {
                treesHarvested.add(tree);
                it.remove();
            }
        }
        return treesHarvested;
    }

    @Override
    public String toString() {
        return "Plantation{"
                + "trees=" + trees
                + '}';
    }
}
