package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int N, result;
    static int[][] chess;
    //무조건 각 열 or 행에 하나의 값이 들어가야한다.
    static int[] col;
    public static void main(String[] args) throws IOException {
        input();
        algo(0);
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];
        col = new int[N];
    }
    //row -> depth
    public static void algo(int row){
        if(row == N) {
            result++;
        }
        else {
            for (int column = 0; column < N; column++) {
                boolean check = true;
                for (int j = 0; j < row; j++) {
                    //두 개 이상의 Queen 들어왔을 때 부터 checking
                    if(!checkQueen(row, column, j, col[j])) {
                        check = false;
                        break;
                    }
                }
                if(check){
                    col[row] = column;
                    algo(row + 1);
                    col[row] = 0;
                }
            }
        }
    }
    //놓을 수 없으면 false, 있다면 true
    private static boolean checkQueen(int row, int column, int insertRow, int insertColumn) {
        //행은 비교 할 필요가 없음 -> 한 행마다 재귀가 돌아가기 때문
        // 같은 열
        if(column == insertColumn) return false;
        //대각선
        if(row + insertColumn == insertRow + column) return false;
        if(row - insertColumn == insertRow - column) return false;
        return true;
    }
}