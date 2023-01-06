package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20166 {
    static int N, M, K;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static String[][] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new String[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = String.valueOf(s.charAt(j - 1));
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dfs(i, j, arr[i][j]);
            }
        }
        for (int i = 0; i < K; i++) {
            String s = br.readLine();
            if(hashMap.containsKey(s)) stringBuilder.append(hashMap.get(s)).append('\n');
            else stringBuilder.append(0).append('\n');
        }
    }
    public static void dfs(int y, int x, String s){
        if(hashMap.containsKey(s)) hashMap.replace(s, hashMap.get(s) + 1);
        else hashMap.put(s, 1);
        if(s.length() == 5) return;
        for (int i = 0; i < 8; i++) {
            int ny = y + dir[i][1];
            int nx = x + dir[i][0];
            if(ny == 0) ny = N;
            if(nx == 0) nx = M;
            if(ny == N + 1) ny = 1;
            if(nx == M + 1) nx = 1;
            dfs(ny, nx, s + arr[ny][nx]);
        }
    }
}