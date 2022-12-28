package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
    static int N, S, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo(1, 0);
        if(S == 0) System.out.println(--result);
        else System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(int depth, int cal){
        if(depth == N + 1) {
            if(cal == S) result++;
        }
        else {
            algo(depth + 1, cal + arr[depth]);
            algo(depth + 1, cal);
        }
    }
}