package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static int N, M;
    static int[] dist;
    static ArrayList<Bus>[] arr;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        algo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    public static void algo(int x, int y){
        PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        dist[x] = 0;
        pq.add(new Path(x, 0));
        while (!pq.isEmpty()){
            Path path = pq.poll();
            if(dist[path.busNum] < path.distance) continue;
            for(Bus nextBus : arr[path.busNum]){
                if(dist[nextBus.dest] <= dist[path.busNum] + nextBus.cost) continue;
                dist[nextBus.dest] = dist[path.busNum] + nextBus.cost;
                pq.add(new Path(nextBus.dest, dist[nextBus.dest]));
            }
        }
        System.out.println(dist[y]);
    }
    static class Bus {
        int dest;
        int cost;
        public Bus(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    static class Path {
        int busNum;
        int distance;
        public Path(int busNum, int distance) {
            this.busNum = busNum;
            this.distance = distance;
        }
    }
}