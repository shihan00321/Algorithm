package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21938 {
    static int N, M, result, T;
    static RGB[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static class RGB {
        int r, g, b;
        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new RGB[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i][j] = new RGB(r, g, b);
            }
        }
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                RGB rgb = arr[i][j];
                if((rgb.r + rgb.g + rgb.b) / 3 >= T) arr[i][j] = new RGB(255, 255, 255);
                else arr[i][j] = new RGB(0, 0, 0);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(arr[i][j].r == 255) {
                    dfs(i, j);
                    result++;
                }
            }
        }
    }
    public static void dfs(int y, int x){
        if(y <= 0 || x <= 0 || y > N || x > M) return;
        if(arr[y][x].r == 255) {
            arr[y][x] = new RGB(0, 0, 0);
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                dfs(ny, nx);
            }
        }
    }
}