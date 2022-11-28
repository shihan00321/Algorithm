package BOJ.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B1015 {
    public static int N;
    public static MyArray[] B;
    public static int[] P;

    public static class MyArray implements Comparable<MyArray> {
        int num, index;
        @Override
        public int compareTo(MyArray o) {
            if(o.num != this.num){
                return this.num - o.num;
            }
            return this.index - o.index;
        }
    }

    public static void main(String[] args) {
        input();
        algo();
    }

    public static void input(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        B = new MyArray[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new MyArray();
            B[i].num = scanner.nextInt();
            B[i].index = i;
        }
    }

    public static void algo(){
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].index] = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : P) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder);
    }
}
