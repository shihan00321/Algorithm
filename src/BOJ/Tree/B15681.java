package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15681 {
    static int N, R, Q;
    static ArrayList<Integer>[] arr;
    static int[] node;
    static int[] parents;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        node = new int[N + 1];
        parents = new int[N + 1];
        parents[R] = -1;
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            node[i] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        dfs(R, parents[R]);
        for (int i = 0; i < Q; i++) {
            int result = Integer.parseInt(br.readLine());
            stringBuilder.append(node[result]).append('\n');
        }
    }
    public static void dfs(int x, int parent){
        if(arr[x].size() == 1) node[x] = 1;
        for(int y : arr[x]){
            if(y == parent) continue;
            dfs(y, x);
            node[x] += node[y];
        }
    }
}