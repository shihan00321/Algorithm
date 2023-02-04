package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20164 {
    static int min, max;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        stringBuilder.append(min).append(' ').append(max);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(Integer.parseInt(s), oddCount(Integer.parseInt(s)));
    }
    public static void dfs(int num, int count){
        String s = Integer.toString(num);
        if(num < 10) { //한 자릿수
           max = Math.max(max, count);
           min = Math.min(min, count);
           return;
        }
        else if(num < 100){ //두 자릿수
            dfs(num / 10 + num % 10, oddCount(num / 10 + num % 10) + count);
        }
        else {
            for (int i = 0; i < s.length() - 2; i++) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    String s1 = s.substring(0, i + 1);
                    String s2 = s.substring(i + 1, j + 1);
                    String s3 = s.substring(j + 1, s.length());
                    int next = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    dfs(next, count + oddCount(next));
                }
            }
        }
    }
    public static int oddCount(int num){
        int count = 0;
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            int one = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(one % 2 == 1) count++;
        }
        return count;
    }
}