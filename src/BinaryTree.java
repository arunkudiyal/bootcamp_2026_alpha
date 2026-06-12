class Node {
    int data;
    Node left;
    Node right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;  // stores ref/add of the first node of BT
    BinaryTree() {
        root = null;
    }

    public void inOrderTraversal(Node node) {
        if(node != null) {
            inOrderTraversal(node.left);        // L
            System.out.print(node.data + " ");  // D
            inOrderTraversal(node.right);       // R
        }
    }
    public void preOrderTraversal(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();     // root = null | BT is empty

        tree.root = new Node(10);

        tree.root.left = new Node(20);
        tree.root.right = new Node(30);

        tree.root.right.right = new Node(70);
        tree.root.left.left = new Node(40);

        tree.root.left.left.right = new Node(50);
        tree.root.right.left = new Node(60);

        tree.inOrderTraversal(tree.root);
        System.out.println();
        tree.preOrderTraversal(tree.root);
    }
}
