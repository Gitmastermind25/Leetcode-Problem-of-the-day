public class problem48 {

    // TreeNode inside same class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 2 + node.val;

        // If leaf node
        if (node.left == null && node.right == null) {
            return current;
        }

        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static void main(String[] args) {

        /*
                Example Tree:
                    1
                   / \
                  0   1
                 / \   \
                0   1   1
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        int result = sumRootToLeaf(root);
        System.out.println("Sum = " + result);
    }
}