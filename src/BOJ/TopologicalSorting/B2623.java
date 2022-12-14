package BOJ.TopologicalSorting;

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
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num - 1; j++) {
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                inDegree[y]++;
                x = y;
            }
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> sort = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            sort.add(x);
            for(int y : arr[x]){
                inDegree[y]--;
                if(inDegree[y] == 0) queue.add(y);
            }
        }
        if(sort.size() == N) {
            for (int x: sort) {
                stringBuilder.append(x).append('\n');
            }
        }
        else stringBuilder.append(0);
    }
}