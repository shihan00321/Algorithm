package BOJ.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1005 {
    static int N, K;
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer>[] arr;
    static int[] inDegree, minBuild, buildTime;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N + 1];
            minBuild = new int[N + 1];
            inDegree = new int[N + 1];
            buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
                minBuild[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                inDegree[y]++;
            }
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            algo(target);
        }
    }
    public static void algo(int target){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                buildTime[i] = minBuild[i];
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int y : arr[x]){
                inDegree[y]--;
                buildTime[y] = Math.max(buildTime[y], buildTime[x]);
                if(inDegree[y] == 0) {
                    queue.add(y);
                    buildTime[y] += minBuild[y];
                }
            }
        }
        stringBuilder.append(buildTime[target]).append('\n');
    }
}