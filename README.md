# Max Flow Algorithm - Ford-Fulkerson

## Overview
This project implements the **Ford-Fulkerson algorithm** to solve the **Maximum Flow Problem** using a **Depth-First Search (DFS)** approach. The algorithm finds the maximum possible flow from a source node to a sink node in a flow network, where the edges have given capacities.

### Key Features:
- Implements the Ford-Fulkerson method for computing the maximum flow.
- Uses **DFS** to find augmenting paths in the residual graph.
- Designed to work with directed graphs with capacities and residuals.

## Algorithm
The algorithm iteratively finds augmenting paths in the graph and increases the flow along these paths until no more augmenting paths can be found. It updates the capacities of edges as flow is pushed through them.

**Key Data Structures**:
- **Adjacency List**: Represents the graph.
- **Edge Object**: Stores the capacity, flow, and residual capacity of each edge.
- **Parent Array**: Used to reconstruct augmenting paths found by DFS.
- **Visited Array**: Used to mark nodes during DFS traversal.

  ## Project Scope
https://docs.google.com/document/d/1X8iJj6btm4DvTv3X66p-NvgFLxhaNxQxJ6YlL-8Ru1c/edit?usp=sharing


## Project Structure

```
NetworkFlow/
├── src/                          # Source code directory
│   ├── graph/                    # Package for graph-related code
│   │   ├── Graph.java             # Class for graph representation
│   │   ├── Edge.java              # Class to represent an edge
│   │   └── AdjacencyList.java     # Adjacency List structure
│   ├── parser/                   # Package for file parsing
│   │   └── NetworkParser.java     # Class to parse the input file
│   ├── algorithms/                # Package for algorithm-related code
│   │   ├── MaxFlow.java           # Class to implement Ford-Fulkerson or Edmonds-Karp
│   │   └── ShortestPath.java      # Class for Shortest Path algorithm (optional for future use)
│   ├── utils/                     # Utility classes (optional)
│   │   └── FileUtils.java         # Class for file handling (optional)
│   └── Main.java                  # Entry point to run the program
└──bench mark # the collection of files provide by the module team
├── ...
          # Entry point for running the algorithm with a sample graph
```

### Key Classes
- **MaxFlow.java**: Implements the Ford-Fulkerson algorithm.
- **Graph.java**: Represents the graph and holds the adjacency list of edges.
- **Edge.java**: Defines the edge structure, including capacity and flow.
- **Main.java**: Runs the example and outputs the results.

## Prerequisites
- **Java 8 or higher**: This project is developed in Java, and you should have JDK 8 or above installed.

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/Judinus10/algoPro.git
   cd <project-directory>
   ```

2. Compile the Java files:

   ```bash
   javac -d bin src/algorithms/*.java src/graph/*.java src/Main.java
   ```

3. Run the program:

   ```bash
   java Main
   ```

   This will run the Ford-Fulkerson algorithm on a sample graph and print the maximum flow and augmenting paths to the console.

## Example Output

After running the program, the console output will display the maximum flow and the individual augmenting paths with their flow values. For example:

```
Maximum flow: 15
Flow values:
f(0,1) = 10
f(1,3) = 10
f(0,2) = 5
f(2,3) = 5

Improvement steps:
Step 1:
  Path: 0 -> 1 -> 3
  Bottleneck: 10
Step 2:
  Path: 0 -> 2 -> 3
  Bottleneck: 5
```

## Performance
- **Time Complexity**: O(E × max_flow), where `E` is the number of edges and `max_flow` is the total flow.
- **Space Complexity**: O(V + E), where `V` is the number of vertices and `E` is the number of edges.

## Contributing

Feel free to fork the repository, create a branch, and submit a pull request with improvements or bug fixes. Contributions are welcome!

## License

This project is open-source and available under the MIT License.

---
