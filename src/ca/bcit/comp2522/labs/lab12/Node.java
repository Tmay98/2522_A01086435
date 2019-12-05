package ca.bcit.comp2522.labs.lab12;

import java.util.ArrayList;

/**
 * Represents a Node.
 *
 * @author Tommy May & Frances Mach
 * @version 2019
 */
public class Node {
    int nodeValue;
    private ArrayList<Integer> links;
    private boolean visited;

    public int getNodeValue() {
        return nodeValue;
    }

    public ArrayList<Integer> getLinks() {
        return links;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit(boolean visited) {
        this.visited = visited;
    }

    public Node(String connections, int nodeValue) {
        links = new ArrayList<>();
        for (int i = 0; i < connections.length(); i++) {
            links.add(Integer.parseInt(connections.substring(i, i + 1)));
        }
        this.visited = false;
        this.nodeValue = nodeValue;
    }
}