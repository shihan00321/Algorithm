package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22856 {
    static int N, result;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2]; //0 -> left, 1 -> right
        result = (N - 1) * 2;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[data][0] = left;
            tree[data][1] = right;
        }
        int pos = 1;
        while (tree[pos][1] != -1) {
            pos = tree[pos][1];
            result--;
        }
    }
}