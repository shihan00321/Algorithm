package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11866 {
    static int N, K;
    static ArrayList<Integer> arr;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        stringBuilder.append('<');
    }
    public static void algo(){
        int index = 0;
        for (int i = 0; i < N - 1; i++) {
            index = (index + K - 1) % arr.size();
            stringBuilder.append(arr.get(index)).append(',').append(' ');
            arr.remove(index);
        }
        stringBuilder.append(arr.remove(0));
        stringBuilder.append('>');
    }
}