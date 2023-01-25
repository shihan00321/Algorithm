package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21772 {
    static int R, C, T, result; //세로 가로 시간
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        int x = 0, y = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'G') {
                    x = j;
                    y = i;
                }
            }
        }
        dfs(x, y, 0, 0);
    }
    public static void dfs(int x, int y, int time, int sweetPotato){
        if(time == T) {
            result = Math.max(result, sweetPotato);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][1];
            int ny = y + dir[i][0];
            if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if(map[ny][nx] == '#') continue;
            if(!visit[ny][nx] && map[ny][nx] == 'S') {
                visit[ny][nx] = true; //visit 배열은 고구마가 있는 위치에 가서 이미 고구마를 먹은 경우를 처리하기 위함
                dfs(nx, ny, time + 1, sweetPotato + 1);
                visit[ny][nx] = false;
            }
            else dfs(nx, ny, time + 1, sweetPotato);
        }
    }
}