package ca.bcit.comp2522.labs.lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of text file");
        String input = in.nextLine();
        graph.setNodes(readFile(input));
    }

    static ArrayList<Node> readFile(String path) throws IOException {
        ArrayList<Node> nodes = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src\\ca\\bcit\\comp2522\\labs\\lab12\\" + path))) {
            String st;
            while((st = br.readLine()) != null) {
                nodes.add(new Node(st));
            }
            return nodes;
        }
    }


}
