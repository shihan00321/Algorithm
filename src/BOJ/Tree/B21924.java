package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *     크루스칼 알고리즘 -> 최소 신장 트리를 구할 때 사용
 *     간선의 비용이 작은 순서대로 확인
 *     확인한 간선이 추가되었을 때 사이클이 발생되지 않아야함
 *     트리이므로 간선은 정점의 개수 - 1개 있어야함
 */
public class B21924 {
    static int N, M, edge;
    static long result;
    static ArrayList<Info> arr;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Info(x, y, w));
            result += w;
        }
    }
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return false;
        parent[y] = x;
        return true;
    }
    public static void algo(){
        Collections.sort(arr);
        for (int i = 0; i < M; i++) {
            Info info = arr.get(i);
            if(union(info.nodeA, info.nodeB)) {
                result -= info.weight;
                edge++;
            }
        }
        if(edge == N - 1) System.out.println(result);
        else System.out.println(-1);
    }
    static class Info implements Comparable<Info> {
        int nodeA, nodeB, weight;
        public Info(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }
        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }
}