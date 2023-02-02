package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {
    static int N, M, result;
    static int[] card;
    static boolean[] pick;
    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        pick = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pick[i] = false;
            card[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void dfs(int sum, int count){
        if(count == 3) {
            if(sum <= M) result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(pick[i]) continue;
            pick[i] = true;
            dfs(sum + card[i], count + 1);
            pick[i] = false;
        }
    }
}