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
    static class Node {
        int dest;
        int weight;
        public Node(int dest, int weight) {
            this.dest = dest;
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
            int w = Integer.parseInt(st.nextToken());
            arr[x].add(new Node(y, w));
            arr[y].add(new Node(x, w));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());
            dfs(targetA, targetB, 0, -1);
        }
    }
    public static void dfs(int A, int B , int weight, int parent){
        if(A == B) {
            stringBuilder.append(weight).append('\n');
            return;
        }
        for(Node node : arr[A]) {
            if(node.dest == parent) continue;
            dfs(node.dest, B, weight + node.weight, A);
        }
    }
}