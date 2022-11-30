package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10816 {
    static int N, M;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(key)){
                Integer value = hashMap.get(key);
                hashMap.replace(key, ++value);
            } else {
                hashMap.put(key, 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(algo(Integer.parseInt(st2.nextToken()))).append(' ');
        }
        System.out.println(stringBuilder);
    }
    public static int algo(int key){
        if(hashMap.get(key) != null){
            return hashMap.get(key);
        }
        return 0;
    }
}
