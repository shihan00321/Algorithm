package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] cabbage;
    static int M, N, K;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int count;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cabbage = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            cabbage[x][y] = 1;
        }
        algo();
    }
    public static void algo(){
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cabbage[i][j] == 1 && !visit[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        stringBuilder.append(count).append('\n');
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visit[nx][ny]) continue;
            if(cabbage[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}
