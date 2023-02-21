package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B11279 {
    static int N;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while(N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(!queue.isEmpty()) {
                    stringBuilder.append(queue.poll()).append('\n');
                }
                else stringBuilder.append(0).append('\n');
            }
            else queue.add(n);
        }
    }
}