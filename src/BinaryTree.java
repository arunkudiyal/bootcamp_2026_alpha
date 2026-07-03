class BinaryTree {
    TreeNode root;
    BinaryTree() { this.root = null; }
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    public void insert(int data) {

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // root = null
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(20);
        tree.root.right = new TreeNode(30);
        tree.root.left.left = new TreeNode(40);
        tree.root.left.right = new TreeNode(50);
        tree.root.right.left = new TreeNode(60);
        tree.root.right.right = new TreeNode(70);

        tree.inOrder(tree.root);
        System.out.println();
    }
}
