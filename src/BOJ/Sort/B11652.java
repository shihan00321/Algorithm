package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11652 {
    static HashMap<Long, Integer> hashMap = new HashMap<>();
    static int N;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            if(!hashMap.containsKey(x)) hashMap.put(x, 1);
            else hashMap.replace(x, hashMap.get(x) + 1);
        }
        int count = 0;
        long result = 0;
        ArrayList<Long> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);
        for (long key : arrayList) {
            if(count != Math.max(count, hashMap.get(key))) {
                count = Math.max(count, hashMap.get(key));
                result = key;
            }
        }
        System.out.println(result);
    }
}