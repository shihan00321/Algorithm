package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22863 {
    static int N;
    static long K;
    static int[] S, D, cycle, result;
    static boolean[] used;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        S = new int[N + 1];
        D = new int[N + 1];
        cycle = new int[N + 1];
        result = new int[N + 1];
        used = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        for (int i = 1; i <= N; i++) {
            if(used[i]) continue;
            int size = 0;
            int j = i;
            while (true) {
                cycle[size++] = j;
                used[j] = true;
                j = D[j];
                if(i == j) break;
            }
            for (j = 0; j < size; j++) {
                int now = cycle[j];
                int next = cycle[(int) ((j % size + K % size) % size)];
                result[next] = S[now];
            }
        }
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(result[i]).append(' ');
        }
    }
}