package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5525 {
    static int N, M, result;
    static String s;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        s = br.readLine();
    }
    public static void algo(){
        int count = 0; // 'IOI'가 몇 번 나왔는지 체크. IOI = 1, IOIOI = 2;
        for (int i = 0; i < M - 2; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                count++;
                if(count == N) {
                    result++;
                    count--;
                }
                i++;
            }
            else count = 0;
        }
    }
}