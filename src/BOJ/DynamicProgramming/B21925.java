package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21925 {
    static int N, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static boolean isPalindrome(int l, int r){
        if((l + r) % 2 == 0) return false;
        for (int i = 0; i <= (r - l) / 2; i++) {
            if(arr[l + i] != arr[r - i]) return false;
        }
        return true;
    }
    public static void algo() {
        int j;
        for (int i = 0; i < N;) {
            boolean possible = false;
            for (j = i + 1; j < N; j += 2) {
                if(isPalindrome(i, j)){
                    possible = true;
                    result++;
                    break;
                }
            }
            if(possible) {
                i = j + 1;
            }
            else {
                result = -1;
                break;
            }
        }
    }
}