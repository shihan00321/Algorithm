package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static int I;
    static int[][] chess;
    static int[][] distance;
    static boolean[][] visit;
    static int[][] dir = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            chess = new int[I][I];
            distance = new int[I][I];
            visit = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int destY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            bfs(startY, startX, destY, destX);
        }
    }
    private static void bfs(int startY, int startX, int destY, int destX) {
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < I; j++) {
                distance[i][j] = -1;
            }
        }
        distance[startY][startX] = 0;
        visit[startY][startX] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startY);
        queue.add(startX);
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = dir[i][0] + y;
                int nx = dir[i][1] + x;
                if (ny < 0 || nx < 0 || ny >= I || nx >= I) continue;
                if (visit[ny][nx]) continue;
                queue.add(ny);
                queue.add(nx);
                visit[ny][nx] = true;
                distance[ny][nx] = distance[y][x] + 1;
            }
        }
        stringBuilder.append(distance[destY][destX]).append('\n');
    }
}
