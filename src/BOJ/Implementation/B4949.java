package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949 {
    static String str;
    static Stack<Character> stack;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        str = br.readLine();
        while (!str.equals(".")) {
            stack.clear();
            algo();
            str = br.readLine();
        }
    }
    public static void algo(){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    stringBuilder.append("no").append('\n');
                    return;
                }
                stack.pop();
            }
            else if(str.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    stringBuilder.append("no").append('\n');
                    return;
                }
                stack.pop();
            }
        }
        //닫힌 괄호가 없을 때 무조건 yes가 나오므로 추가 조건 필요
        if(stack.isEmpty()) stringBuilder.append("yes").append('\n');
        else stringBuilder.append("no").append('\n');
    }
}