package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21943 {
    static int N, P, Q, result;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(new ArrayList<>());
        for (int i = 0; i < Q + 1; i++) {
            list.add(new ArrayList<>());
        }
    }
    public static void dfs(int index){
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.print(list.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
        if(index == N) {
            boolean found = true;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).size() == 0) found = false;
            }
            if(found) {
                int now = 1;
                for (int i = 0; i < list.size(); i++) {
                    int sum = 0;
                    for (int j = 0; j < list.get(i).size(); j++) {
                        sum += list.get(i).get(j);
                    }
                    now *= sum;
                }
                result = Math.max(result, now);
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                int now = arr[index];
                list.get(i).add(now);
                dfs(index + 1);
                list.get(i).remove(list.get(i).size() - 1);
            }
        }
    }
}