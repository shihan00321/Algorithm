package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B17219 {
    static int N, M;
    static HashMap<String, String> memo;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new HashMap<>();
        while (N-- > 0){
            String[] input = br.readLine().split(" ");
            String siteAddress = input[0];
            String password = input[1];
            memo.put(siteAddress, password);
        }
        while (M-- > 0) {
            String key = br.readLine();
            stringBuilder.append(memo.get(key)).append('\n');
        }
    }
}