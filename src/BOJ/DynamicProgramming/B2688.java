package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2688 {
    static int T, n;
    static long[][] arr = new long[65][10];
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        algo();
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            n = Integer.parseInt(br.readLine());
            long result = 0;
            for (int i = 0; i < 10; i++) {
                result += arr[n][i];
            }
            stringBuilder.append(result).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void algo(){
        //arr[i][j] -> i번째 줄에 숫자 j가 들어갈 때 가능한 경우의 수
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += arr[i - 1][k];
                }
            }
        }
    }
}