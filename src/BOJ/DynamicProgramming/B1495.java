package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1495 {
    static int N, S, M;
    static int[] volume;
    public static void main(String[] args) throws IOException {
        System.out.println(input());
    }
    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        volume = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        //시작
        for (int i = 0; i <= M; i++) {
            volume[i] = -1;
        }
        volume[S] = 0;
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int V = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if(volume[j] == i - 1) {
                    if(j - V >= 0)  arr.add(j - V);
                    if(j + V <= M) arr.add(j + V);
                }
            }
            for (int playPossible : arr) {
                volume[playPossible] = i;
            }
        }
        int result = -1;
        for (int i = 0; i <= M; i++) {
            //최종 N번 연주했을 때 최댓값
            if(volume[i] == N) result = Math.max(result, i);
        }
        return result;
    }
}