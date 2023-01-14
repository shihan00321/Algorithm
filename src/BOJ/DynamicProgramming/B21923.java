package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21923 {
    static int N, M, result = Integer.MIN_VALUE;
    static int[][] arr, increaseDy, decreaseDy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 2][M + 2];
        increaseDy = new int[N + 2][M + 2];
        decreaseDy = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //초기값 상승비행
        for (int i = N; i >= 1; i--) {
            increaseDy[i][1] = increaseDy[i + 1][1] + arr[i][1];
        }
        for (int j = 1; j <= M; j++) {
            increaseDy[N][j] = increaseDy[N][j - 1] + arr[N][j];
        }
        //초기값 하강비행
        for (int i = N; i >= 1; i--) {
            decreaseDy[i][M] = decreaseDy[i + 1][M] + arr[i][M];
        }
        for (int j = M; j >= 1; j--) {
            decreaseDy[N][j] = decreaseDy[N][j + 1] + arr[N][j];
        }
    }
    public static void algo(){
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 2; j <= M; j++) {
                increaseDy[i][j] = Math.max(increaseDy[i][j - 1] + arr[i][j], increaseDy[i + 1][j] + arr[i][j]);
            }
        }
        for (int i = N - 1; i >= 1; i--) {
            for (int j = M - 1; j >= 1; j--) {
                decreaseDy[i][j] = Math.max(decreaseDy[i][j + 1] + arr[i][j], decreaseDy[i + 1][j] + arr[i][j]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                result = Math.max(result, increaseDy[i][j] + decreaseDy[i][j]);
            }
        }
    }
}