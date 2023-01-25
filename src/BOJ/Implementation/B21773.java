package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B21773 {
    static int T, n;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Process  implements Comparable<Process>{
        int id, time, priority;
        public Process(int id, int time, int priority) {
            this.id = id;
            this.time = time;
            this.priority = priority;
        }
        @Override
        public int compareTo(Process o) {
            if(this.priority == o.priority) return this.id - o.id;
            return o.priority - this.priority;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        PriorityQueue<Process> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            queue.add(new Process(id, time, priority));
        }
        for (int i = 0; i < T; i++) {
            Process process = queue.poll();
            stringBuilder.append(process.id).append('\n');
            process.time--;
            process.priority--;
            //답은 실행되는 프로세스 ID가 아닌 선택되는 프로세스 ID임
            if(process.time > 0) queue.add(process);
        }
    }
}