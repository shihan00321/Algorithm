package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
    static int V, E, K;
    static int[] dist;
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Edge>[] edges;
    static class Edge {
        int destination, weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    static class Path {
        int destination, distance;
        public Path(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        algo();
        for (int i = 1; i <= V; i++) {
            if(dist[i] != Integer.MAX_VALUE) stringBuilder.append(dist[i]).append('\n');
            else stringBuilder.append("INF").append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        edges = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(destination, weight));
        }
    }
    public static void algo(){
        dist[K] = 0;
        PriorityQueue<Path> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        queue.add(new Path(K, dist[K]));
        while (!queue.isEmpty()){
            Path path = queue.poll();
            if(dist[path.destination] < path.distance) continue;
            for(Edge edge : edges[path.destination]){
                if(dist[edge.destination] <= dist[path.destination] + edge.weight) continue;
                dist[edge.destination] = dist[path.destination] + edge.weight;
                queue.add(new Path(edge.destination, dist[edge.destination]));
            }
        }
    }
}