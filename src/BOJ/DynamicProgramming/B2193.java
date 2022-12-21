package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2193 {
    static int N;
    static long[] dy;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new long[N + 1];
        //각각 1, 10 하나만 가능, 점화식 마지막 숫자가 1일때는 그대로, 0일 때는 두 가지 경우이므로 1개씩 증가함
        dy[1] = 1;
        if(N >= 2) dy[2] = 1;
        for (int i = 3; i <= N; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        System.out.println(dy[N]);
    }
}