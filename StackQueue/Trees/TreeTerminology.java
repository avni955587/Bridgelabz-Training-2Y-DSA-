package Trees;
class TreeNode {
    String name;
    TreeNode left, right;

    TreeNode(String name) {
        this.name = name;
    }
}

public class TreeTerminology {
    public static void main(String[] args) {
        TreeNode CEO = new TreeNode("CEO");
        CEO.left = new TreeNode("CTO");
        CEO.right = new TreeNode("CFO");

        CEO.left.left = new TreeNode("Dev Lead");
        CEO.left.right = new TreeNode("HR");

        CEO.left.left.left = new TreeNode("Dev1");
        CEO.left.left.right = new TreeNode("Dev2");

        // Leaf nodes
        printLeaves(CEO);

        // Height
        System.out.println("Height: " + height(CEO));

        // Depth of Dev Lead
        System.out.println("Depth of Dev Lead: " + depth(CEO, "Dev Lead", 0));
    }

    static void printLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            System.out.println("Leaf: " + root.name);
        printLeaves(root.left);
        printLeaves(root.right);
    }

    static int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int depth(TreeNode root, String target, int d) {
        if (root == null) return -1;
        if (root.name.equals(target)) return d;

        int left = depth(root.left, target, d + 1);
        if (left != -1) return left;

        return depth(root.right, target, d + 1);
    }
}