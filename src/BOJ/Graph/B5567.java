package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5567 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y : arr[x]) {
                if (distance[y] == -1) {
                    queue.add(y);
                    distance[y] = distance[x] + 1;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == 1 || distance[i] == 2) count++;
        }
        System.out.println(count);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
}