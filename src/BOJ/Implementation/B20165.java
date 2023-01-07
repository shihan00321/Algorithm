package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20165 {
    static int N, M, R, result;
    static int[][] dominoes;
    static boolean[][] visit;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        stringBuilder.append(result).append('\n');
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(visit[i][j]) stringBuilder.append("F").append(' ');
                else stringBuilder.append("S").append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        dominoes = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                dominoes[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
            }
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int attackY = Integer.parseInt(st.nextToken());
            int attackX = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            attack(attackY, attackX, dir);
            st = new StringTokenizer(br.readLine());
            int defenseY = Integer.parseInt(st.nextToken());
            int defenseX = Integer.parseInt(st.nextToken());
            defense(defenseY, defenseX);
        }
    }
    private static void defense(int y, int x) {
        visit[y][x] = false;
    }
    private static void attack(int y, int x, String dir) {
        if(visit[y][x]) return;
        int ny = 0, nx = 0;
        int target = dominoes[y][x];
        if (dir.equals("E"))  nx = 1;
        else if (dir.equals("W"))  nx = -1;
        else if (dir.equals("S"))  ny = 1;
        else if(dir.equals("N")) ny = -1;
        while (x > 0 && x <= M && y > 0 && y <= N && target-- > 0) {
            if(!visit[y][x]) {
                result++;
                target = Math.max(target, dominoes[y][x] - 1);
                visit[y][x] = true;
            }
            x += nx;
            y += ny;
        }
    }
}
