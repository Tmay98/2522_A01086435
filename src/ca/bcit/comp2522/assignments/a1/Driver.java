package ca.bcit.comp2522.assignments.a1;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many weeks would you like to run the simulation for?");
        int weeks = scanner.nextInt();
        ecosystem.simulate(weeks);
    }
}
