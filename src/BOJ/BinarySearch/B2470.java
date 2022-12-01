package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
    static int N;
    static int[] a;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static int binarySearch(int l, int r, int x){
        int minIndex = r;
        while (l <= r){
            int mid = (l + r) / 2;
            if(a[mid] >= x){
                minIndex = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return minIndex;
    }
    public static void algo(){
        Arrays.sort(a, 1, N + 1);
        int result = Integer.MAX_VALUE;
        int i1 = 0, i2 = 0;
        for (int i = 1; i <= N; i++) {
            //합이 0에 가장 가까우려면 -a[i]에 가장 가까운 값을 찾아야함
            int minIndex = binarySearch(i + 1, N, -a[i]);
            if(i != minIndex && Math.abs(a[minIndex] + a[i]) < result){
                result = Math.abs(a[minIndex] + a[i]);
                i1 = i;
                i2 = minIndex;
            }
            if(i < minIndex - 1 && Math.abs(a[minIndex - 1] + a[i]) < result){
                result = Math.abs(a[minIndex - 1] + a[i]);
                i1 = i;
                i2 = minIndex - 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a[i1]).append(' ').append(a[i2]);
        System.out.println(stringBuilder);
    }
}
