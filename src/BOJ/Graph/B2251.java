package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2251 {
    static int[] limit;
    static boolean[] result;
    static boolean[][][] visit;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        bfs(0, 0, limit[2]);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = new boolean[201];
        visit = new boolean[201][201][201];
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void bfs(int a, int b, int c){
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(new int[]{a, b, c}));
        visit[a][b][c] = true;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if(state.bottle[0] == 0) result[state.bottle[2]] = true;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if(i == j) continue;
                    State moveState = state.move(i, j);
                    if(!visit[moveState.bottle[0]][moveState.bottle[1]][moveState.bottle[2]]) {
                        visit[moveState.bottle[0]][moveState.bottle[1]][moveState.bottle[2]] = true;
                        queue.add(moveState);
                    }
                }
            }
        }
        for (int i = 0; i < 201; i++) {
            if(result[i]) stringBuilder.append(i).append(' ');
        }
    }
    static class State {
        int[] bottle;
        public State(int[] bottle) {
            this.bottle = bottle;
        }
        public State move(int i, int j){ //i -> j로 이동
            int[] moveBottle = new int[]{bottle[0], bottle[1], bottle[2]};
            if(bottle[i] + bottle[j] > limit[j]){  //물이 흘러넘치는 경우
                moveBottle[i] = moveBottle[i] + moveBottle[j] - limit[j];
                moveBottle[j] = limit[j];
            }
            else {
                moveBottle[j] = bottle[i] + bottle[j];
                moveBottle[i] = 0;
            }
            return new State(moveBottle);
        }
    }
}