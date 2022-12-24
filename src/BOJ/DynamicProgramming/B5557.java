package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5557 {
    static int N;
    static int[] sum;
    static long[][] dy;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N + 1];
        dy = new long[N + 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken());
        }
        dy[1][sum[1]] = 1;
        for (int i = 2; i < N; i++) {
            int target = sum[i];
            for (int j = 0; j < 21; j++) {
                if(dy[i - 1][j] != 0) {
                    if(j - target >= 0) dy[i][j - target] += dy[i - 1][j];
                    if(j + target <= 20) dy[i][j + target] += dy[i - 1][j];
                }
            }
        }
        System.out.println(dy[N - 1][sum[N]]);
    }
}