package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11066 {
    static int T, K;
    static int[] arr;
    static int[][] dy, sum;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            K = Integer.parseInt(br.readLine());
            arr = new int[K + 1];
            //sum[i, j] -> i에서 j까지 합
            sum = new int[K + 1][K + 1];
            dy = new int[K + 1][K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i][i] = arr[i];
            }
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K; j++) {
                    if(i == j || i > j) continue;
                    sum[i][j] = sum[i][j - 1] + arr[j];
                }
            }
            //구할 길이 -> len = 2라면 (1, 2), (2, 3), (3, 4)을 나타냄
            for (int len = 2; len <= K; len++) {
                //행
                for (int i = 1; i <= K - len + 1; i++) {
                    //열
                    int j = i + len - 1;
                    dy[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + sum[i][j]);
                    }
                }
            }
            stringBuilder.append(dy[1][K]).append('\n');
        }
        System.out.println(stringBuilder);
    }
}