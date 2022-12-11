package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15900 {
    static int N;
    static int count = 0;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1, 0);
        if(count % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }
    private static void dfs(int target, int parent, int cnt) {
        //leafNode -> 간선이 1개.
        if(arr[target].size() == 1 && target != 1) {
            count += cnt;
            return;
        }
        for(int x : arr[target])
            if(x != parent)
                dfs(x, target, cnt + 1);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
}
