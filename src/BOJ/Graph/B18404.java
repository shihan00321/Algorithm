package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18404 {
    static int N, M;
    static boolean[][] visit;
    static int[][] distance;
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] dir = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1][N + 1];
        distance = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        int knightY = Integer.parseInt(st.nextToken());
        int knightX = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int destY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            bfs(knightY, knightX, destY, destX);
        }
    }

    private static void bfs(int knightY, int knightX, int destY, int destX) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(knightY);
        queue.add(knightX);
        distance[knightY][knightX] = 0;
        visit[knightY][knightX] = true;
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = dir[i][0] + y;
                int nx = dir[i][1] + x;
                if (ny < 1 || nx < 1 || ny > N || nx > N) continue;
                if (visit[ny][nx]) continue;
                distance[ny][nx] = distance[y][x] + 1;
                visit[ny][nx] = true;
                queue.add(ny);
                queue.add(nx);
            }
        }
       stringBuilder.append(distance[destY][destX]).append(' ');
    }
}
