package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B21939 {
    static int N, M;
    static TreeSet<Problem> tree;
    static HashMap<Integer, Integer> hashMap;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Problem implements Comparable<Problem> {
        int number, level;
        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }
        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level) return this.number - o.number;
            return this.level - o.level;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new TreeSet<>();
        hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            tree.add(new Problem(number, level));
            hashMap.put(number, level);
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                recommend(x);
            }
            else if(command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                add(p, l);
            }
            else {
                int p = Integer.parseInt(st.nextToken());
                solved(p);
            }
        }
    }

    private static void solved(int p) {
        int level = hashMap.get(p);
        tree.remove(new Problem(p, level));
    }

    private static void add(int p, int l) {
        hashMap.put(p, l);
        tree.add(new Problem(p, l));
    }

    private static void recommend(int x) {
        if(x == 1) {
            stringBuilder.append(tree.last().number).append('\n');
        }
        else {
            stringBuilder.append(tree.first().number).append('\n');
        }
    }
}