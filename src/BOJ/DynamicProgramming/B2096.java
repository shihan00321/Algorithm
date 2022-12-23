package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {
    static int N;
    static int[][] arr, maxDy, minDy;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        maxDy = new int[N + 1][3];
        minDy = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxDy[1][0] = arr[1][0];
        maxDy[1][1] = arr[1][1];
        maxDy[1][2] = arr[1][2];
        minDy[1][0] = arr[1][0];
        minDy[1][1] = arr[1][1];
        minDy[1][2] = arr[1][2];
    }
    public static void algo(){
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    maxDy[i][j] = Math.max(maxDy[i - 1][0] + arr[i][j], maxDy[i - 1][1] + arr[i][j]);
                    minDy[i][j] = Math.min(minDy[i - 1][0] + arr[i][j], minDy[i - 1][1] + arr[i][j]);
                }
                if(j == 1) {
                    maxDy[i][j] = Math.max(Math.max(maxDy[i - 1][0] + arr[i][j], maxDy[i - 1][1] + arr[i][j]), maxDy[i - 1][2] + arr[i][j]);
                    minDy[i][j] = Math.min(Math.min(minDy[i - 1][0] + arr[i][j], minDy[i - 1][1] + arr[i][j]), minDy[i - 1][2] + arr[i][j]);
                }
                if(j == 2) {
                    maxDy[i][j] = Math.max(maxDy[i - 1][1] + arr[i][j], maxDy[i - 1][2] + arr[i][j]);
                    minDy[i][j] = Math.min(minDy[i - 1][1] + arr[i][j], minDy[i - 1][2] + arr[i][j]);
                }
            }
        }
        stringBuilder.append(Math.max(Math.max(maxDy[N][0], maxDy[N][1]), maxDy[N][2])).append(' ').append(Math.min(Math.min(minDy[N][0], minDy[N][1]), minDy[N][2]));
        System.out.println(stringBuilder);
    }
}