package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B22253 {
    static int N, MOD = 1000000007, result;
    static int[][] dy; //i를 root로 하고 num[1]가 마지막인 경우
    static int[] num;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1);
        for (int i = 0; i < 10; i++) {
            result += dy[1][i];
            result %= MOD;
        }
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        num = new int[N + 1];
        dy = new int[N + 1][10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
    }
    public static void dfs(int root, int parent){
        dy[root][num[root]] = 1;
        for(int x : arr[root]) {
            if(x == parent) continue;
            dfs(x, root);
            //root를 켜지 않는 경우
            for (int i = 0; i < 10; i++) {
                dy[root][i] += dy[x][i];
                dy[root][i] %= MOD;
            }
            //root를 켜는 경우
            for (int i = num[root]; i < 10; i++) {
                dy[root][num[root]] += dy[x][i];
                dy[root][num[root]] %= MOD;
            }
        }
    }
}