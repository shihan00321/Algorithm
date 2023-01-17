package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B21940 {
    static int N, M, K;
    static int[][] time;
    static ArrayList<Integer> friends, result;
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
        M = Integer.parseInt(st.nextToken());
        time = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(time[i], 1000000000);
            time[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            time[x][y] = t;
        }
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        friends = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            friends.add(Integer.valueOf(st.nextToken()));
        }
    }
    public static void algo(){
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
                }
            }
        }
        int maxTime = 1000000000;
        for (int i = 1; i <= N; i++) {
            int roundTime = 0;
            for (int j = 0; j < friends.size(); j++) {
                int city = friends.get(j);
                roundTime = Math.max(roundTime, time[city][i] + time[i][city]);
            }
            if(roundTime < maxTime) {
                result.clear();
                result.add(i);
                maxTime = roundTime;
            }
            else if(roundTime == maxTime) result.add(i);
        }
        for (int r : result) {
            stringBuilder.append(r).append(' ');
        }
    }
}