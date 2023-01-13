package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21919 {
    static int N;
    static long result = -1; //최소 공배수
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(isPrime(target)) {
                result = lcm(result, target);
            }
        }
    }
    //소수인지 판별
    public static boolean isPrime(int number){
        //2부터 number의 제곱근까지만 확인하면 된다 -> 모든 약수는 가운데(제곱근)를 기준으로 곱셈에 대하여 대칭이기 때문
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            //나누어 떨어지면 소수가 아님
            if(number % i == 0) return false;
        }
        return true;
    }
    //유클리드 호제법 -> 두 양의 정수 x, y (x > y)일 때 x = yq + r라면 gcd(x, y) = gcd(y, r)이 성립한다. 이때 r = 0이라면 최대 공약수는 y가 된다.
    //x,y의 최소 공배수 공식 -> (x * y) / gcd(x, y)
    //최대 공약수
    public static long gcd(long x, long y) {
        while(y != 0) {
            long r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
    //최소 공배수
    public static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}