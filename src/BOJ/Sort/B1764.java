package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1764 {
    static int N, M;
    static ArrayList<String> arr = new ArrayList<>();
    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(arr.size());
        Collections.sort(arr);
        for (String arg : arr) {
            System.out.println(arg);
        }
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(hashSet.contains(s)){
                arr.add(s);
            }
        }
    }
}
