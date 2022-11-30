package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795 {
    public static int N, M;
    public static int[] A, B;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스
        int T;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            algo();
        }
    }
    public static int lower_bound(int[] B, int l, int r, int x){
        int result = 0;
        while (l <= r){
            int mid = (l + r) / 2;
            if(B[mid] < x) {
                //index = 0부터 시작이므로 개수는 + 1을 해주어야 함
                result = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
    public static void algo(){
        Arrays.sort(B);
        int result = 0;
        for (int i = 0; i < N; i++) {
            //배열 B에서 A[i]보다 작은 것이 몇 개 있는지?
            result += lower_bound(B, 0, M-1, A[i]);
        }
        System.out.println(result);
    }
}
