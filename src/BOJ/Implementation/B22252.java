package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22252 {
    static int Q, id;
    static long result;
    static PriorityQueue<Integer>[] queue;
    static HashMap<String, Integer> hashMap;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        queue = new PriorityQueue[100001];
        hashMap = new HashMap<>();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(!hashMap.containsKey(name)) {
                hashMap.put(name, ++id);
                //minHeap -> maxHeap 변환
                queue[id] = new PriorityQueue<>(Comparator.reverseOrder());
            }
            int pid = hashMap.get(name);
            if(query == 1) {
                int count = Integer.parseInt(st.nextToken());
                while (count-- > 0) {
                    queue[pid].add(Integer.parseInt(st.nextToken()));
                }
            }
            else {
                int count = Integer.parseInt(st.nextToken());
                while (count-- > 0 && queue[pid].size() != 0) {
                    result += queue[pid].poll();
                }
            }
        }
    }
}