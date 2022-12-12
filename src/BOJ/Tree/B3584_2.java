package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3584_2 {
    static int N, target1, target2;
    static boolean[] visit;
    static int[] parents;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];
            visit = new boolean[N + 1];
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parents[y] = x;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            target1 = Integer.parseInt(st.nextToken());
            target2 = Integer.parseInt(st.nextToken());
            findAncestor2(target1, target2);
        }
    }
    private static void findAncestor2(int target1, int target2) {
        while (target1 > 0) {
            visit[target1] = true;
            target1 = parents[target1];
        }
        while (target2 > 0){
            if(visit[target2]) break;
            target2 = parents[target2];
        }
        stringBuilder.append(target2).append('\n');
    }
}