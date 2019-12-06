package ca.bcit.comp2522.labs.lab12;

import java.util.ArrayList;

/**
 * Represents a Node.
 *
 * @author Tommy May & Frances Mach
 * @version 2019
 */
public class Node {
    private int nodeValue;
    private ArrayList<Integer> links;
    private boolean visited;

    /**
     * Instantiates a node object from a String, and it's integer value.
     * @param nodeString a node and it's links in String form.
     * @param nodeValue an int
     */
    public Node(String nodeString, int nodeValue) {
        links = new ArrayList<>();
        for (int i = 0; i < nodeString.length(); i++) {
            links.add(Integer.parseInt(nodeString.substring(i, i + 1)));
        }
        this.visited = false;
        this.nodeValue = nodeValue;
    }

    /**
     * Returns the value stored inside a Node.
     * @return nodeValue an int
     */
    public int getNodeValue() {
        return nodeValue;
    }

    /**
     * Returns the links to other nodes in a Node.
     * @return links an ArrayList of int
     */
    public ArrayList<Integer> getLinks() {
        return links;
    }

    /**
     * Returns the visitation state of a node.
     * @return visited a boolean
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets the visitation state of a node.
     * @param visited a boolean
     */
    public void visit(boolean visited) {
        this.visited = visited;
    }
}