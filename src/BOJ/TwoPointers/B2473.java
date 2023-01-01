package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2473 {
    static int N, v1, v2, v3;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, N + 1);
    }
    public static void algo(){
        long result = Long.MAX_VALUE;
        for (int i = 1; i <= N - 2; i++) {
            int l = i + 1;
            int r = N;
            while (l < r){
                //Math.abs(arr[i] + arr[l] + arr[r]) 값이 int 값을 벗어나므로 long 변환
                if(result != Math.min(result, Math.abs(arr[l] + arr[r] + (long) arr[i]))){
                    result = Math.min(result, Math.abs(arr[l] + arr[r] + (long) arr[i]));
                    v1 = arr[i];
                    v2 = arr[l];
                    v3 = arr[r];
                }
                if(Math.abs(arr[i]) > Math.abs(arr[l] + arr[r])) l++;
                else r--;
            }
        }
        stringBuilder.append(v1).append(' ').append(v2).append(' ').append(v3);
    }
}