package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10942 {
    static int N, M;
    static int[] arr;
    static int[][] dy;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dy = new int[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        algo();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stringBuilder.append(dy[x][y]).append('\n');
        }
        System.out.println(stringBuilder);
    }
    public static void algo(){
        //dy[i][j] -> i~j 팰린드롬인가? -> i,j가 같고 dy[i + 1],dy[j - 1]이 팰린드롬이라면 그 수는 팰린드롬
        //i == j라면 그 수는 팰린드롬
        for (int i = 1; i <= N; i++) {
            dy[i][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            if(arr[i] == arr[i + 1]) dy[i][i + 1] = 1;
            else dy[i][i + 1] = 0;
        }
        for (int len = 3; len <= N; len++) {
            //len이 커질수록 i는 줄음 -> 빼야함
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if(arr[i] == arr[j] && dy[i + 1][j - 1] == 1) dy[i][j] = 1;
            }
        }
    }
}