//Sebastian Xayaphet
//COSC 2336
//Programming Assignment 11+12
//Due: 11/15/2023
//Write a program that reads a connected graph from a file. The graph is stored in a file using the format specified below. 
//Your program should prompt the user to enter the name of the file then two vertices, and should display a shortest path between the two vertices. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Node class to represent vertices and their distances
class Node {
 int vertex;
 int distance;

 public Node(int vertex, int distance) {
     this.vertex = vertex;
     this.distance = distance;
 }
}
public class ShortestPath {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for file name
        System.out.print("Enter a file name: ");
        String fileName = input.nextLine();

        try {
            // Read graph from file
            Graph graph = readGraphFromFile(fileName);

            // Prompt user for two vertices
            System.out.print("Enter two vertices (integer indexes): ");
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();

            // Find and display the shortest path
            ArrayList<Integer> shortestPath = findShortestPath(graph, startVertex, endVertex);
            System.out.println("A path from " + startVertex + " to " + endVertex + ": " + shortestPath);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        input.close();
    }

    // Method to read a connected graph from a file
    private static Graph readGraphFromFile(String fileName) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));

        // Read the number of vertices
        int numVertices = fileScanner.nextInt();
        fileScanner.nextLine(); // Consume the newline character

        // Create an empty graph
        Graph graph = new Graph(numVertices);

        // Read edges from the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] edges = line.split("\\|");

            for (String edge : edges) {
                String[] vertices = edge.trim().split(", ");
                int fromVertex = Integer.parseInt(vertices[0]);
                for (int i = 1; i < vertices.length; i += 2) {
                    int toVertex = Integer.parseInt(vertices[i]);
                    int weight = Integer.parseInt(vertices[i + 1]);
                    graph.addEdge(fromVertex, toVertex, weight);
                }
            }
        }

        fileScanner.close();
        return graph;
    }

 
 // Method to find the shortest path using Dijkstra's algorithm
    private static ArrayList<Integer> findShortestPath(Graph graph, int startVertex, int endVertex) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        int[] distance = new int[graph.getNumVertices()];
        int[] parent = new int[graph.getNumVertices()];
        boolean[] visited = new boolean[graph.getNumVertices()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        priorityQueue.add(new Node(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll().vertex;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            for (Edge edge : graph.getEdges(currentVertex)) {
                int neighbor = edge.toVertex;
                int newDistance = distance[currentVertex] + edge.weight;

                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    parent[neighbor] = currentVertex;
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
        }

        // Reconstruct the path
        ArrayList<Integer> path = new ArrayList<>();
        int current = endVertex;

        while (current != startVertex) {
            path.add(0, current);
            current = parent[current];
        }
        path.add(0, startVertex);

        return path;
    }


 // Graph class representing the connected graph
    static class Graph {
        private final int numVertices;
        private final ArrayList<ArrayList<Edge>> adjacencyList;

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            this.adjacencyList = new ArrayList<>(numVertices);

            for (int i = 0; i < numVertices; i++) {
                this.adjacencyList.add(new ArrayList<>());
            }
        }

        public int getNumVertices() {
            return numVertices;
        }

        public void addEdge(int fromVertex, int toVertex, int weight) {
            this.adjacencyList.get(fromVertex).add(new Edge(toVertex, weight));
        }

        public ArrayList<Edge> getEdges(int vertex) {
            return this.adjacencyList.get(vertex);
        }

        public ArrayList<Integer> getNeighbors(int vertex) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (Edge edge : adjacencyList.get(vertex)) {
                neighbors.add(edge.toVertex);
            }
            return neighbors;
        }
    }


    // Edge class representing a weighted edge
    static class Edge {
        private final int toVertex;
        private final int weight;

        public Edge(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }
}


