package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    static int N, K, count;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(count);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
        for (int i = N - 1; i >= 0; i--) {
            if(K >= coin[i]) {
                count += K / coin[i];
                K %= coin[i];
            }
        }
    }
}