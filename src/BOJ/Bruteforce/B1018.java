package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {
    static int N, M, result;
    static String[] chess;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chess = new String[N];
        for (int i = 0; i < N; i++) {
            chess[i] = br.readLine();
        }
        result = Integer.MAX_VALUE;
        //체스판을 8 x 8 로 자를 때 시작 index
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int answer = algo(i, j);
                result = Math.min(result, answer);
            }
        }
    }
    public static int algo(int y, int x){
        String[] answer = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //짝수 줄에는 answer[0], 홀수 줄에는 answer[1]이 기록되어야 함
                if(chess[y + i].charAt(x + j) != answer[i % 2].charAt(j)) count++;
            }
        }
        // 위에서 돌린 방법은 시작을 하얀색으로 칠하였을 경우만 해당.
        // 총 체스판 칸 수는 64개이고 시작이 검은색일 경우는 64 - 하얀색으로 칠한 경우이므로 두 가지 경우를 모두 비교.
        return Math.min(count, 64 - count);
    }
}