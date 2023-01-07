package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B20182 {
    static int N, M, A, B, C;
    static ArrayList<Alley>[] alleys;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alleys = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            alleys[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            alleys[x].add(new Alley(y, cost));
            alleys[y].add(new Alley(x, cost));
        }
    }
    public static void algo(){
        int left = 1, right = 21, result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            //mid를 가지고 골목을 지나갈 수 있는가?
            if(bfs(mid)) {
                result = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        if(result != 21) System.out.println(result);
        else System.out.println(-1);
    }
    public static boolean bfs(int mid){
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Path> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        queue.add(new Path(A, 0));
        dist[A] = 0;
        while (!queue.isEmpty()) {
            Path path = queue.poll();
            if(dist[path.num] < path.distance) continue;
            for(Alley alley : alleys[path.num]) {
                if(dist[alley.dest] <= alley.cost + dist[path.num]) continue;
                if(alley.cost > mid) continue;
                dist[alley.dest] = alley.cost + dist[path.num];
                queue.add(new Path(alley.dest, dist[alley.dest]));
            }
        }
        return dist[B] <= C;
    }
    static class Path {
        int num;
        int distance;
        public Path(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
    static class Alley {
        int dest;
        int cost;
        public Alley(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}