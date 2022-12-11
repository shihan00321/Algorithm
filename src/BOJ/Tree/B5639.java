package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639 {
    static Tree tree = new Tree();
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        post_order(tree.root);
        System.out.println(stringBuilder);
    }
    public static void post_order(Node node){
        if(node.left != null) post_order(node.left);
        if(node.right != null) post_order(node.right);
        stringBuilder.append(node.data).append('\n');
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            tree.createNode(Integer.parseInt(s));
        }
    }
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
    static class Tree {
        Node root;
        public void createNode(int data){
            if(root == null) root = new Node(data);
            else insertNode(root, data);
        }
        private void insertNode(Node root, int data) {
            if(root.data > data) {
                if (root.left == null) root.left = new Node(data);
                else insertNode(root.left, data);
            } else {
                if (root.right == null) root.right = new Node(data);
                else insertNode(root.right, data);
            }
        }
    }
}