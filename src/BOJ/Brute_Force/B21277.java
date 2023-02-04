package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21277 {
    static int aN, aM, bN, bM, result;
    static int[][] puzzleA, puzzleB;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        aN = Integer.parseInt(st.nextToken());
        aM = Integer.parseInt(st.nextToken());
        puzzleA = new int[101][101];
        for (int i = 1; i <= aN; i++) {
            String s = br.readLine();
            for (int j = 1; j <= aM; j++) {
                puzzleA[i][j] = Integer.parseInt(String.valueOf(s.charAt(j - 1)));
            }
        }
        st = new StringTokenizer(br.readLine());
        bN = Integer.parseInt(st.nextToken());
        bM = Integer.parseInt(st.nextToken());
        puzzleB = new int[101][101];
        for (int i = 1; i <= bN; i++) {
            String s = br.readLine();
            for (int j = 1; j <= bM; j++) {
                puzzleB[i][j] = Integer.parseInt(String.valueOf(s.charAt(j - 1)));
            }
        }
        result = Integer.MAX_VALUE;
    }
    //두 번째 퍼즐을 90도씩 회전
    public static void rotate(){
        int[][] temp = new int[101][101];
        for (int i = 1; i <= bN; i++) {
            for (int j = 1; j <= bM; j++) {
                temp[j][bN - i + 1] = puzzleB[i][j];
            }
        }
        int tp = bN;
        bN = bM;
        bM = tp;
        for (int i = 1; i <= bN; i++) {
//            for (int j = 1; j <= bM; j++) {
//                puzzleB[i][j] = temp[i][j];
//            }
            if (bM >= 0) System.arraycopy(temp[i], 1, puzzleB[i], 1, bM);
        }
    }
    //(row, col) 평행이동이 가능한가? -> 겹치는 것이 있는 지 확인
    static boolean isPossible(int row, int col) {
        for (int ai = 1; ai <= aN; ai++) {
            for (int aj = 1; aj <= aM; aj++) {
                if(puzzleA[ai][aj] == 0) continue;
                int bi = ai + row, bj = aj + col;
                if(bi >= 1 && bj >= 1 && bi <= bN && bj <= bM && puzzleB[bi][bj] == 1) return false;
            }
        }
        return true;
    }
    public static void algo() {
        //4번 회전
        for (int i = 1; i <= 4; i++) {
            rotate();
            for (int row = -51; row <= 51; row++) {
                for (int col = -51; col <= 51; col++) {
                    if(isPossible(row, col)) {
                        int v1, v2;
                        //이유?
                        int l = Math.min(1, 1 + row);
                        int r = Math.max(bN, aN + row);
                        v1 = r - l + 1;
                        l = Math.min(1, 1 + col);
                        r = Math.max(bM, aM + col);
                        v2 = r - l + 1;
                        result = Math.min(result, v1 * v2);
                    }
                }
            }
        }
    }
}