// File name: problem35.java

class problem36 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Custom Pair class (to avoid JavaFX dependency)
    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static class Solution {

        /**
         * Finds the smallest subtree containing all deepest nodes.
         */
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).getKey();
        }

        /**
         * DFS returns (subtree root containing deepest nodes, depth)
         */
        private Pair<TreeNode, Integer> dfs(TreeNode root) {
            if (root == null) {
                return new Pair<>(null, 0);
            }

            Pair<TreeNode, Integer> leftResult = dfs(root.left);
            Pair<TreeNode, Integer> rightResult = dfs(root.right);

            int leftDepth = leftResult.getValue();
            int rightDepth = rightResult.getValue();

            if (leftDepth > rightDepth) {
                return new Pair<>(leftResult.getKey(), leftDepth + 1);
            }

            if (leftDepth < rightDepth) {
                return new Pair<>(rightResult.getKey(), rightDepth + 1);
            }

            return new Pair<>(root, leftDepth + 1);
        }
    }

    // -------- MAIN METHOD (INPUT ADDED HERE) --------
    public static void main(String[] args) {

        /*
            Example Tree:
                    3
                   / \
                  5   1
                 / \   \
                6   2   8
                   / \
                  7   4

            Deepest nodes: 7 and 4
            Output subtree root: 2
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.right = new TreeNode(8);

        Solution sol = new Solution();
        TreeNode ans = sol.subtreeWithAllDeepest(root);

        System.out.println("Root of smallest subtree with all deepest nodes: " + ans.val);
    }
}
