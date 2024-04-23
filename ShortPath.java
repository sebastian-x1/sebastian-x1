import java.io.*;
import java.util.*;

public class ShortPath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String fileName = input.nextLine();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            int numVertices = fileScanner.nextInt();
            WeightedGraph graph = new WeightedGraph(numVertices);

            for (int i = 0; i < numVertices; i++) {
                int vertex = fileScanner.nextInt();
                int numEdges = fileScanner.nextInt();

                for (int j = 0; j < numEdges; j++) {
                    int targetVertex = fileScanner.nextInt();
                    int weight = fileScanner.nextInt();
                    graph.addEdge(vertex, targetVertex, weight);
                }
            }

            // Get user input for start and end vertices with input validation
            int startVertex, endVertex;
            try {
                System.out.print("Enter two vertices (integer indexes): ");
                startVertex = input.nextInt();
                endVertex = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter valid integer values.");
                return;
            }
            

            // Find the shortest path and display it
            List<Integer> shortestPath = graph.findShortestPath(startVertex, endVertex);
            System.out.println("A path from " + startVertex + " to " + endVertex + ": " + shortestPath);
            System.out.print("A path from " + startVertex + " to " + endVertex + ": ");
            for (int vertex : shortestPath) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
}


class WeightedGraph {
    private int numVertices;
    private List<List<Edge>> adjacencyList;

    public WeightedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int target, int weight) {
        // Add an edge to the graph
        adjacencyList.get(source).add(new Edge(target, weight));
    }

    public List<Integer> findShortestPath(int startVertex, int endVertex) {
        // Initialize data structures for shortest path calculation
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.offer(new Node(startVertex, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            if (currentVertex == endVertex) {
                // Reconstruct and return the shortest path
                return reconstructPath(startVertex, endVertex, currentNode);
            }

            for (Edge neighbor : adjacencyList.get(currentVertex)) {
                int neighborVertex = neighbor.target;
                int neighborWeight = neighbor.weight;

                int newDistance = distance[currentVertex] + neighborWeight;

                if (newDistance < distance[neighborVertex]) {
                    distance[neighborVertex] = newDistance;
                    minHeap.offer(new Node(neighborVertex, newDistance));
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private List<Integer> reconstructPath(int startVertex, int endVertex, Node lastNode) {
        // Reconstruct and return the shortest path
        List<Integer> path = new ArrayList<>();
        int currentVertex = endVertex;

        while (currentVertex != startVertex) {
            path.add(currentVertex);
            currentVertex = lastNode.parent;
            lastNode = lastNode.predecessor;
        }

        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }

    private static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int distance;
        Node predecessor;
        int parent;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
