package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1676 {
    static int N, result;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //끝자리가 0이 되려면 소인수 분해를 하여 2와 5의 곱으로 나타내어야 함 -> 2의 개수는 5의 개수보다 항상 많음 -> 5의 개수가 0의 개수
        while (N >= 5) {
            result += N / 5;
            N = N / 5;
        }
    }
}