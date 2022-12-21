package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    static int N;
    static int[][] rgb, arr;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rgb = new int[N + 1][3];
        arr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        rgb[1][0] = arr[1][0];
        rgb[1][1] = arr[1][1];
        rgb[1][2] = arr[1][2];
        for (int i = 2; i <= N; i++) {
            rgb[i][0] = Math.min(rgb[i - 1][1] + arr[i][0], rgb[i - 1][2] + arr[i][0]);
            rgb[i][1] = Math.min(rgb[i - 1][0] + arr[i][1], rgb[i - 1][2] + arr[i][1]);
            rgb[i][2] = Math.min(rgb[i - 1][0] + arr[i][2], rgb[i - 1][1] + arr[i][2]);
        }
        System.out.println(Math.min(rgb[N][0], Math.min(rgb[N][1], rgb[N][2])));
    }
}