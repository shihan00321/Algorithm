package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11052 {
    static int N;
    static int[] card, dy;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dy[N]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1];
        card = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        dy[1] = card[1];
        dy[2] = Math.max(card[2], dy[1] * 2);
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dy[i] = Math.max(dy[i], dy[i - j] + card[j]);
            }
        }
    }
}