package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    /**
     * 점화식
     * 3으로 나누는 경우 : dy[i] = dy[i / 3] + 1
     * 2로 나누는 경우 : dy[i] = dy[i / 2] + 1
     * 1을 빼는 경우 : dy[i] = dy[i - 1] + 1
     */
    static int[] dy;
    static int X;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        dy = new int[X + 1];
    }
    public static void algo(){
        for (int i = 2; i <= X; i++) {
            dy[i] = dy[i - 1] + 1; //1을 빼는 경우
            if(i % 3 == 0) dy[i] = Math.min(dy[i], dy[i / 3] + 1);
            if(i % 2 == 0) dy[i] = Math.min(dy[i], dy[i / 2] + 1);
        }
        System.out.println(dy[X]);
    }
}