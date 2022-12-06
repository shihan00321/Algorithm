package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2667 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static boolean[][] visit;
    static String[] s;
    static int apartCount;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        visit = new boolean[N][N];
    }
    public static void algo(){
        ArrayList<Integer> apart = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(s[i].charAt(j) == '1' && !visit[i][j]){
                    apartCount = 0;
                    dfs(i, j);
                    apart.add(apartCount);
                }
            }
        }
        Collections.sort(apart);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(apart.size()).append('\n');
        for (Integer integer : apart) {
            stringBuilder.append(integer).append('\n');
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;
        apartCount++;
        for (int k = 0; k < 4; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visit[nx][ny]) continue;
            if (s[nx].charAt(ny) == '0') continue;
            dfs(nx, ny);
        }
    }
}
