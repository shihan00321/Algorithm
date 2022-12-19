package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15991 {
    static int T;
    static long[] dy = new long[100001];
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        algo();
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int target = Integer.parseInt(br.readLine());
            stringBuilder.append(dy[target]).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void algo(){
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 2;
        dy[4] = 3;
        dy[5] = 3;
        dy[6] = 6;
        for (int i = 7; i <= 100000; i++) {
            dy[i] = (dy[i - 2] + dy[i - 4] + dy[i - 6]) % 1000000009;
        }
    }
}