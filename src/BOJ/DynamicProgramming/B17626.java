package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17626 {
    static int n;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dy[n]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dy = new int[n + 1];
        dy[1] = 1;
        for (int i = 2; i <= n; i++) {
            dy[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= n; i++) {
            dy[i] = dy[i - 1] + 1; // 전의 경우에 1^2을 추가하는 경우
            for (int j = 1; j * j <= i; j++) {
                dy[i] = Math.min(dy[i], dy[i - j * j] + 1);
            }
        }
    }
}