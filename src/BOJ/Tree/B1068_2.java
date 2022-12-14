package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_2 {
    static int N, root, removeX;
    static int[] leaf;
    static ArrayList<Integer>[] children;
    public static void main(String[] args) throws IOException {
        input();
        if(removeX != root) dfs(root);
        System.out.println(leaf[root]);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) {
                root = i;
                continue;
            }
            children[x].add(i);
        }
        removeX = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if(children[i].contains(removeX)) children[i].remove(children[i].indexOf(removeX));
        }
    }
    public static void dfs(int x){
        if(children[x].size() == 0) leaf[x] = 1;
        for (int y : children[x]){
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
}