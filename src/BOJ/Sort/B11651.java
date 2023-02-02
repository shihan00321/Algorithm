package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11651 {
    static int N;
    static PriorityQueue<Coord> coords;
    static StringBuilder stringBuilder = new StringBuilder();
    static class Coord implements Comparable<Coord> {
        int x, y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Coord o) {
            if(this.y == o.y) return this.x - o.x;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coords = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords.add(new Coord(x, y));
        }
        for (int i = 0; i < N; i++) {
            Coord crd = coords.poll();
            stringBuilder.append(crd.x).append(' ').append(crd.y).append('\n');
        }
    }
}