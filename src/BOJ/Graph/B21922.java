package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21922 {
    static int N, M, result;
    static int[][] lab;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][][] visit;
    static boolean[][] cooling;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N + 1][M + 1];
        cooling = new boolean[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1][4];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void algo(){
        Queue<Wind> start = new LinkedList<>();
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if(lab[y][x] == 9) {
                    start.add(new Wind(x, y, -1));
                    cooling[y][x] = true;
                }
            }
        }
        Queue<Wind> winds = new LinkedList<>();
        while (!start.isEmpty()) {
            Wind wind = start.poll();
            int x = wind.x;
            int y = wind.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][1];
                int ny = y + dir[i][0];
                if(nx <= 0 || ny <= 0 || nx > M || ny > N) continue;
                if(visit[ny][nx][i]) continue;
                visit[ny][nx][i] = true;
                winds.add(new Wind(nx, ny, i));
                cooling[ny][nx] = true;
            }
        }
        while (!winds.isEmpty()) {
            Wind wind = winds.poll();
            int x = wind.x;
            int y = wind.y;
            int direction = wind.direction;
            direction = changeDirection(lab[y][x], direction);
            int nx = x + dir[direction][1];
            int ny = y + dir[direction][0];
            if(nx <= 0 || ny <= 0 || nx > M || ny > N) continue;
            if(visit[ny][nx][direction]) continue;
            visit[ny][nx][direction] = true;
            winds.add(new Wind(nx, ny, direction));
            cooling[ny][nx] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(cooling[i][j]) result++;
            }
        }
    }

    private static int changeDirection(int wall, int direction) {
        //상 하 좌 우 순으로
        if(wall == 1) {
            if(direction == 0) return 0;
            else if(direction == 1) return 1;
            else if(direction == 2) return 3;
            else return 2;
        }
        if(wall == 2) {
            if(direction == 0) return 1;
            else if(direction == 1) return 0;
            else if(direction == 2) return 2;
            else return 3;
        }
        if(wall == 3) {
            if(direction == 0) return 2;
            else if(direction == 1) return 3;
            else if(direction == 2) return 0;
            else return 1;
        }
        if(wall == 4) {
            if(direction == 0) return 3;
            else if(direction == 1) return 2;
            else if(direction == 2) return 1;
            else return 0;
        }
        //벽이 없으면 그대로
        return direction;
    }

    static class Wind {
        int x, y, direction;
        public Wind(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}