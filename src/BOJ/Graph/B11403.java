package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403 {
    static int N;
    static boolean[] visit;
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) arr[i].add(j);
            }
        }
    }
    public static void algo(){
        for (int i = 1; i <= N; i++) {
            bfs(i);
            stringBuilder.append('\n');
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        do {
            int x = queue.poll();
            for (int y : arr[x]) {
                if (visit[y]) continue;
                queue.add(y);
                visit[y] = true;
            }
        } while (!queue.isEmpty());
        for (int i = 1; i <= N; i++) {
            if (visit[i]) stringBuilder.append(1).append(' ');
            else stringBuilder.append(0).append(' ');
        }
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }
    }
}
