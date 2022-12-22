package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1309 {
    static int N;
    static int[][] zoo;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //a,0 아무 것도 없는 경우, a,1 왼쪽에 사자가 있는 경우, a,2 오른쪽에 사자가 있는 경우
        zoo = new int[N + 1][3];
    }
    public static void algo(){
        zoo[1][0] = 1;
        zoo[1][1] = 1;
        zoo[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            zoo[i][0] = (zoo[i - 1][0] + zoo[i - 1][1] + zoo[i - 1][2]) % 9901;
            zoo[i][1] = (zoo[i - 1][0] + zoo[i - 1][2]) % 9901;
            zoo[i][2] = (zoo[i - 1][0] + zoo[i - 1][1]) % 9901;
        }
        System.out.println((zoo[N][0] + zoo[N][1] + zoo[N][2]) % 9901);
    }
}