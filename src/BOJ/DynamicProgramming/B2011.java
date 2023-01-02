package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2011 {
    static long[] dy = new long[5001];
    static int size;
    static String code;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dy[size - 1]);
        for (int i = 0; i < size; i++) {
            System.out.println(dy[i]);
        }
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine();
        size = code.length();
        if(code.charAt(0) != '0') dy[0] = 1;
        for (int i = 1; i < size; i++) {
            // 현재 숫자를 단독으로 해석 가능하다면 전의 경우의 수와 같음
            if (code.charAt(i) != '0') dy[i] = dy[i - 1];
            // 앞 숫자와 하나의 문자로 해석이 가능하다면? -> i - 2번의 경우에서 문자를 해석하거나 i - 1번의 경우에서 문자를 해석 할 수 있음.
            if (checkCode(code.charAt(i - 1), code.charAt(i))) {
                if (i >= 2) dy[i] += dy[i - 2];
                else dy[i] += 1;
                dy[i] %= 1000000;
            }
        }
    }
    //앞자리 0이면 불가능
    //앞자리 1이면 모두 가능
    //앞자리가 2이면 AB가 26이하여야함
    //그 외 모두 불가능
    static boolean checkCode(char A, char B) {
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;
        return B <= '6';
    }
}