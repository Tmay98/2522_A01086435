package ca.bcit.comp2522.labs.lab12;

import java.util.ArrayList;

/**
 * Represents a Node.
 *
 * @author Tommy May & Frances Mach
 * @version 2019
 */
public class Node {
    private ArrayList<Integer> links;
    private boolean visited;

    public ArrayList<Integer> getLinks() {
        return links;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node(String connections) {
        links = new ArrayList<>();
        for (int i = 0; i < connections.length(); i++) {
            links.add(Integer.parseInt(connections.substring(i, i + 1)));
        }
        visited = false;
    }

    public static void main(String[] args) {
        Node test = new Node("0101");
        System.out.println(test.links);
    }
}
