public class problem34 {

    static long totalSum = 0;
    static long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {

        // ===== INPUT (Tree hardcoded) =====
        // Example: [1,2,3,4,5,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int result = maxProduct(root);
        System.out.println(result);
    }

    public static int maxProduct(TreeNode root) {
        totalSum = treeSum(root);
        subtreeSum(root);
        return (int) (maxProduct % MOD);
    }

    private static long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    private static long subtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long sum = node.val + left + right;
        maxProduct = Math.max(maxProduct, sum * (totalSum - sum));

        return sum;
    }
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
