package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2230 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        Arrays.sort(arr);
        int l, r = 1;
        int result = Integer.MAX_VALUE;
        for (l = 0; l < N; l++) {
            while (r < N){
                if(arr[r] - arr[l] < M){
                    r++;
                }
                else {
                    result = Math.min(result, arr[r] - arr[l]);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
