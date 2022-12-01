package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {
    static int N, M, sum;
    static int[] budget;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }
        M = Integer.parseInt(br.readLine());
    }
    public static boolean measure(int x){
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(x >= budget[i]){
                result += budget[i];
            } else {
                result += x;
            }
        }
        return result <= M;
    }
    public static void algo(){
        Arrays.sort(budget);
        if(M >= sum){
            System.out.println(budget[N - 1]);
            return;
        }
        int l = 1;
        int r = 1000000000;
        int result = 0;
        while (l <= r){
            int mid = (l + r) / 2;
            if(measure(mid)){
                result = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
