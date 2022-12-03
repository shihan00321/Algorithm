package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
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
        Arrays.sort(arr, 1, N + 1);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(isGood(i)){
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isGood(int target) {
        int l = 1, r = N;
        while (l < r){
            if(l == target) l++;
            else if(r == target) r--;
            else {
                if(arr[l] + arr[r] > arr[target]) r--;
                else if(arr[l] + arr[r] < arr[target]) l++;
                else return true;
            }
        }
        return false;
    }
}
