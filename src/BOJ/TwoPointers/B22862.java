package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22862 {
    static int N, K, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int count = 0;
        for (int l = 1, r = 1; l <= N; l++) {
            while (r <= N) {
                if(arr[r] % 2 == 0) r++;
                else {
                    if(count >= K) break;
                    count++;
                    r++;
                }
            }
            result = Math.max(result, r - l - count);
            if(arr[l] % 2 == 1) count--;
        }
    }
}