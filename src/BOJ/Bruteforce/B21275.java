package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21275 {
    static long resultX = -1, resultA, resultB;
    static int count;
    static String strA, strB;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        strA = st.nextToken();
        strB = st.nextToken();
    }
    public static void algo(){
        // 해당 진법으로 가능한가?
        for (int i = 2; i <= 36; i++) {
            long posA = possible(strA, i);
            if(posA == -1) continue;
            for (int j = 2; j <= 36; j++) {
                long posB = possible(strB, j);
                if(i == j) continue;
                if(posB == -1) continue;
                if(posA != posB) continue;
                if(count == 0) {
                    resultX = posA;
                    resultA = i;
                    resultB = j;
                }
                count++;
            }
        }
        if(resultX == -1) stringBuilder.append("Impossible");
        else if(count >= 2) stringBuilder.append("Multiple");
        else stringBuilder.append(resultX).append(' ').append(resultA).append(' ').append(resultB);
    }
    private static int change(char c) {
        if(c >= '0' && c <= '9') return c - '0';
        return c - 'a' + 10;
    }
    private static long possible(String s, int base){
        long x = 0;
        for(char c : s.toCharArray()){
            if(change(c) >= base) return -1;
            //x * base + change(c) > longValue를 넘어가면? -> 이항 시켜서 계산해야함
            if(x > (Long.MAX_VALUE - change(c)) / base) return -1;
            x = x * base + change(c);
        }
        return x;
    }
}