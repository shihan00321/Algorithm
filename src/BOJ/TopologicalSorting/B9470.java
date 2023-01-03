package BOJ.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9470 {
    static int T, K, M, P;
    static ArrayList<Integer>[] arr;
    static int[] inDegree, strahler, count;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            arr = new ArrayList[M + 1];
            inDegree = new int[M + 1];
            strahler = new int[M + 1];
            count = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                inDegree[y]++;
            }
            algo();
        }
    }
    public static void algo(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if(inDegree[i] == 0) {
                strahler[i] = 1;
                count[i] = 1;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : arr[x]) {
                inDegree[y]--;
                //이미 strahler 순서의 강물이 한번도 들어오지 않은 경우 or 두 가지 이상의 strahler 강물이 들어와 +1이 된 경우
                //순서가 더 큰 강물만 확인하면 된다.
                if(count[y] == 0) {
                    count[y] = 1;
                    strahler[y] = Math.max(strahler[y], strahler[x]);
                }
                else {
                    if(strahler[y] == strahler[x]) {
                        strahler[y]++;
                        count[y] = 0;
                    }
                    else strahler[y] = Math.max(strahler[y], strahler[x]);
                }
                if(inDegree[y] == 0) queue.add(y);
            }
        }
        int max = 0;
        for (int i = 1; i <= M; i++) {
            max = Math.max(max, strahler[i]);
        }
        stringBuilder.append(K).append(' ').append(max).append('\n');
    }
}