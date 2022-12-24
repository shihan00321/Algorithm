package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15990 {
    static int T, n;
    final static int MOD = 1000000009;
    static int[][] dy = new int[100001][4];
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        algo();
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 1; i <= 3; i++) {
                result = (result + dy[n][i]) % MOD;
            }
            stringBuilder.append(result).append('\n');
        }
    }
    public static void algo(){
        //i,j i자리 이면서, j로 끝나는 경우의 수
        dy[1][1] = 1;
        dy[2][2] = 1;
        dy[3][1] = 1;
        dy[3][2] = 1;
        dy[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            //끝 1인 경우 전의 경우의 수에서 마지막이 1인 것은 안됨. 11 연속되므로...
            //2, 3도 마찬가지
            dy[i][1] = (dy[i - 1][2] + dy[i - 1][3]) % MOD;
            dy[i][2] = (dy[i - 2][1] + dy[i - 2][3]) % MOD;
            dy[i][3] = (dy[i - 3][1] + dy[i - 3][2]) % MOD;
        }
    }
}