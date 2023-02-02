package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10773 {
    static int K;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                stack.pop();
            }
            else stack.push(num);
        }
        int sum = 0;
        for(int num : stack) sum += num;
        System.out.println(sum);
    }
}