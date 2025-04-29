package graph;

public class Edge {
    private final int from;  // The starting node of the edge
    private final int to;    // The ending node of the edge
    private final int capacity;  // The maximum capacity of the edge
    private int flow;
    private Edge backwardEdge;      // The corresponding edge in the residual graph// The current flow on the edge

    // Constructor to initialize the edge
    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;  // Initial flow is 0
    }

    // Getters and setters for the edge's properties
    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getFlow() {
        return flow;
    }

    public Edge getBackwardEdge() {
        return backwardEdge;
    }

    public void setBackwardEdge(Edge backwardEdge) {
        this.backwardEdge = backwardEdge;
    }

    // Helper method to calculate the residual capacity (capacity - flow)
    public int getResidualCapacity() {
        return capacity - flow;
    }

    public void addFlow(int delta) {
        flow += delta;
    }
}
