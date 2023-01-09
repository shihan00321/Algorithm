package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21278 {
    static int N, M, resultA, resultB, resultTime = Integer.MAX_VALUE;
    static ArrayList<Integer>[] arr;
    static int[] time;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        stringBuilder.append(resultA).append(' ').append(resultB).append(' ').append(resultTime);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N  + 1];
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
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                bfs(i, j);
            }
        }
    }
    public static void bfs(int i, int j){
        time = new int[N + 1];
        for (int k = 1; k <= N; k++) {
            time[k] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        time[i] = 0;
        time[j] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : arr[x]) {
                if(time[y] == Math.min(time[y], time[x] + 1)) continue;
                queue.add(y);
                time[y] = Math.min(time[y], time[x] + 1);
            }
        }
        int rTime = 0;
        for (int k = 1; k <= N; k++) {
            rTime += time[k] * 2;
        }
        if(resultTime != Math.min(resultTime, rTime)) {
            resultA = i;
            resultB = j;
            resultTime = rTime;
        }
    }
}