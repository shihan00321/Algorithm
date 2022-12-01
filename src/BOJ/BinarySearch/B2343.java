package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2343 {
    static int N, M;
    static int[] classTime;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        classTime = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            classTime[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static boolean isBluRay(int x){
        int minute = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            if((classTime[i] + minute) <= x){
                minute += classTime[i];
            } else {
                count++;
                minute = classTime[i];
            }
        }
        return count <= M;
    }
    public static void algo(){
//        Arrays.sort(classTime);
        //순서가 바뀌면 안되므로 sorting x

        //배열의 최대값보다 작은 블루레이 제외
        int l = 1;
        for (int i = 0; i < N; i++) {
            l = Math.max(l, classTime[i]);
        }
        int r = 1000000000;
        int result = Integer.MAX_VALUE;
        while (l <= r){
            int mid = (l + r) / 2;
            if(isBluRay(mid)){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
}
