package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int M, N, H;
    static int[][][] tomato;
    static boolean[][][] visit;
    static int[][] dir = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(output());
    }
    private static int output() {
        int result = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tomato[i][j][k] == 0) return -1;
                    else result = Math.max(result, tomato[i][j][k] - 1);
                }
            }
        }
        return result;
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[N][M][H];
        visit = new boolean[N][M][H];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tomato[i][j][k] == 1) {
                        queue.add(i);
                        queue.add(j);
                        queue.add(k);
                        visit[i][j][k] = true;
                    }
                }

            }
        }
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            int h = queue.poll();
            for (int i = 0; i < 6; i++) {
                int ny = y + dir[i][1];
                int nx = x + dir[i][0];
                int nh = h + dir[i][2];
                if(ny < 0 || nx < 0 || nh < 0 || ny >= N || nx >= M || nh >= H) continue;
                if(visit[ny][nx][nh]) continue;
                if(tomato[ny][nx][nh] == -1) continue;
                queue.add(ny);
                queue.add(nx);
                queue.add(nh);
                visit[ny][nx][nh] = true;
                tomato[ny][nx][nh] = tomato[y][x][h] + 1;
            }
        }
    }
}