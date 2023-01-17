package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21937 {
    static int N, M, target, result;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        input();
        bfs(target);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //반대로 넣어줌
            arr[y].add(x);
        }
        target = Integer.parseInt(br.readLine());
    }
    public static void bfs(int root){
       Queue<Integer> queue = new LinkedList<>();
       queue.add(root);
       visit[root] = true;
       while (!queue.isEmpty()) {
           int x = queue.poll();
           for(int y : arr[x]) {
               if(visit[y]) continue;
               result++;
               queue.add(y);
               visit[y] = true;
           }
       }
    }
}