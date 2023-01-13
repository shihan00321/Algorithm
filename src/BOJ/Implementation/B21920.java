package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21920 {
    //x, y의 최대 공약수가 1이라면 x, y는 서로소
    static int N, X, count;
    static long result;
    static int[] A;
    public static void main(String[] args) throws IOException {
        input();
        //절대/상대 오차는 10^-6
        System.out.printf("%.6f", (double) result / count);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if(gcd(X, A[i]) == 1) {
                result += A[i];
                count++;
            }
        }
    }
    public static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}