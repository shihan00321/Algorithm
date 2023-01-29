package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B22234 {
    static int N, T, W, M;
    static Person[] wait;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Person {
        int Pid, tx, workTime;
        public Person(int pid, int tx, int workTime) {
            Pid = pid;
            this.tx = tx;
            this.workTime = workTime;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Deque<Person> deque = new ArrayDeque<>();
        wait = new Person[200001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            deque.add(new Person(id, tx, 0));
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            int cx = Integer.parseInt(st.nextToken());
            if(cx <= 200000){
                wait[cx] = new Person(id, tx, 0);
            }
        }
        for (int i = 1; i <= W; i++) {
            if(wait[i] != null) deque.addLast(wait[i]);
            Person person = deque.poll();
            assert person != null;
            stringBuilder.append(person.Pid).append('\n');
            person.tx--;
            person.workTime++;
            if(person.tx != 0){
                //T초 동안 처리를 했다면 뒤로 보내주어야 함
                if(person.workTime >= T) {
                    person.workTime = 0;
                    deque.addLast(person);
                }
                //tx가 T보다 크다면, x번 손님의 업무를 T초 동안 처리합니다.
                else deque.addFirst(person);
            }
        }
    }
}