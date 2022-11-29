package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class B20291 {
    public static void main(String[] args) throws IOException {
        algo();
    }
    public static void algo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            String extension = file.substring(file.indexOf(".") + 1);
            if(treeMap.containsKey(extension)){
                Integer count = treeMap.get(extension);
                treeMap.put(extension, ++count);
            } else {
                treeMap.put(extension, 1);
            }
        }
        for (String s : treeMap.keySet()) {
            System.out.println(s + " " + treeMap.get(s));
        };
    }
}
