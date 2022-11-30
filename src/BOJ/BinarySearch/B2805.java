package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    static int N, M;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static boolean cutTree(int H){
        //H로 자를 때 M만큼 얻을 수 있는가?
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] > H){
                sum += tree[i] - H;
            }
        }
        return sum >= M;
    }
    public static void algo(){
        long l = 0;
        long r = 2000000000;
        long result = 0;
        while (l <= r){
            long mid = (l + r)/2;
            if (cutTree((int) mid)){
                result = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
