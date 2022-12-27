package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    static int N, max, min;
    static int[] arr, operator, result;
    public static void main(String[] args) throws IOException {
        input();
        algo(0, arr[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(max).append('\n').append(min);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        //연산에 필요한 연산자를 기록
        result = new int[N - 1];
        //덧셈, 뺄셈, 곱셈, 나눗셈
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
    public static void algo(int depth, int cal){
        if(depth == N - 1){
            max = Math.max(max, cal);
            min = Math.min(min, cal);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if(operator[i] >= 1){
                    operator[i]--;
                    result[depth] = i;
                    int renew = cal;
                    if(i == 0) renew += arr[depth + 1];
                    else if(i == 1) renew -= arr[depth + 1];
                    else if(i == 2) renew *= arr[depth + 1];
                    else renew /= arr[depth + 1];
                    algo(depth + 1, renew);
                    operator[i]++;
                    result[depth] = 0;
                }
            }
        }
    }
}