package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {
    static int N, C;
    static int[] home;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N + 2];
        for (int i = 2; i <= N + 1; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
    }
    public static boolean isLaunch(int x){
        //첫 번째 집에는 공유기 설치.
        int count = 1;
        int last = home[2];
        for (int i = 3; i <= N + 1 ; i++) {
            if(home[i] - last >= x){
                last = home[i];
                count++;
            }
        }
        return count >= C;
    }
    public static void algo(){
        Arrays.sort(home);
        int l = 1;
        int r = 1000000000;
        int result = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(isLaunch(mid)){
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
