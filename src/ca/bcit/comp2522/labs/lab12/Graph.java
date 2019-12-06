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
    private ArrayList<Path> paths;

    public static class Path {

        private ArrayList<Node> nodes;

        public Path(ArrayList<Node> path) {
            this.nodes = path;
        }

        public ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    /**
     * Instantiates a graph object.
     */
    public Graph() {
        nodes = new ArrayList<>();
        paths = new ArrayList<>();
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

    /**
     * Returns an ArrayList of paths.
     * @return paths an ArrayList
     */
    public ArrayList<Path> getPaths() {
        return paths;
    }

    /**
     * Prints the shortest paths in the Paths ArrayList.
     */
    public void printShortestPaths() {
        int minLengthPath = paths.get(0).getNodes().size();

        for (Path path : paths) {
            if (path.getNodes().size() < minLengthPath) {
                minLengthPath = path.getNodes().size();
            }
        }

        for (Path path : paths) {
            if (path.getNodes().size() == minLengthPath) {
                for (Node node : path.getNodes()) {
                    System.out.print(node.getNodeValue());
                }
                System.out.println("\n");
            }
        }
        System.out.println("Minimum length path: " + minLengthPath);
    }

    /**
     * Finds the shortest between given nodes in a graph.
     * @param path an ArrayList of Nodes
     * @param visited an ArrayList of Nodes
     * @param startingNode a Node
     * @param destinationNode a Node
     */
    public void findShortestPath(
            ArrayList<Node> path,
            ArrayList<Node> visited,
            Node startingNode,
            Node destinationNode) {
        path.add(startingNode);
        if (startingNode.equals(destinationNode)) {
            paths.add(new Path(path));
            return;
        }

        for (int i = 0; i < startingNode.getLinks().size(); i++) {
            if (startingNode.getLinks().get(i) == 1) {
                ArrayList<Node> tempVisited = new ArrayList<>(visited);
                tempVisited.add(startingNode);
                if (!(tempVisited.contains(nodes.get(i)))) {
                    findShortestPath(
                            new ArrayList<>(path),
                            tempVisited,
                            nodes.get(i),
                            destinationNode);
                }
            }
        }
    }


}
