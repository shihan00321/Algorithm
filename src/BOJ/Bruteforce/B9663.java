package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int N, result;
    //무조건 한 행에 하나의 퀸이 들어갈 수 밖에 없음
    static int[] col; //i,col[i]에 값이 들어있음
    public static void main(String[] args) throws IOException {
        input();
        algo(1);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
    }
    public static void algo(int row){
        if(row == N + 1) result++;
        else {
            for (int c = 1; c <= N; c++) {
                //놓을 수 있는 수인가?
                boolean possible = true;
                for (int i = 1; i < row; i++) {
                    if(checkQueen(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    algo(row + 1);
                    col[row] = 0;
                }
            }
        }
    }
    private static boolean checkQueen(int row, int c, int row2, int c2) {
        //row, c 내가 지금 놓으려는 수, row2, c2 기존에 놓은 수
        if(c == c2) return true;
        if(row + c2 ==  row2 + c) return true; //대각선
        if(row - c2 ==  row2 - c) return true; //대각선
        return false;
    }
}