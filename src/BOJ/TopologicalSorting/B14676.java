package BOJ.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14676 {
    static int N, M, K;
    static int[] inDegree, building, preBuild;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        input();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        arr = new ArrayList[N + 1];
        building = new int[N + 1];
        preBuild = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            inDegree[y]++;
        }
        //게임 정보 1 -> 건설, 2 -> 파괴
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(j == 1) {
                if(!isBuild(x)) {
                    System.out.println("Lier!");
                    return;
                }
            }
            else {
                if(!isDestroy(x)){
                    System.out.println("Lier!");
                    return;
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
    private static boolean isBuild(int x) {
        boolean isPossible = false;
        //선행 건물이 지어졌다면 건물을 지을 수 있음
        if(preBuild[x] == inDegree[x]) isPossible = true;
        if(isPossible) {
            building[x]++;
            //여러 개 지어졌다면 선행 건물을 올리면 안됨
            if(building[x] == 1){
                for(int y : arr[x]){
                    preBuild[y]++;
                }
            }
        }
        return isPossible;
    }
    private static boolean isDestroy(int x) {
        boolean isPossible = false;
        if(building[x] > 0) isPossible = true;
        if(isPossible) {
            building[x]--;
            if(building[x] == 0){
                for (int y : arr[x]){
                    inDegree[y]++;
                }
            }
        }
        return isPossible;
    }
}