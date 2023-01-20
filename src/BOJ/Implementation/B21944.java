package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B21944 {
    static int N, M;
    static TreeSet<Problem> tree;
    static ArrayList<TreeSet<Problem>> problems;
    static HashMap<Integer, Problem> hashMap;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new TreeSet<>();
        hashMap = new HashMap<>();
        problems = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            problems.add(new TreeSet<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); //문제 번호
            int L = Integer.parseInt(st.nextToken()); //난이도
            int G = Integer.parseInt(st.nextToken()); //알고리즘 분류
            Problem problem = new Problem(P, L);
            tree.add(problem);
            problems.get(G).add(problem);
            hashMap.put(P, new Problem(G, L));
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                recommend(G, x);
            }
            else if(command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                recommend2(x);
            }
            else if(command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                recommend3(x, L);
            }
            else if(command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                add(P, L, G);
            }
            else {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }
    }

    private static void solved(int p) {
        Problem problem = hashMap.get(p); // hashmap -> 알고리즘 분류, 난이도가 저장되어 있음
        problems.get(problem.number).remove(new Problem(p, problem.level));
        tree.remove(new Problem(p, problem.level));
        hashMap.remove(p);
    }

    private static void add(int p, int l, int g) {
        tree.add(new Problem(p, l));
        problems.get(g).add(new Problem(p, l));
        hashMap.put(p, new Problem(g, l));
    }

    private static void recommend3(int x, int l) {
        if(x == 1) {
            Problem pro = tree.higher(new Problem(-1, l));
            if(pro == null) stringBuilder.append(-1).append('\n');
            else stringBuilder.append(pro.number).append('\n');
        }
        else {
            Problem pro = tree.lower(new Problem(-1, l));
            if(pro == null) stringBuilder.append(-1).append('\n');
            else stringBuilder.append(pro.number).append('\n');
        }
    }

    private static void recommend2(int x) {
        if(x == 1) stringBuilder.append(tree.last().number).append('\n');
        else stringBuilder.append(tree.first().number).append('\n');
    }

    private static void recommend(int g, int x) {
        if(x == 1) stringBuilder.append(problems.get(g).last().number).append('\n');
        else stringBuilder.append(problems.get(g).first().number).append('\n');
    }

    static class Problem implements Comparable<Problem>{
        int number, level;
        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level) {
                return this.number - o.number;
            }
            return this.level - o.level;
        }
    }
}