package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9489 {
    static int n, k, kIndex;
    static int[] arr;
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0) break;
            arr = new int[n];
            parent = new int[n];
            parent[0] = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (k ==arr[i]) kIndex = i;
            }
            algo();
        }
    }
    public static void algo(){
        int count = 0;
        int r = 1;
        for (int l = 0; l < n; l++) {
            while (r < n - 1 && arr[r + 1] - arr[r] == 1){
                parent[r] = l;
                parent[r + 1] = l;
                r++;
            }
           if(r < n - 1 && arr[r + 1] - arr[r] != 1){
               parent[r + 1] = l + 1;
               r++;
           }
        }
        for (int i = 1; i < n; i++) {
            if (parent[kIndex] != parent[i] && parent[parent[kIndex]] == parent[parent[i]]) count++;
        }
        stringBuilder.append(count).append('\n');
    }
}