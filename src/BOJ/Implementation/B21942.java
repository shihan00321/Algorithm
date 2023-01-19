package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B21942 {
    static int N, F; //N 개수, F 벌금
    static String L;
    static ArrayList<String> result;
    static HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
    static HashMap<String, Long> penalty = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = st.nextToken();
        F = Integer.parseInt(st.nextToken());

        String[] inputs = L.split("/");
        int day = Integer.parseInt(inputs[0]);
        int hour = Integer.parseInt((inputs[1].split(":"))[0]);
        int minute = Integer.parseInt((inputs[1].split(":"))[1]);
        int limit = (day * 24 + hour) * 60 + minute;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int timeStamp = getTimeStamp(st.nextToken(), st.nextToken());
            String thing = st.nextToken();
            String name = st.nextToken();
            if(!map.containsKey(name)) {
                map.put(name, new HashMap<>());
                map.get(name).put(thing, timeStamp);
            }
            else {
                //이미 빌린 적 있는 사람이 다른 물건을 빌릴 경우
                if(!map.get(name).containsKey(thing)) {
                    map.get(name).put(thing, timeStamp);
                }
                //반납하는 경우
                else {
                    int time = map.get(name).get(thing);
                    long overTime = Math.max(0, timeStamp - time - limit);
                    if(!penalty.containsKey(name)) {
                        penalty.put(name, overTime * F);
                    }
                    else {
                        penalty.replace(name, penalty.get(name) + overTime * F);
                    }
                    map.get(name).remove(thing);
                }
            }
        }
    }
    //ex - 2021-01-01 09:12
    public static int getTimeStamp(String date, String time) {
        String[] inputs = date.split("-");
        int month = Integer.parseInt(inputs[1]);
        int day = Integer.parseInt(inputs[2]);
        for (int i = 1; i < month; i++) {
            day += days[i];
        }
        inputs = time.split(":");
        int hour = Integer.parseInt(inputs[0]);
        int minutes = Integer.parseInt(inputs[1]);
        return ((day - 1) * 24 + hour) * 60 + minutes;
    }
    public static void algo(){
        boolean isPenalty = false;
        result = new ArrayList<>(penalty.keySet());
        Collections.sort(result);
        for (String s : result) {
            if(penalty.get(s) == 0) continue;
            stringBuilder.append(s).append(' ').append(penalty.get(s)).append('\n');
            isPenalty = true;
        }
        if(!isPenalty) stringBuilder.append(-1);
    }
}