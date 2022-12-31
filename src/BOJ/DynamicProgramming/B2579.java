package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
    static int n;
    static int[] stairs;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(Math.max(dy[n][0], dy[n][1]));
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        //0 직전 계단을 밟는 경우, 1 직전 계단을 밟지 않는 경우
        dy = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        dy[1][0] = stairs[1];
        if(n >= 2) {
            dy[2][0] = dy[1][0] + stairs[2];
            dy[2][1] = stairs[2];
        }
        for (int i = 3; i <= n; i++) {
            dy[i][0] = dy[i - 1][1] + stairs[i];
            dy[i][1] = Math.max(dy[i - 2][0] + stairs[i], dy[i - 2][1] + stairs[i]);
        }
    }
}