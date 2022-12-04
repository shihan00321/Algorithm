package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2473 {
    static int N;
    static int[] sol;
    static long result = Long.MAX_VALUE;
    static int v1 = 0, v2 = 0, v3 = 0;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sol = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        Arrays.sort(sol, 1, N + 1);
        for (int i = 1; i <= N - 2; i++) {
            minSolution(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(stringBuilder);
    }

    private static void minSolution(int index) {
        int l = index + 1, r = N;
        while (l < r) {
            if(result != Math.min(result, Math.abs(sol[l] + sol[r] + (long) sol[index]))){
                result = Math.min(result, Math.abs(sol[l] + sol[r] + (long) sol[index]));
                v1 = sol[index];
                v2 = sol[l];
                v3 = sol[r];
            }
            if(sol[l] + sol[r] > Math.abs(sol[index])){
                r--;
            } else {
                l++;
            }
        }
    }
}
