import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseCode {
    /**
     * 코딩테스트 유형
     * 1초에 1억 번의 연산이 가능함 -> 시간 복잡도 계산 시 참고
     * 완전 탐색 -> N개 중 중복을 허용o or x 해서 M개를 고르거나 나열하기
     *
     * 이분 탐색 -> 최대, 최소를 구하라
     *
     * 두 포인터 -> 연속 부분의 수열, 순서를 구하라, 곱 최소 ..
     */
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    }
    public static void algo(){

    }
}
