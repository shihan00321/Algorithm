package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static int count = 0;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            visit[i] = false;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            for (int x : arr[poll]) {
                if(visit[x]) continue;
                queue.add(x);
                visit[x] = true;
            }
        }
    }

    public static void algo(){
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
