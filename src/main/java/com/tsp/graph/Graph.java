package com.tsp.graph;

import java.util.*;

public class Graph {
    private final ArrayList<Vertex> vertices = new ArrayList<>();

    private final ArrayList<Edge> edges = new ArrayList<>();

    public void addVertex(String id) {
        // TODO
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                System.out.println("Vertex already exists");
                return;
            }
        }
        vertices.add(new Vertex(id));
        System.out.println("Vertex added");
    }

    public void removeVertex(String id) {
        // TODO
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                vertices.remove(v);
                System.out.println("Vertex removed");
                return;
            }
        }
        System.out.println("Vertex does not exist");
    }

    public void addEdge(String vertex1Id, String vertex2Id, int weight) {
        // add edge to the graph
        Vertex vertex1 = null;
        Vertex vertex2 = null;
        // find vertex1 and vertex2 if they exist
        for (Vertex v : vertices) {
            if (v.getId().equals(vertex1Id)) {
                vertex1 = v;
            }
            if (v.getId().equals(vertex2Id)) {
                vertex2 = v;
            }
        }
        if (vertex1 == null || vertex2 == null) {
            System.out.println("Vertex does not exist");

        } else {
            edges.add(new Edge(vertex1, vertex2, weight));
            System.out.println("Edge added");
        }
    }

    public void addUndirectedGraphEdge(String vertex1Id, String vertex2Id, int weight) {
        // add edge to the graph
        addEdge(vertex1Id, vertex2Id, weight);
        addEdge(vertex2Id, vertex1Id, weight);
    }

    public void removeEdge(String vertex1Id, String vertex2Id) {
        int i=0;
        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertex1Id) && e.getDestination().getId().equals(vertex2Id)){
                edges.remove(e);
                i++;
                break;
            }

        }

        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertex2Id) && e.getDestination().getId().equals(vertex1Id)){
                edges.remove(e);
                i++;
                break;
            }

        }

        if(i!=0){
            System.out.println("Edge does not exist");

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertices) {
            sb.append("Vertices:").append(v.getId()).append("\n");
            for (Edge e : edges) {
                if (e.getSource().getId().equals(v.getId())) {
                    sb.append(v.getId()).append("-->").append(e.getDestination().getId()).append(" ").append(e.getWeight()).append("\n");
                }
            }
        }
        sb.append("\n");

        return sb.toString();
    }

    public Vertex getVertex(String id) {
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Edge getEdge(String vertex1Id, String vertex2Id) {
        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertex1Id) && e.getDestination().getId().equals(vertex2Id)) {
                System.out.println("get edge success: "+ vertex1Id+ "to" + vertex2Id);
                return e;
            }
        }
        System.out.println("get edge fail: "+ vertex1Id+ "to" + vertex2Id);
        return null;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }



    //                              ************************E X A M P L E**********************
    public static Graph graphK4() {
        Graph graph = new Graph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addUndirectedGraphEdge("0", "1", 25);
        graph.addUndirectedGraphEdge("0", "2", 25);
        graph.addUndirectedGraphEdge("0", "3", 13);
        graph.addUndirectedGraphEdge("1", "2", 25);
        graph.addUndirectedGraphEdge("1", "3", 13);
        graph.addUndirectedGraphEdge("2", "3", 13);
        return graph;
    }

    public static Graph graphK5() {
        Graph graph = new Graph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addUndirectedGraphEdge("0", "1", 24);
        graph.addUndirectedGraphEdge("0", "2", 13);
        graph.addUndirectedGraphEdge("0", "3", 13);
        graph.addUndirectedGraphEdge("0", "4", 22);
        graph.addUndirectedGraphEdge("1", "2", 22);
        graph.addUndirectedGraphEdge("1", "3", 13);
        graph.addUndirectedGraphEdge("1", "4", 13);
        graph.addUndirectedGraphEdge("2", "3", 19);
        graph.addUndirectedGraphEdge("2", "4", 14);
        graph.addUndirectedGraphEdge("3", "4", 19);
        return graph;
    }

    public static Graph graphK8() {
        Graph graph = new Graph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addUndirectedGraphEdge("0", "1", 25);
        graph.addUndirectedGraphEdge("0", "2", 25);
        graph.addUndirectedGraphEdge("0", "3", 13);
        graph.addUndirectedGraphEdge("0", "4", 25);
        graph.addUndirectedGraphEdge("0", "5", 13);
        graph.addUndirectedGraphEdge("0", "6", 13);
        graph.addUndirectedGraphEdge("0", "7", 13);

        graph.addUndirectedGraphEdge("1", "2", 25);
        graph.addUndirectedGraphEdge("1", "3", 13);
        graph.addUndirectedGraphEdge("1", "4", 25);
        graph.addUndirectedGraphEdge("1", "5", 13);
        graph.addUndirectedGraphEdge("1", "6", 13);
        graph.addUndirectedGraphEdge("1", "7", 13);

        graph.addUndirectedGraphEdge("2", "3", 13);
        graph.addUndirectedGraphEdge("2", "4", 25);
        graph.addUndirectedGraphEdge("2", "5", 13);
        graph.addUndirectedGraphEdge("2", "6", 13);
        graph.addUndirectedGraphEdge("2", "7", 13);

        graph.addUndirectedGraphEdge("3", "4", 25);
        graph.addUndirectedGraphEdge("3", "5", 13);
        graph.addUndirectedGraphEdge("3", "6", 13);
        graph.addUndirectedGraphEdge("3", "7", 13);

        graph.addUndirectedGraphEdge("4", "5", 13);
        graph.addUndirectedGraphEdge("4", "6", 13);
        graph.addUndirectedGraphEdge("4", "7", 13);

        graph.addUndirectedGraphEdge("5", "6", 13);
        graph.addUndirectedGraphEdge("5", "7", 13);

        graph.addUndirectedGraphEdge("6", "7", 13);


        return graph;
    }


}
