package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13144 {
    static int n;
    static int[] arr;
    static int[] count;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[100001];
    }
    public static void algo(){
        long result = 0;
        for (int i = 1, r = 1; i <= n; i++) {
            while (r < n + 1 && count[arr[r]] == 0){
                count[arr[r]]++;
                r++;
            }
            result += r - i;
            count[arr[i]]--;
        }
        System.out.println(result);
    }
}
