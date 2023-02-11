package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
    static int N;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > start) {
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    stringBuilder.append('+').append('\n');
                }
                start = num;
            }
            if(stack.peek() == num) {
                stack.pop();
                stringBuilder.append('-').append('\n');
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(stringBuilder);
    }
}