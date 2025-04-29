// src/graph/Graph.java
package graph;

public class Graph {
    private AdjacencyList adjList;


    // Constructor to initialize the graph with the number of nodes
    public Graph(int numberOfNodes) {
        adjList = new AdjacencyList(numberOfNodes);
    }

    // Add an edge to the graph
    public void addEdge(int from, int to, int capacity) {
        adjList.addEdge(from, to, capacity);
    }

    // Get the adjacency list
    public AdjacencyList getAdjList() {
        return adjList;
    }

    // Get the graph (or adjacency list) object
    public Graph getGraph() {
        return this; // Returns the current graph instance
    }
}
