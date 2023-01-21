package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22857 {
    static int N, K, result;
    static int[] arr;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dy = new int[N + 1][K + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            if(arr[i] % 2 == 0) dy[i][0] = dy[i - 1][0] + 1;
            for (int j = 1; j <= K; j++) {
                if(arr[i] % 2 == 0) dy[i][j] = dy[i - 1][j] + 1;
                else dy[i][j] = dy[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dy[i][K]);
        }
    }
}