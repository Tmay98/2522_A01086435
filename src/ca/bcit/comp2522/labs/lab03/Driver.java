package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Plantation lotuslandLumber = new Plantation();
        for (int i = 0; i < 10; i++) {
            lotuslandLumber.seed();
        }
        ArrayList<Tree> harvested = lotuslandLumber.harvest(80);
        System.out.println("There were " + harvested.size() + " Trees harvested.");
    }
}
