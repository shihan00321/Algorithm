package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {
    static int N, M, result;
    static int[][] laboratory;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        laboratory = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void dfs(int depth){
        //벽을 다 세우고 나면 바이러스를 퍼뜨린다.
        if(depth == 3) bfs();
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(laboratory[i][j] == 0) {
                        //벽을 세움
                        laboratory[i][j] = 1;
                        dfs(depth + 1);
                        laboratory[i][j] = 0;
                    }
                }
            }
        }
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
                if(laboratory[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dir[i][0] + y;
                int nx = dir[i][1] + x;
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(visit[ny][nx]) continue;
                if(laboratory[ny][nx] != 0) continue;
                queue.add(ny);
                queue.add(nx);
                visit[ny][nx] = true;
            }
        }
        int middleResult = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //연구소 값을 변경하지 않았음 -> 즉 0이면서 방문하지 않은 곳까지 check 해주어야 바이러스가 진정으로 퍼지지 않은 곳임.
                if(laboratory[i][j] == 0 && !visit[i][j]) middleResult++;
            }
        }
        result = Math.max(result, middleResult);
    }
}