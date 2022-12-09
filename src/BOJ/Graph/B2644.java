package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {
    static int n, target1, target2;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        input();
        bfs(target1);
    }

    private static void bfs(int target1) {
        for (int i = 1; i <= n; i++) {
            distance[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target1);
        visit[target1] = true;
        distance[target1] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y : arr[x]) {
                if (visit[y]) continue;
                queue.add(y);
                distance[y] = distance[x] + 1;
                visit[y] = true;
            }
        }
        System.out.println(distance[target2]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
}
