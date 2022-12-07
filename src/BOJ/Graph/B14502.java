package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int count = 0;
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(count);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
    }
    private static void dfs(int wallCnt) {
        if(wallCnt == 3){
            //바이러스를 퍼뜨림
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        //모든 바이러스를 queue에 넣어준다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
                if(arr[i][j] == 2){
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int y = queue.poll();
            int x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][1];
                int ny = y + dir[i][0];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(arr[ny][nx] != 0) continue;
                if(visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(ny);
                queue.add(nx);
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visit[i][j]) result++;
            }
        }
        count = Math.max(count, result);
    }
}
