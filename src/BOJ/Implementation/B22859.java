package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B22859 {
    static String html;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        algo();
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        html = br.readLine();
    }
    public static void algo(){
        int l = 0, r = html.length();
        while (l < r) {
            int title_start = html.indexOf("title=\"", l);
            if(title_start == -1) break;
            int title_end = html.indexOf("\">", title_start);
            int div_end = html.indexOf("</div>", title_start);
            stringBuilder.append("title : ").append(html.substring(title_start + 7, title_end)).append('\n');
            int cursor = l;
            while (true) {
                int start_P_Tag = html.indexOf("<p>", cursor);
                if (start_P_Tag == -1) break;
                if (start_P_Tag > div_end) break;
                int end_P_Tag = html.indexOf("</p>", start_P_Tag);
                String line = html.substring(start_P_Tag + 3, end_P_Tag);
                String newLine = erase(line);
                stringBuilder.append(newLine).append('\n');
                cursor = end_P_Tag;
            }
            l = div_end;
        }
    }

    private static String erase(String line) {
        StringBuilder newLine = new StringBuilder();
        boolean space = false;
        boolean isTag = false;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '>') {
                isTag = false;
                continue;
            }
            if(line.charAt(i) == '<') {
                isTag = true;
            }
            if(isTag) continue;
            if(line.charAt(i) == ' ') {
                if(space) continue;
                space = true;
            }
            else space = false;
            newLine.append(line.charAt(i));
        }
        return newLine.toString();
    }
}