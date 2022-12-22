package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1309_2 {
    static int N;
    static int[] zoo;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        zoo = new int[N + 1];
    }
    public static void algo(){
        zoo[1] = 3;
        if(N >= 2) zoo[2] = 7;
        for (int i = 3; i <= N; i++) {
            zoo[i] = (zoo[i - 1] * 2 + zoo[i - 2]) % 9901;
        }
        System.out.println(zoo[N]);
    }
}