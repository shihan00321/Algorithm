package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
    static int N;
    static StringBuilder stringBuilder = new StringBuilder();
    static Tree tree = new Tree();
    public static void main(String[] args) throws IOException {
        input();
        pre_order(tree.root);
        stringBuilder.append('\n');
        in_order(tree.root);
        stringBuilder.append('\n');
        post_order(tree.root);
        System.out.println(stringBuilder);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }
    }
    private static void post_order(Node root) { //후위 순회
        if (root.left != null) post_order(root.left);
        if (root.right != null) post_order(root.right);
        stringBuilder.append(root.data);
    }
    private static void in_order(Node root) { //중위 순회
        if (root.left != null) in_order(root.left);
        stringBuilder.append(root.data);
        if (root.right != null) in_order(root.right);
    }
    private static void pre_order(Node root) { //전위 순회
        stringBuilder.append(root.data);
        if (root.left != null) pre_order(root.left);
        if (root.right != null) pre_order(root.right);
    }
    static class Tree {
        Node root;
        public void createNode(char data, char left, char right){
            if(root == null){
                root = new Node(data);
                root.left = (left != '.' ? new Node(left) : null);
                root.right = (right != '.' ? new Node(right) : null);
            } else searchTargetNode(root, data, left, right); //탐색
        }
        private void searchTargetNode(Node root, char data, char left, char right) {
            if(root == null) return;
            else if (root.data == data) {
                root.left = (left != '.') ? new Node(left) : null;
                root.right = (right != '.') ? new Node(right) : null;
            } else {
                searchTargetNode(root.left, data, left, right);
                searchTargetNode(root.right, data, left, right);
            }
        }
    }
    static class Node {
        char data;
        Node left, right;
        public Node(char data) {
            this.data = data;
        }
    }
}