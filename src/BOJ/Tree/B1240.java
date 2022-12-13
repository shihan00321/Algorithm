package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1240 {
    static int N, M;
    static ArrayList<Node>[] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Node{
        int edge;
        int weight;
        public Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[x].add(new Node(y, weight));
            arr[y].add(new Node(x, weight));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
            dfs(target1, 0, target2, 0);
        }
    }
    private static void dfs(int target1, int parents, int target2, int depth) {
        if(target1 == target2) {
            stringBuilder.append(depth).append('\n');
            return;
        }
        for(Node node : arr[target1]) {
            if(node.edge == parents) continue;
            dfs(node.edge, target1, target2, depth + node.weight);
        }
    }
}