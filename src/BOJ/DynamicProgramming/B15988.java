package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15988 {
    static int T;
    static long[] dy;
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
            int target = Integer.parseInt(br.readLine());
            stringBuilder.append(dy[target]).append('\n');
        }
    }
    public static void algo(){
        dy = new long[1000001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3]) % 1000000009;
        }
    }
}