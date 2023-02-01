package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B10814 {
    static int N, count;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Member implements Comparable<Member> {
        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age == o.age) return this.order - o.order;
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Member> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            queue.add(new Member(age, name, ++count));
        }
        for (int i = 0; i < N; i++) {
            Member member = queue.poll();
            stringBuilder.append(member.age).append(' ').append(member.name).append('\n');
        }
    }
}