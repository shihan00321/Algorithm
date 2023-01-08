package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21276 {
    static int N, M;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static ArrayList<Integer>[] arr;
    static int[] depth;
    static ArrayList<String>[] children;
    static String[] names;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList[N + 1];
        children = new ArrayList[N + 1];
        depth = new int[N + 1];
        names = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            String name = st.nextToken();
            hashMap.put(name, i);
            names[i] = name;
            children[i] = new ArrayList<>();
            arr[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String own = st.nextToken();
            String ancestor = st.nextToken();
            arr[hashMap.get(own)].add(hashMap.get(ancestor));
            arr[hashMap.get(ancestor)].add(hashMap.get(own));
            depth[hashMap.get(own)]++;
        }
        for (int i = 1; i <= N; i++) {
            for (int ance : arr[i]){
                if(depth[i] - 1 == depth[ance]) children[ance].add(names[i]);
            }
        }
    }
    public static void algo(){
        int K = 0;
        for (int i = 1; i <= N; i++) {
            if(depth[i] == 0) K++;
            Collections.sort(children[i]);
        }
        Arrays.sort(names, 1, N + 1);
        stringBuilder.append(K).append('\n');
        for (int i = 1; i <= N; i++) {
            String name = names[i];
            if(depth[hashMap.get(name)] == 0) stringBuilder.append(name).append(' ');
        }
        stringBuilder.append('\n');
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(names[i]).append(' ').
                    append(children[hashMap.get(names[i])].size()).append(' ');
            for (String child : children[hashMap.get(names[i])]) stringBuilder.append(child).append(' ');
            stringBuilder.append('\n');
        }
    }
}