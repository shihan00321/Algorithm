package BOJ.Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11723 {
    static int M;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        int bit = 0;
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    bit |= (1 << x);
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    bit &= ~(1 << x);
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    int check = bit & (1 << x);
                    if (check != 0) stringBuilder.append(1).append('\n');
                    else stringBuilder.append(0).append('\n');
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    int check = bit & (1 << x);
                    if (check != 0) bit &= ~(1 << x);
                    else bit |= (1 << x);
                    break;
                }
                case "all":
                    bit = (1 << 21) - 1;
                    break;
                default:
                    bit = 0;
                    break;
            }
        }
    }
}