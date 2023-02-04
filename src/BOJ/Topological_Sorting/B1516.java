package BOJ.Topological_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {
    static int N;
    static int[] buildTime, inDegree, doneBuildTime;
    static ArrayList<Integer>[] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        buildTime = new int[N + 1];
        inDegree = new int[N + 1];
        doneBuildTime = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true){
                int x = Integer.parseInt(st.nextToken());
                if(x == -1) break;
                else {
                    arr[x].add(i);
                    inDegree[i]++;
                }
            }
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                doneBuildTime[i] = buildTime[i];
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int y : arr[x]){
                inDegree[y]--;
                doneBuildTime[y] = Math.max(doneBuildTime[x] + buildTime[y], doneBuildTime[y]);
                if(inDegree[y] == 0) queue.add(y);
            }
        }
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(doneBuildTime[i]).append('\n');
        }
    }
}