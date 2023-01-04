package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11066 {
    static int T, K;
    static int[] file;
    static int[][] dy, sum;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0 ){
            K = Integer.parseInt(br.readLine());
            dy = new int[K][K];
            sum = new int[K][K];
            file = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i][i] = file[i];
            }
            for (int i = 0; i < K; i++) {
                for (int j = i; j < K; j++) {
                    if(j == 0) continue;
                    sum[i][j] = sum[i][j - 1] + file[j];
                }
            }
            algo();
        }
    }
    public static void algo(){
        for (int len = 2; len <= K; len++) {
            for (int i = 0; i <= K - len; i++) {
                int j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + sum[i][j]);
                }
            }
        }
        stringBuilder.append(dy[0][K - 1]).append('\n');
    }
}