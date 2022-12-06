package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h;
    static int[][] land;
    static boolean[][] visit;
    static int landCnt;
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) throws IOException {
        while (true){
            input();
            if (w == 0 && h == 0) break;
            algo();
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        land = new int[h][w];
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void algo() {
        landCnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(land[i][j] == 1 && !visit[i][j]){
                    dfs(i, j);
                    landCnt++;
                }
            }
        }
        stringBuilder.append(landCnt).append('\n');
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nx = dir[i][1] + x;
            int ny = dir[i][0] + y;
            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if (visit[ny][nx]) continue;
            if (land[ny][nx] == 0) continue;
            dfs(ny, nx);
        }
    }
}
