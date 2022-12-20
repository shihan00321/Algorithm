package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
    static int n;
    static int[] stair;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stair = new int[n];
        dy = new int[n][2];
        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        dy[0][0] = stair[0];
        if(n >= 2){
            dy[1][0] = stair[0] + stair[1];
            dy[1][1] = stair[1];
        }
        for (int i = 2; i < n; i++) {
            dy[i][0] = dy[i-1][1] + stair[i];
            dy[i][1] = Math.max(dy[i-2][1] + stair[i], dy[i-2][0] + stair[i]);
        }
        System.out.println(Math.max(dy[n - 1][0], dy[n - 1][1]));
    }
}