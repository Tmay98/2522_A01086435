package ca.bcit.comp2522.labs.lab12;

import java.util.ArrayList;

public class Node {
    private ArrayList<Integer> links;

    public ArrayList<Integer> getLinks() {
        return links;
    }

    public Node(String connections) {
        links = new ArrayList<>();
        for (int i = 0; i < connections.length(); i++) {
            links.add(Integer.parseInt(connections.substring(i, i + 1)));
        }
    }

    public static void main(String[] args) {
        Node test = new Node("0101");
        System.out.println(test.links);
    }
}
