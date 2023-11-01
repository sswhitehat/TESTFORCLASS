import java.util.*;

public class Main {
        public static void main(String[] args) {
            // First network
            // Second network
            Network sampleNetwork2 = new Network(1000, 790);
            // Create a new NetGraph
            ArrayList<AdjacencyListHead> nodesList2 = new ArrayList<>();
            NetGraph networkGraph2 = new NetGraph(nodesList2);

            // Add nodes
            networkGraph2.insertNetNode(0, "E", 0, 0);
            networkGraph2.insertNetNode(1, "F", 1, 1);
            networkGraph2.insertNetNode(22, "G", 6, 0);
            networkGraph2.insertNetNode(3, "H", 0, 1);

            // Add links
            networkGraph2.addLink(networkGraph2.nodeFromIndex(0), networkGraph2.nodeFromIndex(1), 12);
            networkGraph2.addLink(networkGraph2.nodeFromIndex(1), networkGraph2.nodeFromIndex(2), 1.7);
            networkGraph2.addLink(networkGraph2.nodeFromIndex(2), networkGraph2.nodeFromIndex(3), 1);
            networkGraph2.addLink(networkGraph2.nodeFromIndex(3), networkGraph2.nodeFromIndex(0), 32.6);

            System.out.println("========== Testing second network ==========");
            testNetwork(sampleNetwork2);
        }

        private static void testNetwork(Network sampleNetwork) {
        Network sampleNetwork2 = new Network(1000, 200);
        // Create a new NetGraph
        ArrayList<AdjacencyListHead> nodesList = new ArrayList<>();
        NetGraph networkGraph = new NetGraph(nodesList);

        // Add nodes
        networkGraph.insertNetNode(0, "A", 0, 0);
        networkGraph.insertNetNode(1, "B", 1, 1);
        networkGraph.insertNetNode(2, "C", 2, 2);
        networkGraph.insertNetNode(3, "D", 3, 3);

        // Add links
        networkGraph.addLink(networkGraph.nodeFromIndex(0), networkGraph.nodeFromIndex(1), 177);
        networkGraph.addLink(networkGraph.nodeFromIndex(1), networkGraph.nodeFromIndex(2), 14.45545454);
        networkGraph.addLink(networkGraph.nodeFromIndex(2), networkGraph.nodeFromIndex(3), 78.43434434);

        // Test getNumNodes
        System.out.println("Number of nodes: " + networkGraph.getNumNodes());

        // Test getNumLinks
        System.out.println("Number of links: " + networkGraph.getNumLinks());

        // Test getNodeIndex
        System.out.println("Index of node B: " + networkGraph.getNodeIndex(networkGraph.nodeFromIndex(1)));

        // Test degree
        System.out.println("Degree of node B: " + networkGraph.degree(networkGraph.nodeFromIndex(1)));

        // Test getGraphMaxDegree
        System.out.println("Max degree: " + networkGraph.getGraphMaxDegree());

        // Test getAdjacents
        System.out.println("Adjacency list of node B: ");
        LinkedList<Adjacent> adjacents = networkGraph.getAdjacents(networkGraph.nodeFromIndex(1));
        for (Adjacent adj : adjacents) {
            System.out.println(adj.getNeighbor().getName() + ", weight: " + adj.getWeight());
        }

        // Test deleteNetNode
        networkGraph.deleteNetNode(networkGraph.nodeFromIndex(3));
        System.out.println("Graph after deleting node D: ");
        System.out.println(networkGraph.printGraph());

        // Test removeLink
        networkGraph.removeLink(networkGraph.nodeFromIndex(0), networkGraph.nodeFromIndex(1));
        System.out.println("Graph after removing link between A and B: ");
        System.out.println(networkGraph.printGraph());

         // Create an instance of the Network class
        int[][] minSpanningTree = sampleNetwork2.minSpanningTree();
        System.out.println("Minimum Spanning Tree Matrix: ");
        for (int[] ints : minSpanningTree) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        NetNode node1 = networkGraph.nodeFromIndex(0);
        NetNode node2 = networkGraph.nodeFromIndex(2);
        ArrayList<NetNode> shortestPath = sampleNetwork2.getShortestPath(node1, node2);
        System.out.println("Shortest path from " + node1.getName() + " to " + node2.getName() + ": ");
        for (NetNode node : shortestPath) {
            System.out.print(node.getName() + " ");
        }
        System.out.println();

        // Add the removed node and link back for further testing
        networkGraph.insertNetNode(3, "D", 3, 3);
        networkGraph.addLink(networkGraph.nodeFromIndex(0), networkGraph.nodeFromIndex(1), 900);
        networkGraph.addLink(networkGraph.nodeFromIndex(2), networkGraph.nodeFromIndex(3), 13);

        // Test the updated printGraph method
        System.out.println("Updated Graph: ");
        System.out.println(networkGraph.printGraph());
        // Test minSpanningTree again
        int[][] minSpanningTree2 = sampleNetwork2.minSpanningTree();
        System.out.println("Minimum Spanning Tree Matrix (with node D added back): ");
        for (int[] ints : minSpanningTree) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        // Test getShortestPath again
        node1 = networkGraph.nodeFromIndex(0);
        node2 = networkGraph.nodeFromIndex(3);
        ArrayList<NetNode> shortestPath2 = sampleNetwork2.getShortestPath(node1, node2);
        System.out.println("Shortest path from " + node1.getName() + " to " + node2.getName() + ": ");
        for (NetNode node : shortestPath2) { // <-- Change this line from shortestPath to shortestPath2
            System.out.print(node.getName() + " ");
        }
        System.out.println();


    }
    }