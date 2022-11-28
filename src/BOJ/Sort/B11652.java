package BOJ.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class B11652 {
    public static int N;
    public static long[] arr;

    public static void main(String[] args) {
        input();
        algo();
    }
    public static void input(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
        }
    }

    public static void algo(){
        Arrays.sort(arr);
        int count = 1;
        int max = 1;
        long result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                count++;
            } else {
                count = 1;
            }
            if(max < count){
                max = count;
                result = arr[i];
            }
        }
        System.out.println(result);
    }
}
