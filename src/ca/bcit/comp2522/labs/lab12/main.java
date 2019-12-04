package ca.bcit.comp2522.labs.lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of text file");
        String input = in.nextLine();
        ArrayList<Node> nodes = readFile(input);
        System.out.println(nodes.get(0).getLinks());
    }

    static ArrayList<Node> readFile(String path) throws IOException {
        ArrayList<Node> nodes = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            String st;
            while((st = br.readLine()) != null) {
                nodes.add(new Node(st));
            }
            return nodes;
        }
    }


}
