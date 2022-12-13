package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068 {
    static int N, remove, count, root;
    static int[] parents;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        if(root != remove) dfs(root, parents[root]);
        System.out.println(count);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1) {
                root = i;
                continue;
            }
            arr[parents[i]].add(i);
            arr[i].add(parents[i]);
        }
        remove = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (arr[i].contains(remove)){
                arr[i].remove(arr[i].indexOf(remove));
            }
        }
    }
    private static void dfs(int start, int parent) {
        //루트 노드 하나만 있을 경우 예외처리
        if(arr[start].size() == 0 && start == root) count = 1;
        if(arr[start].size() == 1 && start != root) count++;
        for(int x : arr[start]){
            if(x == start) continue;
            if(x != parent) {
                dfs(x, parents[x]);
            }
        }
    }
}