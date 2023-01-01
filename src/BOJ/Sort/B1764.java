package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1764 {
    static int N, M;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            hashMap.put(br.readLine(), 1);
        }
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(hashMap.containsKey(s)) arr.add(s);
        }
        Collections.sort(arr);
        stringBuilder.append(arr.size()).append('\n');
        for (String s : arr) {
            stringBuilder.append(s).append('\n');
        }
        System.out.println(stringBuilder);
    }
}