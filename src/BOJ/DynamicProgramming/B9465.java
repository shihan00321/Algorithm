package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {
    static int T, n;
    static int[][] dy, sticker;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            n = Integer.parseInt(br.readLine());
            dy = new int[2][n + 1];
            sticker = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            algo();
        }
        System.out.println(stringBuilder);
    }
    public static void algo(){
        dy[0][1] = sticker[0][1];
        dy[1][1] = sticker[1][1];
        if(n >= 2) {
            dy[0][2] = sticker[1][1] + sticker[0][2];
            dy[1][2] = sticker[0][1] + sticker[1][2];
        }
        int result = 0;
        for (int i = 3; i <= n; i++) {
            dy[0][i] = Math.max(dy[1][i - 1] + sticker[0][i], Math.max(dy[0][i - 2] + sticker[0][i], dy[1][i - 2] + sticker[0][i]));
            dy[1][i] = Math.max(dy[0][i - 1] + sticker[1][i], Math.max(dy[0][i - 2] + sticker[1][i], dy[1][i - 2] + sticker[1][i]));
        }
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, Math.max(dy[0][i], dy[1][i]));
        }
        stringBuilder.append(result).append('\n');
    }
}