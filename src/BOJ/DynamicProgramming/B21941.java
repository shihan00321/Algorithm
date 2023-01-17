package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21941 {
    static int N, M;
    static String s;
    static int[] dy;
    static ArrayList<Info> strings;
    static class Info {
        String part;
        int score;
        public Info(String part, int score) {
            this.part = part;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(dy[N]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();
        dy = new int[N + 1];
        strings = new ArrayList<>();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subString = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            if(score <= subString.length()) continue;
            strings.add(new Info(subString, score));
        }
    }
    public static void algo(){
        for (int i = 0; i < N; i++) {
            dy[i + 1] = Math.max(dy[i + 1], dy[i] + 1);
            for (Info info : strings) {
                if (!s.startsWith(info.part, i)) continue;
                dy[i + info.part.length()] = Math.max(dy[i + info.part.length()], dy[i] + info.score);
            }
        }
    }
}