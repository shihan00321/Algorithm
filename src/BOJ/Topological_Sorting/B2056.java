package BOJ.Topological_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2056 {
    static int N;
    static int[] inDegree, workTime, doneWorkTime;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        workTime = new int[N + 1];
        doneWorkTime = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            workTime[i] = time;
            for (int j = 0; j < pre; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[x].add(i);
                inDegree[i]++;
            }
        }
    }
    public static void algo(){
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                doneWorkTime[i] = workTime[i];
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int y : arr[x]){
                doneWorkTime[y] = Math.max(doneWorkTime[y], doneWorkTime[x] + workTime[y]);
                inDegree[y]--;
                if(inDegree[y] == 0) queue.add(y);
            }
        }
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, doneWorkTime[i]);
        }
        System.out.println(result);
    }
}