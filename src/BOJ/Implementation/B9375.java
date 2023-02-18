package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B9375 {
    static int T, n, result;
    static HashMap<String, Integer> dressRoom;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            dressRoom = new HashMap<>();
            result = 1;
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] dress = br.readLine().split(" ");
                if(!dressRoom.containsKey(dress[1])) dressRoom.put(dress[1], 1);
                else dressRoom.replace(dress[1], dressRoom.get(dress[1]) + 1);
            }
            for (String key : dressRoom.keySet()) {
                result *= dressRoom.get(key) + 1; // 각 옷을 입는 경우 + 안 입는경우(1)
            }
            stringBuilder.append(result - 1).append('\n');
        }
    }
}