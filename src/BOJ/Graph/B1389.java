package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
    public static void algo(){
        int res = bfs(1);
        int kevin = 1;
        for (int i = 2; i <= N; i++) {
            int sum = bfs(i);
            if (res <= sum) continue;
            res = sum;
            kevin = i;
        }
        System.out.println(kevin);
    }
    private static int bfs(int i) {
        for (int k = 1; k <= N; k++) {
            distance[k] = 0;
        }
        int sum = 0;
        visit = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y : arr[x]) {
                if (visit[y]) continue;
                queue.add(y);
                visit[y] = true;
                distance[y] = distance[x] + 1;
            }
        }
        for (int j = 1; j <= N; j++) {
            sum += distance[j];
        }
        return sum;
    }
}
