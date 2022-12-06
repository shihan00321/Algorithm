package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725 {
    static int N;
    static boolean[] visit;
    static int[] parents;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            stringBuilder.append(parents[i]).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y : arr[x]) {
                if(visit[y]) continue;
                queue.add(y);
                visit[y] = true;
                parents[y] = x;
            }
        }
    }
}
