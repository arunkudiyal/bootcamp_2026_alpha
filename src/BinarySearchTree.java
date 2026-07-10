import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    TreeNode root;
    BinarySearchTree() { this.root = null; }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public TreeNode insertData(TreeNode node, int data) {
        if(node == null) return new TreeNode(data);
        else if(data < node.data) node.left = insertData(node.left, data);
        else if(data > node.data) node.right = insertData(node.right, data);

        return node;
    }

    public TreeNode search(TreeNode root, int val) {
        if(root != null && root.data != val) System.out.println(root.data);;
        if(root == null || val == root.data) return root;
        else if(val < root.data) return search(root.left, val);
        else return search(root.right, val);
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return Math.max(lHeight, rHeight) + 1;
    }

    public int maxValue(TreeNode node) {
        TreeNode temp = node; int min = Integer.MAX_VALUE;
        while(temp != null) {
            min = temp.data;
            temp = temp.right;
        }
        return min;
    }
    public TreeNode deleteNode(TreeNode node, int key) {
        if(node == null) return node;
        // phase 1 :- search for the key
        if(key < node.data) node.left = deleteNode(node.left, key);
        else if(key > node.data) node.right = deleteNode(node.right, key);
        else {
            // key is found
            // phase 2 --> delete the key
            // case 2 :- Node with exactly one child
            if(node.right == null) return node.left;
            else if(node.left == null) return node.right;
            else {
                // case 3:- Node wuth excatly 2 children
                node.data = maxValue(node.left);
                // BST properties voilate (duplicate elements)
                node.left = deleteNode(node.left, node.data);
            }
        }
        return node;
    }

    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        /* insert --> Back (.add) | Deletion --> Front (.poll) */
        queue.add(node);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            // stack.add()
            if(current.right != null) queue.add(current.right);
            if(current.left != null) queue.add(current.left);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();  // root = null
        bst.root = bst.insertData(bst.root, 24);
        bst.root = bst.insertData(bst.root, 46);
        bst.root = bst.insertData(bst.root, 9);
        bst.root = bst.insertData(bst.root, 12);
        bst.root = bst.insertData(bst.root, 39);
        bst.root = bst.insertData(bst.root, 11);
        bst.root = bst.insertData(bst.root, 38);
        bst.root = bst.insertData(bst.root, 32);
        bst.root = bst.insertData(bst.root, 7);
        bst.root = bst.insertData(bst.root, 3);
        bst.root = bst.insertData(bst.root, 50);

        bst.levelOrder(bst.root);

        System.out.println(bst.height(bst.root));

        bst.inOrder(bst.root);
        System.out.println();
        bst.search(bst.root, 30);

        System.out.println( bst.height(bst.root) );     // 5
    }
}
