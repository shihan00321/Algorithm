package BOJ.Topological_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2623 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static int[] inDegree;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n - 1; j++) {
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                inDegree[y]++;
                x = y;
            }
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int target = queue.poll();
            result.add(target);
            for (int x :arr[target]){
                inDegree[x]--;
                if(inDegree[x] == 0) queue.add(x);
            }
        }
        if(result.size() != N) stringBuilder.append(0);
        else {
            for (Integer integer : result) {
                stringBuilder.append(integer).append('\n');
            }
        }
    }
}