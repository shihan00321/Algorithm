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
        dy = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        //a,0 -> 직전 것을 마시는 경우,  a,1 -> i - 2 것을 마시는 경우 or i - 3을 마시는 경우
        dy[1][0] = wine[1];
        dy[1][1] = 0;
        if(n >= 2){
            dy[2][0] = wine[1] + wine[2];
            dy[2][1] = wine[2];
        }
        for (int i = 3; i <= n; i++) {
            dy[i][0] = dy[i - 1][1] + wine[i];
            dy[i][1] = Math.max(Math.max(dy[i - 2][0] + wine[i], dy[i - 2][1] + wine[i]), dy[i - 3][0] + wine[i]);
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, Math.max(dy[i][0], dy[i][1]));
        }
        System.out.println(result);
    }
}