package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B22232 {
    static int N, M;
    static ArrayList<GaheeFile> files;
    static HashSet<String> extensions;
    static StringBuilder stringBuilder = new StringBuilder();
    static class GaheeFile implements Comparable<GaheeFile> {
        String fileName;
        String ex;
        int isEx = 0;
        public GaheeFile(String fileName, String ex) {
            this.fileName = fileName;
            this.ex = ex;
        }
        @Override
        public int compareTo(GaheeFile o) {
            if(this.fileName.compareTo(o.fileName) != 0)  return this.fileName.compareTo(o.fileName);
            if(this.isEx != o.isEx) return o.isEx - this.isEx;
            return this.ex.compareTo(o.ex);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        files = new ArrayList<>();
        extensions = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String fileName = st.nextToken();
            String ex = st.nextToken();
            GaheeFile file = new GaheeFile(fileName, ex);
            files.add(file);
        }
        for (int i = 0; i < M; i++) {
            extensions.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            if(extensions.contains(files.get(i).ex)) files.get(i).isEx = 1;
        }
        Collections.sort(files);
        for (int i = 0; i < N; i++) {
            stringBuilder.append(files.get(i).fileName).append('.').append(files.get(i).ex).append('\n');
        }
    }
}