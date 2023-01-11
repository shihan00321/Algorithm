package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22254 {
    static int N, X, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(K);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    //line만큼으로 시간 안에 가능한가?
    public static boolean isPossible(int line) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= line; i++) {
            queue.add(0);
        }
        for (int i = 1; i <= N; i++) {
            int x = queue.poll();
            if (x + arr[i] > X) return false;
            queue.add(x + arr[i]);
        }
        return true;
    }
    public static void algo(){
        int l = 1, r = N; K = N;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(isPossible(mid)) {
                K = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
    }
}