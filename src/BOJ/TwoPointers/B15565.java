package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15565 {
    static int N, K;
    static int[] doll;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        doll = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int r = 1;
        int dollCount = 0;
        int result = N + 1;
        for (int i = 1; i <= N ; i++) {
            while (r < N + 1 && dollCount != K){
                if(doll[r] == 1){
                    dollCount++;
                }
                r++;
            }
            if (dollCount == K){
                result = Math.min(result, r - i);
            }
            if(doll[i] == 1){
                dollCount--;
            }
        }
        if(result == N + 1){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
