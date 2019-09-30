package ca.bcit.comp2522.assignments.a1;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Random rand = new Random();
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("test",300,40,7, 0.75);
        for(int i = 0; i < 300; i++) {
            pool.addGuppy(new Guppy("testGenus",
                    "testSpecies",
                    rand.nextInt(14),
                    rand.nextBoolean(),
                    0,
                    rand.nextDouble()));

        }
        ecosystem.addPool(pool);
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many weeks would you like to run the simulation for?");
        int weeks = scanner.nextInt();
        ecosystem.simulate(weeks);
    }
}
