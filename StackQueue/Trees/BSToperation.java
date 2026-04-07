package Trees;
class BSTOps {
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

    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.val)
            root.left = delete(root.left, key);
        else if (key > root.val)
            root.right = delete(root.right, key);
        else {
            // case 1: no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 2: two children
            Node min = findMin(root.right);
            root.val = min.val;
            root.right = delete(root.right, min.val);
        }
        return root;
    }

    Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BSTOps tree = new BSTOps();

        int[] arr = {15,10,20,8,12,17,25};
        for (int x : arr)
            tree.root = tree.insert(tree.root, x);

        // delete 10
        tree.root = tree.delete(tree.root, 10);

        // insert 14 and 9
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 9);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
    }
}