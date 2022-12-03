package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
    static int n, x;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
    }
    public static void algo(){
        Arrays.sort(arr);
        int result = 0;
        int l = 0, r = n - 1;
        while (l < r){
            if(arr[l] + arr[r] > x){
                r--;
            }
            else if(arr[l] + arr[r] < x){
                l++;
            } else {
                result++;
                r--;
                l++;
            }
        }
        System.out.println(result);
    }
}
