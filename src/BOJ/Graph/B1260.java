package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {
    static int N, M, V;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visit;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        dfs(V);
        stringBuilder.append('\n');
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }
        bfs(V);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayLists[i]);
        }
    }
    public static void dfs(int start){
        visit[start] = true;
        stringBuilder.append(start).append(' ');
        for (int x : arrayLists[start]){
            if(visit[x])
                continue;
            dfs(x);
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            stringBuilder.append(x).append(' ');
            for (int y : arrayLists[x]) {
                if (visit[y])
                    continue;
                queue.add(y);
                visit[y] = true;
            }
        }
    }
}
