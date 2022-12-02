package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003 {
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
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int count = 0;
        int r = 1;
        int sum = 0;
        for (int l = 1; l <= N; l++) {
            while (r < N + 1 && sum < M){
                sum += arr[r];
                r++;
            }
            if(sum == M){
                count++;
            }
            sum -= arr[l];
        }
        System.out.println(count);
    }
}
