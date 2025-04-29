package parser;

import graph.Graph;
import java.io.*;

public class NetworkParser {

    // Method to parse the input file and create a graph
    public static Graph parseNetworkFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int numberOfNodes = Integer.parseInt(reader.readLine().trim()); // First line is the number of nodes
            Graph network = new Graph(numberOfNodes);

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("//")) {  // Ignore comments
                    String[] parts = line.trim().split("\\s+");
                    int fromNode = Integer.parseInt(parts[0]);
                    int toNode = Integer.parseInt(parts[1]);
                    int capacity = Integer.parseInt(parts[2]);
                    network.addEdge(fromNode, toNode, capacity);
                }
            }

            reader.close();
            return network;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
