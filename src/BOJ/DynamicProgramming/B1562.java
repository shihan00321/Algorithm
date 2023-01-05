package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1562 {
    static int N;
    static long result;
    static long[][][] dy;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new long[N + 1][10][1 << 10];
        for (int i = 1; i <= 9; i++) {
            dy[1][i][1 << i] = 1;
        }
        //i 길이, j 마지막 수, k 비트 값
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 1023; k++) {
                    if(j == 0) dy[i][j][k | (1 << j)] += dy[i - 1][j + 1][k] % 1000000000;
                    else if(j == 9) dy[i][j][k | (1 << j)] += dy[i - 1][j - 1][k] % 1000000000;
                    else dy[i][j][k | (1 << j)] += dy[i - 1][j - 1][k] % 1000000000 + dy[i - 1][j + 1][k] % 1000000000;
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            result += dy[N][i][(1 << 10) - 1] % 1000000000;
            result %= 1000000000;
        }
        System.out.println(result);
    }
}