package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795 {
    static int T, N, M;
    static int[] A, B;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
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
            Arrays.sort(B);
            int result = 0;
            for (int i = 0; i < N; i++) {
                result += lower_bound(A[i]);
            }
            stringBuilder.append(result).append('\n');
        }
    }
    private static int lower_bound(int target) {
        int l = 0, r = M - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(target <= B[mid]) r = mid - 1;
            else l = mid + 1;
        }
        //l이 최종적으로 움직인 좌표까지가 먹을 수 있음 -> 실질적으로 l - 1까지 먹을 수 있지만 index 시작이 0 이므로 l + 1과 같음
        return l;
    }
}