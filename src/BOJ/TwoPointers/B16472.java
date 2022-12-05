package BOJ.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16472 {
    static int N;
    static String string;
    static int[] alphabet;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        alphabet = new int[26];
        string = br.readLine();
    }
    public static void algo(){
        int l = 0;
        //나온 문자 갯수
        int count  = 0;
        //문자열 길이
        int result = 0;
        for (int r = 0; r < string.length(); r++) {
            if(alphabet[(string.charAt(r)) - 'a'] == 0){
                count++;
            }
            alphabet[(string.charAt(r)) - 'a']++;
            result++;
            if(count > N){
                alphabet[(string.charAt(l)) - 'a']--;
                if(alphabet[(string.charAt(l)) - 'a'] == 0){
                    count--;
                }
                result--;
                l++;
            }
        }
        System.out.println(result);
    }
}
