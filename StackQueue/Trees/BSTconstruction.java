package Trees;

class BST {
    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;

        if (key < root.val)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    boolean isValidBST(Node root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) &&
               isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {50,30,70,20,40,60,80,10,25};

        for (int x : arr)
            tree.root = tree.insert(tree.root, x);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.println("\nSearch 25: " + tree.search(tree.root, 25));
    }
}