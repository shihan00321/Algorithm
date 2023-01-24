package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B22860 {
    static int N, M;
    static HashMap<String, Folder> folders = new HashMap<String, Folder>();
    static StringBuilder stringBuilder = new StringBuilder();
    static class Folder {
        String name;
        int fileCount;
        HashSet<String> files = new HashSet<>();
        ArrayList<Folder> childFolderList = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void addFolder(Folder folder) {
            childFolderList.add(folder);
        }

        public void addFile(String fileName) {
            files.add(fileName);
            fileCount++;
        }

        public void mergeFile(Folder otherFolder) {
            files.addAll(otherFolder.files);
            fileCount += otherFolder.fileCount;
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
        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            Folder folder = getFolder(parent);
            if(c == 1) { // folder o
                Folder other = getFolder(child);
                folder.addFolder(other);
            }
            else folder.addFile(child); //file o
        }
        dfs(getFolder("main"));
        int queryCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCount; i++) {
            String path = br.readLine();
            int index = path.lastIndexOf('/');
            String name = path.substring(index + 1, path.length());
            Folder now = getFolder(name);
            stringBuilder.append(now.files.size()).append(' ').append(now.fileCount).append('\n');
        }
    }

    public static Folder getFolder(String folderName) {
        if(folders.containsKey(folderName)) return folders.get(folderName);
        Folder folder = new Folder(folderName);
        folders.put(folderName, folder);
        return folder;
    }
    public static void dfs(Folder now){
        for(Folder next : now.childFolderList) {
            dfs(next);
            now.mergeFile(next);
        }
    }
}