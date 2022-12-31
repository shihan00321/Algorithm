package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
    static int n;
    static int[] wine;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wine = new int[n + 1];
        //0 연속으로 마시는 경우, 1 직전의 잔을 마시지 않는 경우 or 2잔을 건너뛰고 마시는 경우 (o o x x o o)경우만 존재
        dy = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        int result = Integer.MIN_VALUE;
        dy[1][0] = wine[1];
        if(n >= 2) {
            dy[2][0] = dy[1][0] + wine[2];
            dy[2][1] = wine[2];
        }
        for (int i = 3; i <= n; i++) {
            dy[i][0] = dy[i - 1][1] + wine[i];
            dy[i][1] = Math.max(Math.max(dy[i - 2][0] + wine[i], dy[i - 2][1] + wine[i]), dy[i - 3][0] + wine[i]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                result = Math.max(result, dy[i][j]);
            }
        }
        System.out.println(result);
    }
}