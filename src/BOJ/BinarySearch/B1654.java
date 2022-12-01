package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {
    static int K, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
    public static boolean cutLine(long x){
        int count = 0;
        for (int i = 0; i < K; i++) {
            if(arr[i] >= x){
                count += arr[i]/x;
            }
        }
        return count >= N;
    }
    public static void algo(){
        long l = 1;
        long r = Integer.MAX_VALUE;
        long result = r;
        while (l <= r){
            long mid = (l + r) / 2;
            if(cutLine(mid)){
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
