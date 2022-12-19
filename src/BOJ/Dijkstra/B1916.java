package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static int N, M, resultS, resultD;
    static int[] dist; //목적지까지의 거리
    static ArrayList<BusInfo>[] bus;
    static class BusInfo{
        int destination, weight;
        public BusInfo(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    static class ShortestPath {
        int destination, distance;
        public ShortestPath(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(dist[resultD]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        bus = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            bus[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            bus[start].add(new BusInfo(destination, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        resultS = Integer.parseInt(st.nextToken());
        resultD = Integer.parseInt(st.nextToken());
    }
    public static void algo(){
        PriorityQueue<ShortestPath> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        dist[resultS] = 0;
        queue.add(new ShortestPath(resultS, 0));
        while (!queue.isEmpty()){
            ShortestPath path = queue.poll();
            if(dist[path.destination] < path.distance) continue;
            for(BusInfo busInfo : bus[path.destination]){
                if(dist[busInfo.destination] <= dist[path.destination] + busInfo.weight) continue;
                dist[busInfo.destination] = dist[path.destination] + busInfo.weight;
                queue.add(new ShortestPath(busInfo.destination, dist[busInfo.destination]));
            }
        }
    }
}