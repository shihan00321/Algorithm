package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }

    private static int bfs() {
        int infectComputer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int y: arr[x]){
                if (visit[y]) continue;
                queue.add(y);
                visit[y] = true;
                infectComputer++;
            }
        }
        return infectComputer;
    }
}
