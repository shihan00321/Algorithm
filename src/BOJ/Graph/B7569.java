package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int M, N, H;
    static int[][][] tomato;
    static int[][][] distance;
    static boolean[][][] visit;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];
        visit = new boolean[H][N][M];
        distance = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    visit[i][j][k] = false;
                    distance[i][j][k] = -1;
                }
            }
        }
    }
    public static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                   if (tomato[i][j][k] == 1) {
                       queue.add(i);
                       queue.add(j);
                       queue.add(k);
                       visit[i][j][k] = true;
                       distance[i][j][k] = 0;
                   }
                }
            }
        }
        while (!queue.isEmpty()){
            int h = queue.poll();
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nh = dir[i][0] + h;
                int ny = dir[i][1] + y;
                int nx = dir[i][2] + x;
                if(nx < 0 || ny < 0 || nh < 0 || nx >= M || ny >= N || nh >= H) continue;
                if(visit[nh][ny][nx]) continue;
                if(tomato[nh][ny][nx] == -1) continue;
                visit[nh][ny][nx] = true;
                tomato[nh][ny][nx] = 1;
                queue.add(nh);
                queue.add(ny);
                queue.add(nx);
                distance[nh][ny][nx] = distance[h][y][x] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //중요!
                    if(tomato[i][j][k] == -1) continue;
                    if (distance[i][j][k] == -1) {
                        return -1;
                    }
                    result = Math.max(result, distance[i][j][k]);
                }
            }
        }
        return result;
    }
}
