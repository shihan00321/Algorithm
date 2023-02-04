package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22251 {
    static int N, K, P, X, result;
    static int[][] flag = {
            {1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 1, 0}, //1
            {1, 0, 1, 1, 1, 0, 1}, //2
            {1, 0, 1, 1, 0, 1, 1}, //3
            {0, 1, 1, 1, 0, 1, 0}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {1, 0, 1, 0, 0, 1, 0}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}, //9
    };
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }
    //x -> y로 변환시킬 때 반전시켜야 하는 개수
    public static int diff(int x, int y) {
        int count = 0;
        for (int j = 0; j < K; j++) {
            for (int i = 0; i <= 6; i++) {
                if(flag[x % 10][i] != flag[y % 10][i]) count++;
            }
            x /= 10;
            y /= 10;
        }
        return count;
    }
    public static void algo(){
        //1층부터 N층까지 확인
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            if(diff(X, i) <= P) result++;
        }
    }
}