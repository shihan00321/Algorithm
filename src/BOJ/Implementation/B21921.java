package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921 {
    //슬라이딩 윈도우 문제
    static int N, X, count = 1;
    static int[] blog;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        blog = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            blog[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void algo(){
        int sum = 0;
        for (int i = 1; i <= X; i++) {
            sum += blog[i]; //1~X 까지의 합
        }
        int maxSum = sum;
        int start = 1;
        int end = X;
        while (true) {
            start++;
            end++;
            if(end > N) break;
            sum = sum - blog[start - 1] + blog[end];
            if(maxSum == sum) count++;
            else if(maxSum < sum) {
                maxSum = sum;
                count = 1;
            }
        }
        if(maxSum == 0) stringBuilder.append("SAD");
        else stringBuilder.append(maxSum).append('\n').append(count);
    }
}