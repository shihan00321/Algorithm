package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13144 {
    static int N;
    static long result = 0;
    static int[] arr, count;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[100001];
    }
    public static void algo() {
        for (int l = 0, r = 0; l < N; l++) {
            while(r < N && count[arr[r]] == 0) {
                count[arr[r]]++;
                r++;
            }
            result += r - l;
            count[arr[l]]--;
        }
    }
}