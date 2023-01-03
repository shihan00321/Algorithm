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
        arr = new ArrayList[N + 1];
        inDegree = new int[N + 1];
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
        boolean build = true;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gameInfo = Integer.parseInt(st.nextToken());
            int buildInfo = Integer.parseInt(st.nextToken());
            if(!isBuild(gameInfo, buildInfo)) {
                build = false;
                break;
            }
        }
        if(build) System.out.println("King-God-Emperor");
        else System.out.println("Lier!");
    }
    private static boolean isBuild(int gameInfo, int buildInfo) {
        boolean possible = false;
        if(gameInfo == 1){
            //건물을 짓는 경우
            if(preBuild[buildInfo] == inDegree[buildInfo]){
                building[buildInfo]++;
                //1개 지어질 때만 선행 건물을 지었다는 표시를 해야함.
                if(building[buildInfo] == 1) {
                    for(int y : arr[buildInfo]){
                        preBuild[y]++;
                    }
                }
                possible = true;
            }
        }
        else {
            //건물을 부수는 경우
            if(building[buildInfo] > 0) {
                building[buildInfo]--;
                possible = true;
            }
            if(building[buildInfo] == 0){
                for(int y : arr[buildInfo]){
                    preBuild[y]--;
                }
            }
        }
        return possible;
    }
}