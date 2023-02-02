package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
    static int T, N, M;
    static Queue<Integer> priority, index;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        index = new LinkedList<>();
        priority = new LinkedList<>();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            priority.clear();
            index.clear();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                index.add(i);
                priority.add(Integer.parseInt(st.nextToken()));
            }
            algo();
        }
    }
    public static void algo(){
        int count = 0;
        while (!priority.isEmpty()) {
            int max = Collections.max(priority);
            int target = priority.poll();
            int i = index.poll();
            if(target == max){
                count++;
                if(i == M) break;
            }
            else {
                //뽑은 문서가 우선순위가 높지 않다면 다시 뒤로 집어 넣음
                priority.add(target);
                index.add(i);
            }
        }
        stringBuilder.append(count).append('\n');
    }
}