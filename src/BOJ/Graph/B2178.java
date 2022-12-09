package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    static int N, M;
    static int[][] arr;
    static int[][] distance;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(distance[N][M]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        distance = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = s.charAt(j - 1) - 48;
                distance[i][j] = -1;
            }
        }
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(1);
        visit[1][1] = true;
        distance[1][1] = 1;
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = dir[k][0] + y;
                int nx = dir[k][1] + x;
                if (nx < 1 || ny < 1 || nx > M || ny > N) continue;
                if (visit[ny][nx]) continue;
                if (arr[ny][nx] == 0) continue;
                queue.add(ny);
                queue.add(nx);
                visit[ny][nx] = true;
                distance[ny][nx] = distance[y][x] + 1;
             }
        }
    }
}
