package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B15970 {
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        int N, color, coord;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String dot = br.readLine();
            coord = Integer.parseInt(dot.split(" ")[0]);
            color = Integer.parseInt(dot.split(" ")[1]);
            list[color].add(coord);
        }
        algo(N);
    }
    public static void algo(int N){
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                int toLeft = toLeft(i, j);
                int toRight = toRight(i, j);
                sum += Math.min(toLeft, toRight);
            }
        }
        System.out.println(sum);
    }
    public static int toLeft(int color, int index){
        if(index == 0){
            return Integer.MAX_VALUE;
        }
        return list[color].get(index) - list[color].get(index - 1);
    }
    public static int toRight(int color, int index){
        if(index == list[color].size() - 1){
            return Integer.MAX_VALUE;
        }
        return list[color].get(index + 1) - list[color].get(index);
    }
}
