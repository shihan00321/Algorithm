package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22858 {
    static int N, K;
    static int[] arr, temp, pointer;
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
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        temp = new int[N + 1];
        pointer = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pointer[Integer.parseInt(st.nextToken())] = i;
        }
    }
    public static void algo(){
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                temp[j] = arr[pointer[j]];
            }
            for (int j = 1; j <= N; j++) {
                arr[j] = temp[j];
            }
        }
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(arr[i]).append(' ');
        }
    }
}