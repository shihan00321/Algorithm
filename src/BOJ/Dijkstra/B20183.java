package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B20183 {
    static int N, M, A, B;
    static long C;
    static ArrayList<Alley>[] alleys;
    static long[] dist;
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
        C = Long.parseLong(st.nextToken());
        alleys = new ArrayList[N + 1];
        dist = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            alleys[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long cost = Integer.parseInt(st.nextToken());
            alleys[x].add(new Alley(y, cost));
            alleys[y].add(new Alley(x, cost));
        }
    }
    public static void algo(){
        //1000000001번지가 1000000000을 가리킴
        int left = 1, right = 1000000001, result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            //mid를 가지고 골목을 지나갈 수 있는가?
            if(bfs(mid)) {
                result = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        if(result != 1000000001) System.out.println(result);
        else System.out.println(-1);
    }
    public static boolean bfs(int mid){
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        PriorityQueue<Path> queue = new PriorityQueue<>();
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
    static class Path implements Comparable<Path> {
        int num;
        long distance;
        public Path(int num, long distance) {
            this.num = num;
            this.distance = distance;
        }
        @Override
        public int compareTo(Path o) {
            return Long.compare(this.distance, o.distance);
        }
    }
    static class Alley {
        int dest;
        long cost;
        public Alley(int dest, long cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}