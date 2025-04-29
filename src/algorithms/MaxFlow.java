// src/algorithms/MaxFlow.java
package algorithms;

import graph.Graph;
import graph.Edge;
import java.util.*;

public class MaxFlow {
    private Graph graph;

    // Constructor
    public MaxFlow(Graph graph) {
        this.graph = graph;
    }

    // Depth-First Search (DFS) to find an augmenting path
    private boolean dfs(int source, int sink, boolean[] visited, int[] parent) {
        visited[source] = true;

        if (source == sink) {
            return true;
        }

        // Explore all neighbors of source
        for (Edge edge : graph.getAdjList().getEdges(source)) {
            int v = edge.getTo();

            if (!visited[v] && edge.getResidualCapacity() > 0) {
                parent[v] = source;
                if (dfs(v, sink, visited, parent)) {
                    return true;  // Found an augmenting path
                }
            }
        }
        return false;  // No augmenting path found
    }

    public int fordFulkerson(int source, int sink) {
        int maxFlow = 0;
        int[] parent = new int[graph.getAdjList().size()];
        List<String> improvementSteps = new ArrayList<>();
        Map<String, Integer> flowMap = new LinkedHashMap<>();

        while (true) {
            boolean[] visited = new boolean[graph.getAdjList().size()];
            Arrays.fill(parent, -1);

            if (!dfs(source, sink, visited, parent)) {
                break;
            }

            // Find the bottleneck (minimum residual capacity)
            int pathFlow = Integer.MAX_VALUE;
            List<Integer> path = new ArrayList<>();
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                path.add(v);

                for (Edge edge : graph.getAdjList().getEdges(u)) {
                    if (edge.getTo() == v) {
                        pathFlow = Math.min(pathFlow, edge.getResidualCapacity());
                        break;
                    }
                }
            }
            path.add(source);
            Collections.reverse(path);

            // Store path and bottleneck info
            StringBuilder step = new StringBuilder();
            step.append("  Path: ");
            for (int i = 0; i < path.size(); i++) {
                step.append(path.get(i));
                if (i < path.size() - 1) step.append(" -> ");
            }
            step.append("\n  Bottleneck: ").append(pathFlow);
            improvementSteps.add(step.toString());

            // Update flows along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];

                // Forward edge
                for (Edge edge : graph.getAdjList().getEdges(u)) {
                    if (edge.getTo() == v) {
                        edge.setFlow(edge.getFlow() + pathFlow);
                        flowMap.put("f(" + u + "," + v + ")", edge.getFlow());
                        break;
                    }
                }

                // Backward edge
                for (Edge edge : graph.getAdjList().getEdges(v)) {
                    if (edge.getTo() == u) {
                        edge.setFlow(edge.getFlow() - pathFlow);
                        flowMap.put("f(" + v + "," + u + ")", edge.getFlow());
                        break;
                    }
                }
            }

            maxFlow += pathFlow;
        }

        // Print final results
        System.out.println("Maximum flow: " + maxFlow);
        System.out.println("Flow values:");
        for (String key : flowMap.keySet()) {
            int flow = flowMap.get(key);
            if (flow > 0) {
                System.out.println(key + " = " + flow);
            }
        }

        System.out.println("\nImprovement steps:");
        for (int i = 0; i < improvementSteps.size(); i++) {
            System.out.println("Step " + (i + 1) + ":\n" + improvementSteps.get(i));
        }

        return maxFlow;
    }

}
