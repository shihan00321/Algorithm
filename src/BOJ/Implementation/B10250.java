package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10250 {
    static int T, H, W, N;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            algo();
        }

    }
    public static void algo(){
        int floor = N % H;
        int num = N / H + 1;
        if(floor == 0) {
            floor = H;
            num = N / H;
        }
        if(num < 10) stringBuilder.append(floor).append(0).append(num).append('\n');
        else stringBuilder.append(floor).append(num).append('\n');
    }
}