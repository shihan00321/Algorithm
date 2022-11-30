package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
    static int n;
    static int x;
    static int[] a;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

    }
    public static boolean binarySearch(int key, int l, int r){
        while (l <= r){
            int mid = (l + r) / 2;
            if(key + a[mid] < x){
                l = mid + 1;
            }
            else if(key + a[mid] > x){
                r = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void algo(){
        Arrays.sort(a);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(binarySearch(a[i], 1, n)){
                result++;
            }
        }
        System.out.println(result/2);
    }
}
