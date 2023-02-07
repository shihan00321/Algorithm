package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 분해합은 어떤 수가 주어졌을 때 그 수 + 각 자릿수의 수를 모두 더한 값
 * ex1 -> 198의 분해합 198 + 1 + 9 + 8 = 216
 * ex2 -> 207의 분해합 207 + 2 + 0 + 7 = 216
 * 216의 생성자는 198 207
 */
public class B2231 {
    static int N, result;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    public static void algo(){
        String s = String.valueOf(N);
        int start = N - s.length() * 9;
        for (int i = start; i < N; i++) {
            int num = i; // i /= 10 -> 왜 항상 1?
            int sum = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum == N) {
                result = i;
                break;
            }
        }
    }
}