package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static int N, K;
    static boolean[] visit;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;
        distance[N] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = x * 2;
            if (y >= 0 && y <= 100000 && !visit[y]) {
                visit[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
            y = x + 1;
            if (y >= 0 && y <= 100000 && !visit[y]) {
                visit[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
            y = x - 1;
            if (y >= 0 && y <= 100000 && !visit[y]) {
                visit[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
        }
        System.out.println(distance[K]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distance = new int[100001];
        visit = new boolean[100001];
    }
}
