package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870 {
    static int n;
    static int[] fibonacci = new int[21];
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(fibonacci[n]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
    public static void algo(){
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < 21; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }
}