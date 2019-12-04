package ca.bcit.comp2522.labs.lab12;

import java.util.ArrayList;

/**
 * Represents a Graph.
 *
 * @author Tommy May & Frances Mach
 * @version 2019
 */
public class Graph {
    private ArrayList<Node> nodes;

    /**
     * Instantiates a graph object.
     */
    public Graph() {
        nodes = new ArrayList<>();
    }
    /**
     * Sets the nodes of the graph.
     * @param nodes an ArrayList of nodes
     */
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    /**
     * Returns an ArrayList of nodes.
     * @return nodes an ArrayList
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void findShortestPath() {

    }


}
