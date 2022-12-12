package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3584 {
    static int N, root, target1, target2;
    static ArrayList<Integer>[] arr;
    static int[] parents, depths;
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
            arr = new ArrayList[N + 1];
            depths = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parents[y] = x;
                arr[x].add(y);
                arr[y].add(x);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            target1 = Integer.parseInt(st.nextToken());
            target2 = Integer.parseInt(st.nextToken());
            findRoot();
            findDepth(root, 0);
            findAncestor();
        }
    }
    private static void findRoot() {
        for (int i = 1; i <= N; i++) if(parents[i] == 0) root = i;
    }
    private static void findDepth(int target, int depth) {
        for (int x : arr[target]){
            if (x == parents[target]) continue;
            findDepth(x, depth + 1);
        }
        depths[target] = depth;
    }
    private static void findAncestor(){
        int t1_Ancestor = target1, t2_Ancestor = target2;
        while (depths[t1_Ancestor] != depths[t2_Ancestor] || parents[t1_Ancestor] != parents[t2_Ancestor] || t1_Ancestor != t2_Ancestor){
            if(depths[t1_Ancestor] >= depths[t2_Ancestor]) {
                t1_Ancestor = parents[t1_Ancestor];
            } else {
                t2_Ancestor = parents[t2_Ancestor];
            }
        }
        stringBuilder.append(t1_Ancestor).append('\n');
    }
}
