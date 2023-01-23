package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21771 {
    static int R, C, Rg, Cg, Rp, Cp, pillow, count;
    static String[] room;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Rg = Integer.parseInt(st.nextToken());
        Cg = Integer.parseInt(st.nextToken());
        Rp = Integer.parseInt(st.nextToken());
        Cp = Integer.parseInt(st.nextToken());
        pillow = Rp * Cp;
        room = new String[R];
        for (int i = 0; i < R; i++) {
            room[i] = br.readLine();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(room[i].charAt(j) == 'P') count++;
            }
        }
        if(count != pillow) System.out.println(1);
        else System.out.println(0);
    }
}