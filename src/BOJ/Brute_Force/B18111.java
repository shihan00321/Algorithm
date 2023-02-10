package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
    static int N, M, B, resultTime, resultHeight;
    static int[][] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        int min = 500, max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        resultTime = Integer.MAX_VALUE;
        algo(min, max);
    }
    public static void algo(int min, int max){
        for (int k = min; k <= max; k++) {
            int block = B, time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //지으려는 높이 k가 더 크다면? -> 블록을 소모해서 높이를 맞추어야함
                    if(arr[i][j] < k) {
                        block = block - (k - arr[i][j]);
                        time = time + (k - arr[i][j]);
                    }
                    else if(arr[i][j] >= k) {
                        block = block + (arr[i][j] - k);
                        time = time + ((arr[i][j] - k) * 2);
                    }
                }
            }
            //높이를 맞추었는데 블록이 모자라다면 할 수 없음
            if(block < 0) continue;
            if(resultTime >= time) {
                resultTime = time;
                resultHeight = k;
            }
        }
        stringBuilder.append(resultTime).append(' ').append(resultHeight);
    }
}