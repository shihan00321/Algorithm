package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 {
    static int N;
    static int[] arr;
    static int[] sorted;
    static HashMap<Integer, Integer> rank;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        rank = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);
        int r = 0;
        for(int key : sorted) {
            if(!rank.containsKey(key)) {
                rank.put(key, r++);
            }
        }
        for(int key : arr) {
            stringBuilder.append(rank.get(key)).append(' ');
        }
    }
}