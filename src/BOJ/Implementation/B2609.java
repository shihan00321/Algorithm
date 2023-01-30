package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2609 {
    static long N, M, gcd, lcm;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        stringBuilder.append(gcd).append('\n').append(lcm);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        gcd = findGCD(N, M);
        lcm = findLCM(N, M);
    }
    public static long findGCD(long n, long m){
        while (m != 0) {
            long r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
    public static long findLCM(long n, long m) {
        return n * m / gcd;
    }
}