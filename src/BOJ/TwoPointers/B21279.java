package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21279 {
    static int N, C, width = -1, height = 100000, count = 0;
    static long result, sum;
    static ArrayList<Crystal>[] X, Y;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        //각각 X, Y 좌표에 광석이 몇 개가 있는가?
        X = new ArrayList[100001];
        Y = new ArrayList[100001];
        for (int i = 0; i <= 100000; i++) {
            X[i] = new ArrayList<>();
            Y[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            X[x].add(new Crystal(y, v));
            Y[y].add(new Crystal(x, v));
        }
    }
    public static void algo(){
        while (width < 100000 && height >= 0) {
            if(count <= C) {
                ++width;
                for (Crystal crystal : X[width]) {
                    if(crystal.coord <= height){
                        count++;
                        sum += crystal.v;
                    }
                }
            }
            else {
                for (Crystal crystal : Y[height]) {
                    if(crystal.coord <= width){
                        count--;
                        sum -= crystal.v;
                    }
                }
                height--;
            }
            if(count <= C) result = Math.max(result, sum);
        }
    }
    static class Crystal {
        int coord, v;
        public Crystal(int coord, int v) {
            this.coord = coord;
            this.v = v;
        }
    }
}