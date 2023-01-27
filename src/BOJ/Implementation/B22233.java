package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B22233 {
    static int N, M;
    static HashSet<String> memo;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new HashSet<>();
        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }
        int count = memo.size();
        for (int i = 0; i < M; i++) {
            String[] blog = br.readLine().split(",");
            for (int j = 0; j < blog.length; j++) {
                if(memo.contains(blog[j])) {
                    count--;
                    memo.remove(blog[j]);
                }
            }
            stringBuilder.append(count).append('\n');
        }
    }
}