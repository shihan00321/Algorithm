package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int s1 = 0, s2 = 0, l = 1, r = N;
        int result = Integer.MAX_VALUE;

        Arrays.sort(arr, 1, N + 1);
        while (l < r){
            int sum = arr[l] + arr[r];
            if(Math.abs(sum) < result){
                result = Math.abs(sum);
                s1 = arr[l];
                s2 = arr[r];
            }
            if(sum > 0){
                r--;
            } else {
                l++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s1).append(' ').append(s2);
        System.out.println(stringBuilder);
    }
}
