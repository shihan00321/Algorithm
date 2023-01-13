package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21918 {
    static int N, M;
    static int[] bulb;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(bulb[i]).append(' ');
        }
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bulb = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            changeBulb(command, i, x);
        }
    }
    private static void changeBulb(int command, int i, int x) {
       if(command == 1) bulb[i] = x;
       else if(command == 2){
           for (int j = i; j <= x; j++) {
               if(bulb[j] == 1) bulb[j] = 0;
               else bulb[j] = 1;
           }
       }
       else if(command == 3){
           for (int j = i; j <= x; j++) {
               bulb[j] = 0;
           }
       }
       else for (int j = i; j <= x; j++) bulb[j] = 1;
    }
}