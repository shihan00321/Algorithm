package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * upper bound -> key 보다 큰 첫 위치를 반환
 * lower bound -> key 보다 크거나 같은 첫 위치를 반환
 */
public class B21774 {
    static int N, Q;
    static ArrayList<ArrayList<String>> logFile;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        logFile = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            logFile.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            String log = st.nextToken();
            int level = Integer.parseInt(st.nextToken());
            logFile.get(level).add(log);
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            String queryA = st.nextToken();
            String queryB = st.nextToken();
            int count = 0;
            int level = Integer.parseInt(st.nextToken());
            for (int j = level; j <= 6; j++) {
                count += countRange(logFile.get(j), queryA, queryB);
            }
            stringBuilder.append(count).append('\n');
        }
    }
    public static int lower_bound(ArrayList<String> logList, String target, int start, int end){
        while (start < end) {
            int mid = (start + end) / 2;
            if(logList.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static int upper_bound(ArrayList<String> logList, String target, int start, int end){
        while (start < end) {
            int mid = (start + end) / 2;
            if(logList.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static int countRange(ArrayList<String> logList, String left, String right) {
        int r = upper_bound(logList, right, 0, logList.size());
        int l = lower_bound(logList, left, 0, logList.size());
        return r - l;
    }
}