package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22255 {
    static int N, M, Sx, Sy, Ex, Ey, result = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][][] dist, dir = {
            {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, 1}, {0, -1}}
    };
    public static void main(String[] args) throws IOException {
        input();
        algo(Sx, Sy);
    }
    static class Shock {
        int x, y, move, weight;
        public Shock(int x, int y, int move, int weight) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.weight = weight;
        }
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Sy = Integer.parseInt(st.nextToken());
        Sx = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());
        Ex = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }
    public static void algo(int startX, int startY){
        PriorityQueue<Shock> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        queue.add(new Shock(startX, startY, 1, 0));
        dist[startY][startX][1] = 0;
        while (!queue.isEmpty()) {
            Shock shock = queue.poll();
            int x = shock.x;
            int y = shock.y;
            int move = shock.move;
            int weight = shock.weight;
            if(dist[y][x][move] < weight) continue;
            int countDirection = move == 0 ? 4 : 2;
            for (int i = 0; i < countDirection; i++) {
                int ny = y + dir[move][i][0];
                int nx = x + dir[move][i][1];
                if(ny <= 0 || nx <= 0 || ny > N || nx > M) continue;
                if(arr[ny][nx] == -1) continue;
                int nextMove = (move + 1) % 3;
                int nextWeight = weight + arr[ny][nx];
                if(dist[ny][nx][nextMove] <= nextWeight) continue;
                queue.add(new Shock(nx, ny, nextMove, nextWeight));
                dist[ny][nx][nextMove] = nextWeight;
            }
        }
        for (int i = 0; i <= 2; i++) {
            result = Math.min(result, dist[Ey][Ex][i]);
        }
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}