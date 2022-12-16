package BOJ.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2637 {
    static int N, M;
    static ArrayList<Part>[] arr;
    static int[] inDegree, needPart;
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean[] basicPart;
    static class Part {
        int data;
        int count;
        public Part(int data, int count) {
            this.data = data;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        needPart = new int[N + 1];
        basicPart = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            basicPart[i] = true;
        }
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            Part part = new Part(data, count);
            arr[target].add(part);
            inDegree[data]++;
            basicPart[target] = false;
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                needPart[i] = 1;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(Part part : arr[x]){
                needPart[part.data] += part.count * needPart[x];
                inDegree[part.data]--;
                if(inDegree[part.data] == 0) {
                    queue.add(part.data);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(basicPart[i]) stringBuilder.append(i).append(' ').append(needPart[i]).append('\n');
        }
    }
}