package graphs;

import java.util.*;

class Vertex {
    String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(label);
    }
}

class Graph {
    Map<Vertex, List<Vertex>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(String firstVertexLabel, String secondVertexLabel) {
        Vertex firstVertex = new Vertex(firstVertexLabel);
        Vertex secondVertex = new Vertex(secondVertexLabel);
        adjacencyList.get(firstVertex).add(secondVertex);
        adjacencyList.get(secondVertex).add(firstVertex);
    }

    public void printGraph() {
        adjacencyList.forEach((vertex, vertices) -> {
            System.out.println("{" + vertex + "," + vertices + "}");
        });
    }
}

class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("AB1");
        graph.addVertex("AB2");
        graph.addVertex("AB3");
        graph.addVertex("AB4");
        graph.addVertex("AB5");
        graph.addVertex("AB6");
        graph.addVertex("AB7");
        graph.addVertex("AB8");
        graph.addVertex("AB9");
        graph.addVertex("AB10");
        graph.addVertex("AB11");
        graph.addEdge("AB1", "AB2");
        graph.addEdge("AB2", "AB3");
        graph.addEdge("AB3", "AB4");
        graph.addEdge("AB4", "AB5");
        graph.addEdge("AB5", "AB6");
        graph.addEdge("AB6", "AB7");
        graph.addEdge("AB7", "AB8");
        graph.addEdge("AB8", "AB9");
        graph.addEdge("AB9", "AB10");
        graph.addEdge("AB10", "AB11");
        graph.printGraph();

    }
}