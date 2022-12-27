package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1949 {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] village;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        village = new int[N + 1];
        arr = new ArrayList[N + 1];
        //0 subtree root 선택x, 1 root 선택o
        dy = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            village[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        dfs(1, -1);
        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }
    public static void dfs(int root, int parent){
        dy[root][1] = village[root];
        for (int y : arr[root]) {
            if(y == parent) continue;
            dfs(y, root);
            dy[root][0] += Math.max(dy[y][0], dy[y][1]);
            dy[root][1] += dy[y][0];
        }
    }
}