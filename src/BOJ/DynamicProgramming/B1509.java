package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1509 {
    static int N;
    static String s;
    static int[][] dy;
    static int[] palindrome;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();
        dy = new int[N][N];
        palindrome = new int[N];
        for (int i = 0; i < N; i++) {
            dy[i][i] = 1;
            palindrome[i] = Integer.MAX_VALUE;
        }
    }
    public static void algo(){
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = len + i - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(len == 2) dy[i][j] = 1;
                    else { if(dy[i + 1][j - 1] == 1) dy[i][j] = 1; }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(dy[j][i] == 1) {
                    if(j == 0) palindrome[i] = 1;
                    else palindrome[i] = Math.min(palindrome[i], palindrome[j - 1] + 1);
                }
            }
        }
        System.out.println(palindrome[N - 1]);
    }
}