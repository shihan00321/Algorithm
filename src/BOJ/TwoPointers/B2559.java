package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {
    static int N, K;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int maxTemp = 0;
        int count = 0;
        int r = 1;
        int result = Integer.MIN_VALUE;
        for (int l = 1; l <= N - K + 1; l++) {
            while(r < N + 1 && count < K){
                maxTemp += temp[r];
                r++;
                count++;
            }
            result = Math.max(result, maxTemp);
            maxTemp -= temp[l];
            count--;
        }
        System.out.println(result);
    }
}
