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
        System.out.println("Enter first node number");
        int firstNode = in.nextInt();
        System.out.println("Enter second node number");
        int secondNode = in.nextInt();
        graph.setNodes(readFile(input));
        graph.findShortestPath(new ArrayList<Node>(),
                new ArrayList<Node>(),
                graph.getNodes().get(firstNode),
                graph.getNodes().get(secondNode));
        graph.printShortestPaths();
    }

    /**
     * Reads a file.
     * @param path the Filepath
     * @return nodes an ArrayList of Node
     * @throws IOException an Exception if file is not opened correctly
     */
    static ArrayList<Node> readFile(String path) throws IOException {
        ArrayList<Node> nodes = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(
                             "src\\ca\\bcit\\comp2522\\labs\\lab12\\"
                                     + path))) {
            String st;
            int i = 0;
            while ((st = br.readLine()) != null) {
                nodes.add(new Node(st, i++));
            }
            return nodes;
        }
    }


}
