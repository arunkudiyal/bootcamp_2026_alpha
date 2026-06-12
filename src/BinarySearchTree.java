import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    BinarySearchTree() { root = null; }

    public void inOrderTraversal(Node node) {
        if(node != null) {
            inOrderTraversal(node.left);        // L
            System.out.print(node.data + " ");  // D
            inOrderTraversal(node.right);       // R
        }
    }

    public void levelOrderTraversal(Node node) {
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();     // queue is empty
        queue.add(node);
        while( !queue.isEmpty() ) {
            Node temp = queue.poll();

            System.out.print(temp.data + " ");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }

    public void insert(int data) { root = insertData(root, data); }

    public Node insertData(Node node, int data) {
        if(node == null) node = new Node(data);
        else if(data < node.data) node.left = insertData(node.left, data);
        else if(data > node.data) node.right = insertData(node.right, data);

        return node;
    }

    public Node deleteKey(Node node, int key) {
        // phase 1 -- search the search
        if(node == null) return node;
        else if(key < node.data) node.left = deleteKey(node.left, key);
        else if(key > node.data) node.right = deleteKey(node.right, key);
        else {
            // key is found in the BST
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else {
                // case 3 -->
                node.data = findSuccessor(node.right);      // BST property gets violated
                node.right = deleteKey(node.right, node.data);
            }
        }
        return node;
    }

    public int findSuccessor(Node node) {
        int result = node.data; Node temp = node;
        while(temp != null) {
            result = temp.data;
            temp = temp.left;
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();      // root = null | BST is empty

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i < n; i++) {
            int data = in.nextInt();
            bst.insert(data);
        }

        bst.inOrderTraversal(bst.root);
        System.out.println();

        bst.levelOrderTraversal(bst.root);
        System.out.println();

        bst.root = bst.deleteKey(bst.root, 70);
        bst.inOrderTraversal(bst.root);
    }
}
