package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {
    static int N;
    static int[] parents;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        input();
        dfs(1, -1);
        for (int i = 2; i <= N; i++) {
            stringBuilder.append(parents[i]).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
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
    public static void dfs(int target, int parent){
        for(int x : arr[target]){
            if (x != parent){
                parents[x] = target;
                dfs(x, target);
            }
        }
    }
}
