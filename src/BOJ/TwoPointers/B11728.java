package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11728 {
    static int[] A, B;
    static int N, M;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
    }
    public static void algo(){
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0, r = 0;
        while (l < N && r < M){
            if(A[l] >= B[r]){
                stringBuilder.append(B[r]).append(' ');
                r++;
            }
            else {
                stringBuilder.append(A[l]).append(' ');
                l++;
            }
        }
        while (l < N){
            stringBuilder.append(A[l]).append(' ');
            l++;
        }
        while (r < M){
            stringBuilder.append(B[r]).append(' ');
            r++;
        }
        System.out.println(stringBuilder);
    }
}
