package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B22861 {
    static int N, M, K;
    static HashMap<String, Folder> folders = new HashMap<String, Folder>();
    static StringBuilder stringBuilder = new StringBuilder();
    static class Folder {
        Folder parent = null;
        String name;
        int fileCount;
        HashSet<Folder> childFolder = new HashSet<>();
        HashSet<String> files = new HashSet<>();
        public Folder(String name) {
            this.name = name;
        }
        public void addFolder(Folder folder) {
            childFolder.add(folder);
            folder.parent = this;
        }

        public void addFile(String fileName) {
            files.add(fileName);
            fileCount++;
        }

        public void eraseFolder(Folder folder) {
            childFolder.remove(folder);
        }
        
        public void mergeFile(Folder otherFolder) {
            files.addAll(otherFolder.files);
            fileCount += otherFolder.fileCount;
        }

        public void move(Folder otherFolder) {
            for(String fileName : otherFolder.files) {
                if(files.contains(fileName)) continue;
                files.add(fileName);
                fileCount++;
            }
            for (Folder folder : otherFolder.childFolder) {
                folder.parent = this;
                childFolder.add(folder); // hashSet : 중복 제거
            }
            otherFolder.parent.eraseFolder(otherFolder);
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
            if(c == 1) {
                Folder childFolder = getFolder(child);
                folder.addFolder(childFolder);
            }
            else folder.addFile(child);
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String pathA = st.nextToken();
            String pathB = st.nextToken();
            String folderA = getFolderName(pathA);
            String folderB = getFolderName(pathB);
            Folder a = getFolder(folderA);
            Folder b = getFolder(folderB);
            b.move(a);
        }
        dfs(getFolder("main"));
        int queryCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCount; i++) {
            String path = br.readLine();
            String folderName = getFolderName(path);
            Folder folder = getFolder(folderName);
            stringBuilder.append(folder.files.size()).append(' ').append(folder.fileCount).append('\n');
        }
    }
    public static Folder getFolder(String folderName) {
        if(folders.containsKey(folderName)) return folders.get(folderName);
        Folder folder = new Folder(folderName);
        folders.put(folderName, folder);
        return folder;
    }
    public static String getFolderName(String path) {
        int index = path.lastIndexOf("/");
        return path.substring(index + 1, path.length());
    }
    public static void dfs(Folder now){
        for(Folder next : now.childFolder) {
            dfs(next);
            now.mergeFile(next);
        }
    }
}