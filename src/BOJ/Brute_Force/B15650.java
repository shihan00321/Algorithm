package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
    static int N, M;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo(1);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
    }
    public static void algo(int depth){
        if(depth == M + 1){
            for (int i = 1; i <= M; i++) {
                stringBuilder.append(arr[i]).append(' ');
            }
            stringBuilder.append('\n');
        }
        else {
            for (int i = 1; i <= N; i++) {
                if(depth != 1 && arr[depth - 1] >= i) continue;
                arr[depth] = i;
                algo(depth + 1);
                arr[depth] = 0;
            }
        }
    }
}