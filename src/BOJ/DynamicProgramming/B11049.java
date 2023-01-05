package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049 {
    static int N;
    static Matrix[] matrices;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(dy[1][N]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrices = new Matrix[N + 1];
        dy = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            matrices[i] = new Matrix(x, y);
        }
    }
    public static void algo(){ //i, j i에서 j 까지 행렬의 곱
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + matrices[i].n * matrices[k].m * matrices[j].m);
                }
            }
        }
    }
    static class Matrix {
        int n;
        int m;
        public Matrix(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}