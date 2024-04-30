package graphTraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source,int destination,int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int index = 0; index < graph.length; index++) {
            graph[index] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(0);

        while(!queue.isEmpty()) {
            int current = queue.remove();

            if(!visited[current]) {
                System.out.print(current+" ");
                visited[current] = true;
                for (int index = 0; index < graph[current].size(); index++) {
                  Edge edge = graph[current].get(index);
                  queue.add(edge.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
        1----3
      /      | \
      0      |  5 ---6
      \      | /
       2-----4
        */

        int vertex = 7;
        ArrayList<Edge> []graph = new ArrayList[vertex];
        createGraph(graph);
        bfs(graph);
    }

}