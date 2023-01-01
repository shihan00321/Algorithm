package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20364 {
    static int N, Q;
    static boolean[] visit;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        Q = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= Q; i++) {
            int x = Integer.parseInt(br.readLine());
            stringBuilder.append(bfs(x)).append('\n');
        }
    }
    public static int bfs(int x){
        int result = 0, y = x;
        while (y != 1) {
            if(visit[y]) result = y;
            y >>= 1;
        }
        if (result == 0) visit[x] = true;
        return result;
    }
}