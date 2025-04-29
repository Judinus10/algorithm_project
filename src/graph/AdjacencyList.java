package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    private List<List<Edge>> adjList;  // List of edges for each node

    // Constructor to initialize the adjacency list
    public AdjacencyList(int numberOfNodes) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the adjacency list with both forward and backward edges
    public void addEdge(int from, int to, int capacity) {
        // Create the forward edge
        Edge forwardEdge = new Edge(from, to, capacity);
        adjList.get(from).add(forwardEdge);

        // Create the backward edge (initially with 0 capacity)
        Edge backwardEdge = new Edge(to, from, 0);
        adjList.get(to).add(backwardEdge);

        // Set the backward edge as a reference in the forward edge for easy flow updates
        forwardEdge.setBackwardEdge(backwardEdge);

        // Set the forward edge as a reference in the backward edge for easy flow updates
        backwardEdge.setBackwardEdge(forwardEdge);
    }

    // Get the list of edges for a given node
    public List<Edge> getEdges(int node) {
        return adjList.get(node);
    }

    // Get the total number of nodes (size of the adjacency list)
    public int size() {
        return adjList.size();
    }
}
