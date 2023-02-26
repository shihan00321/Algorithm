package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
    static int N;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int i = Math.abs(o1) - Math.abs(o2);
            if(i > 0) return i;
            else if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return -1;
        });
        int num;
        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());
            if(num != 0) queue.add(num);
            else {
                if(!queue.isEmpty()) stringBuilder.append(queue.poll()).append('\n');
                else stringBuilder.append(0).append('\n');
            }
        }
    }
}