package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    static int T;
    static int[] dy = new int[12];
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
        dy[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }
    }
}
