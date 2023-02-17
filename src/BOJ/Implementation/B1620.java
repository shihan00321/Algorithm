package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
    static int N, M;
    static HashMap<String, String> pocketMon;
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
        pocketMon = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pocketMon.put(String.valueOf(i), name);
            pocketMon.put(name, String.valueOf(i));
        }
        for (int i = 0; i < M; i++)  stringBuilder.append(pocketMon.get(br.readLine())).append('\n');
    }
}