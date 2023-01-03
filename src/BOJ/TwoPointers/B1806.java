package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int sum = 0, result = N + 1;
        for (int l = 0, r = 0; l < N; l++) {
            while (r < N && sum < S) {
                sum += arr[r];
                r++;
            }
            if(sum >= S) result = Math.min(result, r - l);
            sum -= arr[l];
        }
        if(result == N + 1) System.out.println(0);
        else System.out.println(result);
    }
}