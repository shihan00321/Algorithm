package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B20181 {
    static int N, K;
    static long[] arr, dy;
    //info[r] -> r에서 끝나는 막대(만족도를 얻을 수 있는 막대)
    static ArrayList<Eating>[] eats;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(dy[N]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        dy = new long[N + 1];
        eats = new ArrayList[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            eats[i] = new ArrayList<>();
        }
    }
    public static void algo(){
        long sum = 0;
        int r = 1;
        //조건을 만족하는 막대를 모두 집어넣음
        for (int l = 1; l <= N; l++) {
            while (r < N && sum + arr[r] < K) {
                sum += arr[r];
                r++;
            }
            if(sum + arr[r] >= K) eats[r].add(new Eating(l, sum + arr[r] - K));
            sum -= arr[l];
        }
        for (int i = 1; i <= N; i++) {
            //아무 것도 먹지 않았을 때
            dy[i] = dy[i - 1];
            for(Eating eat : eats[i]) {
                dy[i] = Math.max(dy[i], dy[eat.l - 1] + eat.satisfied);
            }
        }
    }
    static class Eating {
        int l;
        long satisfied;
        public Eating(int l, long satisfied) {
            this.l = l;
            this.satisfied = satisfied;
        }
    }
}