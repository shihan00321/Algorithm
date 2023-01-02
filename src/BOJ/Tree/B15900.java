package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15900 {
    static int N, sumDepths;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1, 0);
        if(sumDepths % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
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
    public static void dfs(int target, int par, int depth){
        if(arr[target].size() == 1 && target != 1) {
            sumDepths += depth;
            return;
        }
        for (int y : arr[target]) {
            if(y == par) continue;
            dfs(y, target, depth + 1);
        }
    }
}