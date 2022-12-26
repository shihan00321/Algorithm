package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15681 {
    static int N, R, Q;
    static ArrayList<Integer>[] arr;
    static int[] dy;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            //leaf 노드
            if(arr[i].size() == 1) dy[i] = 1;
        }
        dfs(R, -1);
        for (int i = 0; i < Q; i++) {
            int target = Integer.parseInt(br.readLine());
            stringBuilder.append(dy[target]).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void dfs(int root, int parent){
        dy[root] = 1;
        for(int y : arr[root]){
            if(y == parent) continue;
            dfs(y, root);
            dy[root] += dy[y];
        }
    }
}