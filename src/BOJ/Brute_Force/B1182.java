package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
    static int N, S, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo(0, 0);
        if(S == 0) System.out.println(result - 1);
        else System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(int depth, int value){
        if(depth == N) {
            if (value == S) result++;
        }
        else {
            algo(depth + 1, value + arr[depth]);
            algo(depth + 1, value);
        }
    }
}