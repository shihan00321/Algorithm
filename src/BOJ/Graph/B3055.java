package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {
    static int R, C;
    static int[][] arr;
    static int[][] distance_water, distance_hedgehog;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        bfs_water();
        bfs_hedgehog();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != 'D') continue;
                if (distance_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                else System.out.println(distance_hedgehog[i][j]);
            }
        }
    }
    private static void bfs_water() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*'){
                    queue.add(i);
                    queue.add(j);
                    distance_water[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dir[i][0] + y;
                int nx = dir[i][1] + x;
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (distance_water[ny][nx] != -1) continue;
                if (arr[ny][nx] != '.') continue;
                distance_water[ny][nx] = distance_water[y][x] + 1;
                queue.add(ny);
                queue.add(nx);
            }
        }
    }
    private static void bfs_hedgehog() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'S'){
                    queue.add(i);
                    queue.add(j);
                    distance_hedgehog[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dir[i][0] + y;
                int nx = dir[i][1] + x;
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (distance_hedgehog[ny][nx] != -1) continue;
                if (arr[ny][nx] != '.' && arr[ny][nx] != 'D') continue;
                if (distance_water[ny][nx] != -1 && (distance_hedgehog[y][x] + 1) >= distance_water[ny][nx]) continue;
                distance_hedgehog[ny][nx] = distance_hedgehog[y][x] + 1;
                queue.add(ny);
                queue.add(nx);
            }
        }
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        distance_water = new int[R][C];
        distance_hedgehog = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                distance_water[i][j] = -1;
                distance_hedgehog[i][j] = -1;
            }
        }
    }
}