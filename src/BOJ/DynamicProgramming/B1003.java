package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {
    static int T;
    static Fibonacci[] fibonacci;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Fibonacci {
        int zero, one;
        public Fibonacci(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fibonacci = new Fibonacci[41];
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int target = Integer.parseInt(br.readLine());
            algo(target);
        }
    }
    public static void algo(int n){
        fibonacci[0] = new Fibonacci(1, 0);
        fibonacci[1] = new Fibonacci(0, 1);
        for (int i = 2; i <= 40; i++) {
            fibonacci[i] = new Fibonacci(fibonacci[i - 1].zero + fibonacci[i - 2].zero, fibonacci[i - 1].one + fibonacci[i - 2].one);
        }
        stringBuilder.append(fibonacci[n].zero).append(' ').append(fibonacci[n].one).append('\n');
    }
}