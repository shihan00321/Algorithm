package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B2108 {
    static int N;
    static ArrayList<Integer> list;
    static HashMap<Integer, Integer> arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new HashMap<>();
        list = new ArrayList<>();
        int count = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            int r = Integer.parseInt(br.readLine());
            if (!arr.containsKey(r)) arr.put(r, 1);
            else arr.replace(r, arr.get(r) + 1);
            list.add(r);
            count = Math.max(count, arr.get(r));
            sum += r;
        }
        Collections.sort(list);
        avg(sum);
        median();
        mode(count);
        range();
    }
    //산술 평균, 중앙값, 최빈값, 범위
    public static void avg(double sum) {
        stringBuilder.append((int) Math.round(sum / N)).append('\n');
    }
    public static void median() {
        int index = N / 2;
        stringBuilder.append(list.get(index)).append('\n');
    }
    public static void mode(int maxCount) {
        int mode = 0; // 답
        ArrayList<Integer> result = new ArrayList<>();
        for (int key : arr.keySet()) {
            if(maxCount == arr.get(key)) {
                result.add(key);
            }
        }
        Collections.sort(result);
        if(result.size() >= 2) mode = result.get(1);
        else mode = result.get(0);
        stringBuilder.append(mode).append('\n');
    }
    public static void range() {
        stringBuilder.append(list.get(N - 1) - list.get(0));
    }
}