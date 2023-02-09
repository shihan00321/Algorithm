package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15829 {
    static int L, MOD = 1234567891;
    static long result;
    static String s;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result % MOD);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        s = br.readLine();
        long pow = 1;
        for (int i = 0; i < L; i++) {
            result += ((s.charAt(i) - 96) * pow);
            pow = (pow * 31) % MOD;
        }
    }
}