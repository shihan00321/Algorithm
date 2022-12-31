package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5557 {
    static int N;
    static int[] arr;
    static long[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dy = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        dy[1][arr[1]] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 21; j++) {
                if(dy[i - 1][j] != 0){
                    if(j - arr[i] >= 0) dy[i][j - arr[i]] += dy[i - 1][j];
                    if(j + arr[i] <= 20) dy[i][j + arr[i]] += dy[i - 1][j];
                }
            }
        }
        System.out.println(dy[N - 1][arr[N]]);
    }
}