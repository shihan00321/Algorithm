package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2251 {
    static class State{
        int[] bottle;
        public State(int[] bottle) {
            this.bottle = new int[3];
            for (int i = 0; i < 3; i++) {
                this.bottle[i] = bottle[i];
            }
        }
        public State move(int i, int j) {
            int[] moveBottle = new int[]{bottle[0], bottle[1], bottle[2]};
            if(bottle[i] + bottle[j] > limit[j]){
                moveBottle[i] = moveBottle[i] - (limit[j] - moveBottle[j]);
                moveBottle[j] = limit[j];
            } else {
                moveBottle[i] = 0;
                moveBottle[j] = bottle[i] + bottle[j];
            }
            return new State(moveBottle);
        }
    }
    static int[] limit;
    static boolean[][][] visit;
    static boolean[] possible;
    public static void main(String[] args) throws IOException {
        input();
        bfs(0, 0, limit[2]);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 201; i++) {
            if (possible[i]) stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder);
    }

    private static void bfs(int a, int b, int c) {
        Queue<State> queue = new LinkedList<>();
        visit[a][b][c] = true;
        State state = new State(new int[]{a, b, c});
        queue.add(state);
        while (!queue.isEmpty()){
            State state1 = queue.poll();
            if (state1.bottle[0] == 0) possible[state1.bottle[2]] = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    State move = state1.move(i, j);
                    if (!visit[move.bottle[0]][move.bottle[1]][move.bottle[2]]) {
                        visit[move.bottle[0]][move.bottle[1]][move.bottle[2]] = true;
                        queue.add(move);
                    }
                }
            }
        }
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[201][201][201];
        possible = new boolean[201];
    }
}
