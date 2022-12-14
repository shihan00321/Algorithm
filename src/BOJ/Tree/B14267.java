package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14267 {
    static int n, m;
    static int[] praise;
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer>[] children;
    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(praise[i]).append(' ');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        children = new ArrayList[n + 1];
        praise = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) continue;
            children[x].add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            praise[target] += w;
        }
        dfs(1);
    }
    public static void dfs(int x){
        for(int y : children[x]){
            praise[y] += praise[x];
            dfs(y);
        }
    }
}