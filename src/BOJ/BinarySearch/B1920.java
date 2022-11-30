package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
    static int N, M;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static boolean binarySearch(int x, int l, int r){
        while (l <= r){
            int mid = (l + r) / 2;
            if(A[mid] > x){
                r = mid - 1;
            }
            else if(A[mid] < x) {
                l = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void algo(){
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            if(binarySearch(B[i], 0, N - 1)){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
