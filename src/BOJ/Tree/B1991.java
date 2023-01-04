package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
    static int N;
    static Tree tree = new Tree();
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        pre_order(tree.root); //전위
        stringBuilder.append('\n');
        in_order(tree.root); //중위
        stringBuilder.append('\n');
        post_order(tree.root); //후위
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
    private static void pre_order(Node root){
        stringBuilder.append(root.data);
        if(root.left != null) pre_order(root.left);
        if(root.right != null) pre_order(root.right);
    }
    private static void in_order(Node root) {
        if(root.left != null) in_order(root.left);
        stringBuilder.append(root.data);
        if(root.right != null) in_order(root.right);
    }
    private static void post_order(Node root) {
        if(root.left != null) post_order(root.left);
        if(root.right != null) post_order(root.right);
        stringBuilder.append(root.data);
    }
    static class Node {
        char data;
        Node left, right;
        public Node(char data) {this.data = data;}
    }
    static class Tree {
        Node root;
        public void createNode(char par, char left, char right){
            if(root == null) {
                root = new Node(par);
                root.left = (left != '.' ? new Node(left) : null);
                root.right = (right != '.' ? new Node(right) : null);
            }
            else searchNode(par, root, left, right);
        }
        public void searchNode(char par, Node node, char left, char right){
            if(node == null) return;
            if(node.data == par) {
                if(left != '.') node.left = new Node(left);
                if(right != '.') node.right = new Node(right);
            }
            else {
                searchNode(par, node.left, left, right);
                searchNode(par, node.right, left, right);
            }
        }
    }
}