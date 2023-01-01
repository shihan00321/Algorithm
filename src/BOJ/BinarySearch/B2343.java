package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2343 {
    static int N, M, blueRayMax;
    static int[] blueRay;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        blueRay = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            blueRay[i] = Integer.parseInt(st.nextToken());
            blueRayMax = Math.max(blueRayMax, blueRay[i]);
        }
    }
    public static void algo(){
        int l = blueRayMax;
        int r = 1000000000;
        int result = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += blueRay[i];
                if(sum > mid) {
                    count++;
                    sum = blueRay[i];
                }
            }
            if(count <= M) {
                r = mid - 1;
                result = mid;
            }
            else l = mid + 1;
        }
        System.out.println(result);
    }
}