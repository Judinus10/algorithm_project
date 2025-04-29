import graph.Graph;
import algorithms.MaxFlow;
import parser.NetworkParser;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Ask the user to select a file from the benchmark folder
        String inputFile = selectFileFromBenchmarkFolder();

        // If no file is selected, exit the program
        if (inputFile == null) {
            System.out.println("No file selected. Exiting...");
            return;
        }

        // Parse the network from the selected file
        Graph network = NetworkParser.parseNetworkFromFile(inputFile);

        // Check if the network was successfully parsed
        if (network == null) {
            System.out.println("Failed to parse the network. Please check the input file.");
            return;
        }

        // Create a graph from the parsed network
        Graph graph = network.getGraph();

        // Specify the source and sink nodes (Example: 0 is the source, and the last node is the sink)
        int source = 0;
        int sink = graph.getAdjList().size() - 1;

        // Create an instance of MaxFlow and calculate the maximum flow
        MaxFlow maxFlow = new MaxFlow(graph);
        int result = maxFlow.fordFulkerson(source, sink);

        // Print the result
        System.out.println("The maximum flow from source " + source + " to sink " + sink + " is: " + result);
    }

    // Method to open a file chooser and let the user select a file from the benchmark folder
    public static String selectFileFromBenchmarkFolder() {
        JFileChooser fileChooser = new JFileChooser();
//        File benchmarkFolder = new File("benchmark");  //  path for benchmark folder
//        fileChooser.setCurrentDirectory(benchmarkFolder);
        fileChooser.setDialogTitle("Select a Network File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Show the file chooser and check if the user selected a file
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Return the selected file's path
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            // If no file was selected, return null
            return null;
        }
    }
}
