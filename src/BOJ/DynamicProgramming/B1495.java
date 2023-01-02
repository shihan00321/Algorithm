package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1495 {
    static int N, S, M, maxVolume = -1;
    static int[] volume;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dy = new int[N + 1][M + 1];
        dy[0][S] = 1;
        volume = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(dy[i - 1][j] != 0){
                    if(j - volume[i] >= 0) dy[i][j - volume[i]] += dy[i - 1][j];
                    if(j + volume[i] <= M) dy[i][j + volume[i]] += dy[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            if(dy[N][i] != 0) maxVolume = Math.max(maxVolume, i);
        }
        System.out.println(maxVolume);
    }
}