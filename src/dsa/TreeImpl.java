package dsa;

public class TreeImpl {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(){
            data = 0;
            left = null;
            right = null;
        }
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class Tree{
        Node root;
        Tree(){
            root = new Node();
        }
        Tree(int data){
            root = new Node(data);
        }
        void preOrder(Node root){
            if(root == null) return;
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.right = new Node(40);
        tree.preOrder(tree.root);
    }
}
