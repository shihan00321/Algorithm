package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3184 {
    static int R, C;
    static int wolves = 0, sheep = 0;
    static String[] s;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        s = new String[R];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            s[i] = br.readLine();
        }
    }
    public static void algo(){
        int sheepResult = 0;
        int wolvesResult = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(s[i].charAt(j) == '#') continue;
                if(visit[i][j]) continue;
                dfs(i, j);
                if(sheep > wolves) sheepResult += sheep;
                else wolvesResult += wolves;
                sheep = 0;
                wolves = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sheepResult).append(' ').append(wolvesResult);
        System.out.println(stringBuilder);
    }
    private static void dfs(int y, int x) {
        if(s[y].charAt(x) == 'o') sheep++;
        if(s[y].charAt(x) == 'v') wolves++;
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][1];
            int ny = y + dir[i][0];
            if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if(visit[ny][nx]) continue;
            if(s[ny].charAt(nx) == '#') continue;
            dfs(ny, nx);
        }
    }
}
