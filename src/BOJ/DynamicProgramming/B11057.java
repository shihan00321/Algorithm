package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11057 {
    static int N;
    static int[][] arr = new int[1001][10];
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    public static void algo(){
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i < 1001; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k];
                    //값을 다 더한 후 모듈러 연산을 하면 오버플로우 발생 -> 매 순간 모듈러 연산하고 더 해줘도 똑같음
                    arr[i][j] %= 10007;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += arr[N][i];
            result %= 10007;
        }
        System.out.println(result);
    }
}